package com.example.manager.controller;

import com.example.manager.model.User;
import com.example.manager.util.factory.UserFactory;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping
    public String index(@AuthenticationPrincipal OAuth2User oAuth2User) {
        return "redirect:/" + (oAuth2User == null ? "auth/login" : "dashboard");
    }

    @GetMapping("dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
        if (oAuth2User == null) return "redirect:/auth/login";

        User user = new UserFactory(oAuth2User).create();
        model.addAttribute("user", user);
        return "dashboard";
    }

    @GetMapping("/oauth/authorization/*")
    public String authorization() {
        return "redirect:/dashboard";
    }
}
