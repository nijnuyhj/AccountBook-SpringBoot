package com.example.accountbook.enroll.dto;

import com.example.accountbook.enroll.entity.EnrollType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class EnrollRequestDto {
    private EnrollType type;
    private LocalDate date;
    private String category;
    private String content;
    private int price;

}
