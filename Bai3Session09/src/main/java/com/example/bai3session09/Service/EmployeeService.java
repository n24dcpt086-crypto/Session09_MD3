package com.example.bai3session09.Service;

import com.example.bai3session09.DTO.EmployeeCreateDTO;
import com.example.bai3session09.Entity.Department;
import com.example.bai3session09.Entity.Employee;
import com.example.bai3session09.Repository.DepartmentRepository;
import com.example.bai3session09.Repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    public Employee createEmployee(EmployeeCreateDTO dto) {
        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Không tìm thấy phòng ban có ID: "
                                + dto.getDepartmentId()));
        Employee employee = new Employee();

        employee.setFullName(dto.getFullName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());

        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }
}
