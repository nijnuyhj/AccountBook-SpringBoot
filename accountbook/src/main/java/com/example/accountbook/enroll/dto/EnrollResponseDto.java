package com.example.accountbook.enroll.dto;

import com.example.accountbook.enroll.entity.Enroll;
import com.example.accountbook.enroll.entity.EnrollType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@AllArgsConstructor
public class EnrollResponseDto {
    private Long id;
    private LocalDate date;
    private EnrollType type;
    private String category;
    private String content;
    private int price;

    public EnrollResponseDto(Enroll enroll) {
        this.id = enroll.getId();
        this.date = enroll.getDate();
        this.type = enroll.getType();
        this.category = enroll.getCategory();
        this.content = enroll.getContent();
        this.price = enroll.getPrice();
    }
}
