package com.example.ktl.auth.controller

import com.example.ktl.auth.config.AdminAuthorize
import com.example.ktl.auth.config.UserAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/view")
class ViewController {

    @GetMapping("/login")
    fun loginPage(): String {
        return "login"
    }

    @GetMapping("/join")
    fun joinPage(): String? {
        return "join"
    }

    @GetMapping("/dashboard")
    fun dashboardPage(@AuthenticationPrincipal user: User, model: Model): String? {
        model.addAttribute("loginId", user.getUsername())
        model.addAttribute("loginRoles", user.getAuthorities())
        return "dashboard"
    }

    @GetMapping("/setting/admin")
    @AdminAuthorize
    fun adminSettingPage(): String? {
        return "admin_setting"
    }

    @GetMapping("/setting/user")
    @UserAuthorize
    fun userSettingPage(): String? {
        return "user_setting"
    }
}