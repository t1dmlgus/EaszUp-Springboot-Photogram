package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service    // 1. IoC,  2. 트랜잭션 관리
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional // Write(삽입, 수정, 삭제)
    public User 회원가입(User user){

        //회원가입 진행

        암호화Pw(user);
        권한부여(user);


        User userEntity = userRepository.save(user);
        return userEntity;
    }


    private void 권한부여(User user) {

        String role ="ROLE_USER";
        user.setRole(role);
    }

    private void 암호화Pw(User user) {
        String rowPw = user.getPassword();
        String encPw = bCryptPasswordEncoder.encode(rowPw);
        user.bcryptPw(encPw);
    }
}
