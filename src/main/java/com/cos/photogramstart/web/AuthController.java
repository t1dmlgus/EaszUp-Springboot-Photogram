package com.cos.photogramstart.web;


import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignUpDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@Controller     // 1. IoC,   2. 파일을 리턴하는 컨트롤러
public class AuthController {


    private final AuthService authService;


    @GetMapping("/auth/signin")
    public String signForm() {

        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    // 회원가입 버튼 -> auth/signup -> /auth/signin
    @PostMapping("/auth/signup")
    public String signup(@Valid SignUpDto signUpDto) { // key=value(x-www-form-urlencoded)

        log.info(String.valueOf(signUpDto));

        User user = signUpDto.toEntity();
        User userEntity = authService.회원가입(user);

        return "auth/signin";
    }
}
