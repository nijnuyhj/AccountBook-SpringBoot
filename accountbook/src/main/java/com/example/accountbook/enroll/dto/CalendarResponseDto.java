package com.example.accountbook.enroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CalendarResponseDto {
    private int totalIncome;
    private int totalExpense;
    private List<EnrollResponseDto> enrolls;

}
