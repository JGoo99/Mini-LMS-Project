package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.service.BannerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// TODO

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController {

    private final BannerServiceImpl bannerService;


    @GetMapping("/admin/banner/list.do")
    public String list(Model model) {

        List<BannerDto> list = bannerService.getShowList();

        int totalCount = list.size();

        model.addAttribute("list", list);
        model.addAttribute("totalCount", totalCount);

        return "admin/banner/list";
    }

    @GetMapping("/admin/banner/add")
    public String add() {
        return "/admin/banner/add";
    }

    @PostMapping("/admin/banner/add.do")
    public String add(BannerDto parameter) {

        bannerService.add(parameter);

        return "redirect:/admin/banner/list.do";
    }

    @PostMapping("/admin/banner/delete.do")
    public String delete(String idList) {

        bannerService.del(idList);

        return "redirect:/admin/banner/list.do";
    }
}
