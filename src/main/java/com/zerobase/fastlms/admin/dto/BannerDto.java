package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BannerDto {

    private Long id;
    private String bannerName;
    private String imageInfo;
    private String imageUrl;
    private String clickTarget;
    private int showNumber;
    private boolean showYn;
    private String regDt;
    
    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
          .id(banner.getId())
          .bannerName(banner.getBannerName())
          .imageInfo(banner.getImageInfo())
          .imageUrl(banner.getImageUrl())
          .clickTarget(banner.getClickTarget())
          .showNumber(banner.getShowNumber())
          .showYn(banner.isShowYn())
          .regDt(banner.getRegDt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm")))
          .build();
    }

    public static Banner toBanner(BannerDto bannerDto) {
        return Banner.builder()
          .bannerName(bannerDto.getBannerName())
          .imageInfo(bannerDto.getImageInfo())
          .imageUrl(bannerDto.getImageUrl())
          .clickTarget(bannerDto.getClickTarget())
          .showNumber(bannerDto.getShowNumber())
          .showYn(bannerDto.isShowYn())
          .regDt(LocalDateTime.now())
          .build();
    }

    public static List<BannerDto> of (List<Banner> banners) {
        if (banners != null) {
            List<BannerDto> bannerDtoList = new ArrayList<>();
            for(Banner x : banners) {
                bannerDtoList.add(of(x));
            }
            return bannerDtoList;
        }
        return null;
    }

}
