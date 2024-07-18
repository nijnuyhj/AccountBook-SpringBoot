package com.example.accountbook.enroll.repository;

import com.example.accountbook.enroll.entity.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepository extends JpaRepository<Enroll,Long> {

}
