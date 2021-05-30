package com.cos.photogramstart.web.dto.auth;


import com.cos.photogramstart.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDto {        // 통신할 때 필요한 데이터를 담는 클래스

    @Max(20)
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
    @NotBlank
    private String name;

    @Builder
    public User toEntity(){

        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

}
