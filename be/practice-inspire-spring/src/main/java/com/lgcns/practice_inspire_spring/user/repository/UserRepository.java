package com.lgcns.practice_inspire_spring.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.practice_inspire_spring.user.domain.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public UserEntity findByEmailAndPasswd(String email, String passwd);
}
