package com.example.accountbook.enroll.controller;

import com.example.accountbook.enroll.service.EnrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnrollController {
    private final EnrollService enrollService;

}
