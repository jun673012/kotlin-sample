package com.example.ktl.auth.config

import jakarta.servlet.DispatcherType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SpringSecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf { csrf -> csrf.disable() }.cors { cors -> cors.disable() }
            .authorizeHttpRequests { request -> request
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers("/status", "/images/**", "/view/join", "/auth/join").permitAll()
                    .anyRequest().authenticated()
            } // 어떠한 요청이라도 인증필
            .formLogin { login -> login // form 방식 로그인 사용
                    .loginPage("/view/login")	// [A] 커스텀 로그인 페이지 지정
                    .loginProcessingUrl("/login-process")	// [B] submit 받을 url
                    .usernameParameter("userid")	// [C] submit할 아이디
                    .passwordParameter("pw")	// [D] submit할 비밀번호
                    .defaultSuccessUrl("/view/dashboard", true)
                    .permitAll()
            } // 대시보드 이동이 막히면 안되므로 얘는 허용
            .logout(withDefaults()) // 로그아웃은 기본설정으로 (/logout으로 인증해제)

        return http.build()
    }

}