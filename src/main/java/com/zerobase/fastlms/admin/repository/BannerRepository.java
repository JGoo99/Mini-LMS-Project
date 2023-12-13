package com.zerobase.fastlms.admin.repository;

import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TODO

public interface BannerRepository extends JpaRepository<Banner, Long> {
  List<Banner> findTop3ByShowYnIsTrueOrderByShowNumber();

}
