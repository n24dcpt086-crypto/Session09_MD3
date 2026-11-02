package com.example.bai1session09.Controller;

import com.example.bai1session09.Entity.Department;
import com.example.bai1session09.Service.DepartmentService;
import com.example.bai1session09.dto.DepartmentDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @Valid @RequestBody DepartmentDTO dto) {

        Department department = departmentService.createDepartment(dto);

        return new ResponseEntity<>(
                department,
                HttpStatus.CREATED
        );
    }
}
