package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;

import java.util.List;

// TODO

public interface BannerService {
    
    List<BannerDto> getShowList();

    void add(BannerDto banner);

    boolean update(BannerDto banner);

    void del(String bannerId);

}
