package com.example.bai2session09.Controller;

import com.example.bai2session09.DTO.ApiResponse;
import com.example.bai2session09.DTO.DepartmentDTO;
import com.example.bai2session09.Entity.Department;
import com.example.bai2session09.Service.DepartmentService;
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
    public ResponseEntity<ApiResponse<Department>> createDepartment(
            @Valid @RequestBody DepartmentDTO dto) {

        Department department = departmentService.createDepartment(dto);

        ApiResponse<Department> response = new ApiResponse<>(
                "SUCCESS",
                "Tạo phòng ban thành công",
                department
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
