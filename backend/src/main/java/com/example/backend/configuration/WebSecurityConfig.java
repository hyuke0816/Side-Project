package com.example.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * packageName : com.example.backend.configuration
 * fileName : WebSecurityController
 * author : hyuk
 * date : 2023/01/21
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * —————————————————————————————
 * 2023/01/21         hyuk          최초 생성
 */
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true)
public class WebSecurityConfig {

}
