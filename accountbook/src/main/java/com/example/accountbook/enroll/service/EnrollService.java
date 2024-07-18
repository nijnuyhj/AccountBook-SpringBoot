package com.example.accountbook.enroll.service;

import com.example.accountbook.enroll.dto.EnrollRequestDto;
import com.example.accountbook.enroll.dto.EnrollResponseDto;
import com.example.accountbook.enroll.entity.Enroll;
import com.example.accountbook.enroll.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollService {
    private final EnrollRepository enrollRepository;

    public EnrollResponseDto createEnroll(EnrollRequestDto enrollRequestDto){
        Enroll enroll = new Enroll(enrollRequestDto);
        enrollRepository.save(enroll);
        return new EnrollResponseDto(enroll);
    }
}
