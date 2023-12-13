package com.zerobase.fastlms.admin.controller;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.service.BannerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminBannerController {

    private final BannerServiceImpl bannerService;


    @GetMapping("/admin/banner/list.do")
    public String list(Model model) {

        List<BannerDto> list = bannerService.list();

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

    @RequestMapping("/admin/banner/detail.do")
    public String detail(Model model, @RequestParam String id) {

        BannerDto banner = bannerService.getDetail(id);

        model.addAttribute("banner", banner);

        return "/admin/banner/detail";
    }


    @PostMapping("/admin/banner/delete.do")
    public String delete(String idList) {

        bannerService.del(idList);

        return "redirect:/admin/banner/list.do";
    }

    @RequestMapping("/admin/banner/update.do")
    public String update(Model model, @RequestParam String id) {

        BannerDto banner = bannerService.getDetail(id);

        model.addAttribute("banner", banner);

        return "/admin/banner/update";
    }

    @PostMapping("/admin/banner/update.do")
    public String update(BannerDto request) {

        bannerService.update(request);

        return "redirect:/admin/banner/list.do";
    }
}
