package com.zerobase.fastlms.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Login {
    
    @Id
    @GeneratedValue
    private Long loginId;
    private String userId;
    private LocalDateTime loginDt;
    private String clientIp;
    private String userAgent;
}
