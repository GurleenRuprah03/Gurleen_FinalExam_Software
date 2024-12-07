package com.example.gurleen300380981.repositories;

import com.example.gurleen300380981.entities.Student;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
