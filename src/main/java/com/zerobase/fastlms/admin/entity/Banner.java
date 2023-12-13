package com.zerobase.fastlms.admin.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue
    private Long id;
    private String bannerName;
    private String imageInfo;
    private String imageUrl;
    private String clickTarget;
    private int showNumber;
    private boolean showYn;
    private LocalDateTime regDt;
}
