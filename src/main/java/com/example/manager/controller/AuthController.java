package com.example.manager.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("login")
    public String login(@AuthenticationPrincipal OAuth2User oAuth2User) {
        if (oAuth2User != null) return "redirect:/dashboard";
        return "login";
    }
}
