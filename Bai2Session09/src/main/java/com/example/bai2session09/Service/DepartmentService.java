package com.example.bai2session09.Service;

import com.example.bai2session09.DTO.DepartmentDTO;
import com.example.bai2session09.Entity.Department;
import com.example.bai2session09.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department createDepartment(DepartmentDTO dto) {

        Department department = new Department();

        department.setName(dto.getName());
        department.setDescription(dto.getDescription());

        return departmentRepository.save(department);
    }
}
