package com.example.accountbook.enroll.controller;

import com.example.accountbook.enroll.dto.CalendarResponseDto;
import com.example.accountbook.enroll.dto.EnrollRequestDto;
import com.example.accountbook.enroll.dto.EnrollResponseDto;
import com.example.accountbook.enroll.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EnrollController {
    private final EnrollService enrollService;

    @PostMapping("/enrolls")
    public ResponseEntity<EnrollResponseDto>createEnroll(@RequestBody EnrollRequestDto enrollRequestDto){
        EnrollResponseDto enrollResponseDto = enrollService.createEnroll(enrollRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollResponseDto);
    }

    @GetMapping("/enrolls/{year}/{month}")
    public ResponseEntity<CalendarResponseDto>getAllEnroll(@PathVariable int year, @PathVariable int month){
        CalendarResponseDto calendarResponseDto = enrollService.getAllEnroll(year,month);
        return ResponseEntity.ok(calendarResponseDto);
    }

    @GetMapping("/enrolls/{year}/{month}/{day}")
    public ResponseEntity<List<EnrollResponseDto>>getEnroll(@PathVariable int year, @PathVariable int month, @PathVariable int day){
        List<EnrollResponseDto> getEnroll = enrollService.getEnroll(year, month, day);
        return ResponseEntity.ok(getEnroll);
    }


    @DeleteMapping("/enrolls/{enrollId}")
    public ResponseEntity<Void>deleteEnroll(@PathVariable Long enrollId){
        enrollService.deleteEnroll(enrollId);
        return ResponseEntity.ok().build();
    }
}
