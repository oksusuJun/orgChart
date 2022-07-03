package com.daou.orgChart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainView() {
        return "index";
    }

    @RequestMapping("/test")
    public String getMessaage(Model model) {
        model.addAttribute("testSTR", "이제부터는 타임리프로 사용하세요!!!!!!!!");
        return "testView";
    }

}
