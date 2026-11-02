package com.example.bai1session09.Repository;

import com.example.bai1session09.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
