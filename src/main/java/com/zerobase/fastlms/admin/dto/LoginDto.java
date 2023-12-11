package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {

    private String userId;
    private String loginDt;
    private String clientIp;
    private String userAgent;
    
    public static LoginDto of(Login login) {
        return LoginDto.builder()
          .userId(login.getUserId())
          .loginDt(login.getLoginDt().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm")))
          .clientIp(login.getClientIp())
          .userAgent(login.getUserAgent())
          .build();
    }
    
}
