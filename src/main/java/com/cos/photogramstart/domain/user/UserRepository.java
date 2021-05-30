package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받으면 어노테이션이 자동으로 IoC 등록된 
public interface UserRepository extends JpaRepository<User, Long> {
    
}
