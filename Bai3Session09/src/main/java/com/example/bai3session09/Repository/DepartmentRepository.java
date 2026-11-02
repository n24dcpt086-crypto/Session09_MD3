package com.example.bai3session09.Repository;

import com.example.bai3session09.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
