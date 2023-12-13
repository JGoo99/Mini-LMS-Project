package com.zerobase.fastlms.member.repository;

import com.zerobase.fastlms.member.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, String> {

  Optional<Login> findFirstByUserIdOrderByLoginDtDesc(String userId);

  List<Login> findTop10ByUserIdOrderByLoginDtDesc(String userID);

}
