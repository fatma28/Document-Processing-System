package com.docusecure.docprocessingsystem.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    @GetMapping("/home")
    public Map<String, Object> homePage(@AuthenticationPrincipal UserDetails userDetails) {
        Set<String> roles = userDetails.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toSet());

        return Map.of(
                "username", userDetails.getUsername(),
                "roles", roles
        );
    }
}

