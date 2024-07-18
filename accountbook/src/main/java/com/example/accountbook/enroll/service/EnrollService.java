package com.example.accountbook.enroll.service;

import com.example.accountbook.enroll.dto.CalendarResponseDto;
import com.example.accountbook.enroll.dto.EnrollRequestDto;
import com.example.accountbook.enroll.dto.EnrollResponseDto;
import com.example.accountbook.enroll.entity.Enroll;
import com.example.accountbook.enroll.entity.EnrollType;
import com.example.accountbook.enroll.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollService {
    private final EnrollRepository enrollRepository;
    @Transactional
    public EnrollResponseDto createEnroll(EnrollRequestDto enrollRequestDto){
        Enroll enroll = new Enroll(enrollRequestDto);
        enrollRepository.save(enroll);
        return new EnrollResponseDto(enroll);
    }

    @Transactional(readOnly = true)
    public CalendarResponseDto getAllEnroll(int year, int month){
        List<Enroll> filteredEnrolls = enrollRepository.findAll().stream()
                .filter(enroll -> enroll.getDate().getYear() == year && enroll.getDate().getMonthValue() == month)
                .collect(Collectors.toList());

        List<EnrollResponseDto> enrollResponseDtos = filteredEnrolls.stream()
                .map(enroll -> new EnrollResponseDto(enroll))
                .collect(Collectors.toList());

        int totalIncome = filteredEnrolls.stream()
                .filter(enroll -> enroll.getType() == EnrollType.INCOME)
                .mapToInt(Enroll::getPrice)
                .sum();

        int totalExpense = filteredEnrolls.stream()
                .filter(enroll -> enroll.getType() == EnrollType.EXPENSE)
                .mapToInt(Enroll::getPrice)
                .sum();

        return new CalendarResponseDto(totalIncome, totalExpense, enrollResponseDtos);
    }

    @Transactional(readOnly = true)
    public List<EnrollResponseDto> getEnroll(int year, int month, int day) {
        LocalDate targetDate = LocalDate.of(year, month, day);

        List<Enroll> getEnroll = enrollRepository.findAll().stream()
                .filter(enroll -> enroll.getDate().equals(targetDate))
                .collect(Collectors.toList());

        return getEnroll.stream()
                .map(enroll -> new EnrollResponseDto(enroll.getId(), enroll.getDate(), enroll.getType(), enroll.getCategory(), enroll.getContent(), enroll.getPrice()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteEnroll(Long enrollId){
        Enroll enroll = enrollRepository.findById(enrollId).orElseThrow(
                ()->new IllegalArgumentException("삭제 할 수 없습니다.")
        );
        enrollRepository.delete(enroll);
    }
}
