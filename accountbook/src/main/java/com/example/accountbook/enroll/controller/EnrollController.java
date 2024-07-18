package com.example.accountbook.enroll.controller;

import com.example.accountbook.enroll.dto.EnrollRequestDto;
import com.example.accountbook.enroll.dto.EnrollResponseDto;
import com.example.accountbook.enroll.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnrollController {
    private final EnrollService enrollService;

    @PostMapping("/enrolls")
    public ResponseEntity<EnrollResponseDto>createEnroll(@RequestBody EnrollRequestDto enrollRequestDto){
        EnrollResponseDto enrollResponseDto = enrollService.createEnroll(enrollRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollResponseDto);
    }
}
