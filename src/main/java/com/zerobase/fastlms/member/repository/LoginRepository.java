package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// TODO
public interface LoginRepository extends JpaRepository<Login, String> {

  Optional<Login> findFirstByUserIdOrderByLoginDtDesc(String userId);

  List<Login> findByUserIdOrderByLoginDtDesc(String userID);

}
