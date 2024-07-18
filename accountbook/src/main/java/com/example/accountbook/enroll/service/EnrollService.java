package com.example.accountbook.enroll.service;

import com.example.accountbook.enroll.dto.EnrollRequestDto;
import com.example.accountbook.enroll.dto.EnrollResponseDto;
import com.example.accountbook.enroll.entity.Enroll;
import com.example.accountbook.enroll.repository.EnrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void deleteEnroll(Long enrollId){
        Enroll enroll = enrollRepository.findById(enrollId).orElseThrow(
                ()->new IllegalArgumentException("삭제 할 수 없습니다.")
        );
        enrollRepository.delete(enroll);
    }
}
