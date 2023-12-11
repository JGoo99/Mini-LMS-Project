package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public List<BannerDto> getShowList() {
        List<Banner> banners =
          bannerRepository.findAllByShowYnIsTrueOrderByShowNumber();
        return BannerDto.of(banners);
    }

    @Override
    public void add(BannerDto bannerDto) {
        bannerRepository.save(BannerDto.toBanner(bannerDto));
    }

    @Override
    public boolean update(BannerDto banner) {
        return false;
    }

    @Override
    public boolean del(long bannerId) {
        return false;
    }
}
