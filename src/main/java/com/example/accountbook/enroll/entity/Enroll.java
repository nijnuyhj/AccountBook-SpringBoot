package com.example.accountbook.enroll.entity;

import com.example.accountbook.enroll.dto.EnrollRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public Enroll(EnrollRequestDto enrollRequestDto){
        this.type = enrollRequestDto.getType();
        this.date = enrollRequestDto.getDate();
        this.category = enrollRequestDto.getCategory();
        this.content = enrollRequestDto.getContent();
        this.price = enrollRequestDto.getPrice();
    }
}
