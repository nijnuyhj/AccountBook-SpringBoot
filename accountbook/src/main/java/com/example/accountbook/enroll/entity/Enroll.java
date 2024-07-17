package com.example.accountbook.enroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter

public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;
    private EnrollType type;
    private LocalDate date;
    private String category;
    private String content;
    private int price;

}
