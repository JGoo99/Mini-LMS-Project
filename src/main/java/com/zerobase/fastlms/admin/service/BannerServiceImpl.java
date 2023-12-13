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
}
