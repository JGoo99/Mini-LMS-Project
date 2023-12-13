package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;

import java.util.List;

// TODO

public interface BannerService {

    List<BannerDto> list();

    List<BannerDto> getShowList();

    void add(BannerDto banner);

    boolean update(BannerDto banner);

    void del(String bannerId);

    BannerDto getDetail(String bannerId);
}
