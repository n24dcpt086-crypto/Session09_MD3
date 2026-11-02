package com.example.bai3session09.Controller;

import com.example.bai3session09.DTO.ApiResponse;
import com.example.bai3session09.DTO.EmployeeCreateDTO;
import com.example.bai3session09.Entity.Employee;
import com.example.bai3session09.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(
            @Valid @RequestBody EmployeeCreateDTO dto) {

        Employee employee = employeeService.createEmployee(dto);

        ApiResponse<Employee> response = new ApiResponse<>(
                "SUCCESS",
                "Thêm nhân viên thành công",
                employee
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
