package com.example.accountbook.enroll.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter

public class Enroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enroll_id")
    private Long id;
    private EnrollType type;
    private LocalDate date;
    private String category;
    private String content;
    private int price;

}
