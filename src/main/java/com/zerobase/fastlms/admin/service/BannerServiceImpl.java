package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO

@RequiredArgsConstructor
@Service
@Slf4j
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;

    @Override
    public List<BannerDto> list() {
        return BannerDto.of(bannerRepository.findAll());
    }

    @Override
    public List<BannerDto> getShowList() {
        List<Banner> banners =
          bannerRepository.findTop3ByShowYnIsTrueOrderByShowNumber();
        return BannerDto.of(banners);
    }

    @Override
    public void add(BannerDto bannerDto) {
        bannerRepository.save(BannerDto.toBanner(bannerDto));
    }

    @Override
    public boolean update(BannerDto banner) {
        Banner b = bannerRepository.findById(banner.getId())
          .orElseThrow(() -> new RuntimeException("해당 배너를 찾지 못했습니다."));

        log.info(String.valueOf(b.getId()));

        b.setBannerName(banner.getBannerName());
        b.setImageInfo(banner.getImageInfo());
        b.setImageUrl(banner.getImageUrl());
        b.setClickTarget(banner.getClickTarget());
        b.setShowNumber(banner.getShowNumber());
        b.setShowYn(banner.isShowYn());

        bannerRepository.save(b);

        return false;
    }

    @Override
    public void del(String idList) {

        if (idList != null && idList.length() > 0) {
            String[] ids = idList.split(",");
            for (String i : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(i);
                } catch (Exception e) {
                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
    }

    @Override
    public BannerDto getDetail(String bannerId) {

        Long id = Long.parseLong(bannerId);
        Banner banner = bannerRepository.findById(id)
          .orElseThrow(() -> new RuntimeException("해당 배너를 찾지 못했습니다."));

        return BannerDto.of(banner);
    }
}
