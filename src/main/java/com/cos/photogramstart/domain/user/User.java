package com.cos.photogramstart.domain.user;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity                                 // DB에 테이블을 생성
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;



    private String bio;                 // 자기소개
    private String webSite;             // 웹사이트

    @Column(nullable = false)
    private String email;
    private String phone;
    private String gender;

    @Column(nullable = false)
    private String name;

    private String profileImageUrl;     // 사진
    private String role;                // 권한


    private LocalDateTime createDate;

    @PrePersist                         // DB에 INSERT 되기 직전에 실행
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }


    // 패스워드 암호화
    public void  bcryptPw(String encPw){
        this.password = encPw;
    }

    // 권한부여
     public void setRole(String role){
        this.role = role;
     }


}

