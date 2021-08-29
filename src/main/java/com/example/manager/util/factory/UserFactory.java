package com.example.manager.util.factory;

import com.example.manager.model.User;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class UserFactory {
    private final OAuth2User oAuth2User;

    public UserFactory(OAuth2User oAuth2User) {
        this.oAuth2User = oAuth2User;
    }

    public User create() {
        return new User(oAuth2User.getAttribute("email"), oAuth2User.getAttribute("name"));
    }
}