package ru.skypro.lessons.springboot.weblibrar.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
// Включаем поддержку Web Security.
@Configuration
// Объявляем класс SecurityConfig как класс конфигурации.
public class SecurityConfig {
    // Создаем бин userDetailsManager.
    // Он использует JdbcUserDetailsManager для работы с базой данных.
    @Autowired
    // Внедряем зависимость UserDetailsService
    // для работы с данными пользователя.
    private UserDetailsService userDetailsService;


    // Создаем бин authenticationManager и получаем его
    // из AuthenticationConfiguration.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Создаем бин SecurityFilterChain для настройки фильтра безопасности.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests(this::customizeRequest);

        return http.build();
    }
    @Bean
    // Создаем экземпляр PasswordEncoder для шифрования паролей.
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    // Создаем экземпляр DaoAuthenticationProvider
    // для работы с аутентификацией через базу данных.
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        // Устанавливаем наш созданный экземпляр PasswordEncoder
        // для возможности использовать его при аутентификации.
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    // Метод для настройки прав доступа к URL на основе ролей пользователей
    private void customizeRequest(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        try {
            registry.requestMatchers(new AntPathRequestMatcher("/admin/**"))
                    .hasAnyRole("ADMIN")  // Только для пользователей с ролью ADMIN.
                    .requestMatchers(new AntPathRequestMatcher("/**"))
                    .hasAnyRole("USER")   // Только для пользователей с ролью USER.
                    .and()
                    .formLogin().permitAll()  // Разрешаем всем доступ к форме ввода.
                    .and()
                    .logout().logoutUrl("/logout");  // Устанавливаем URL
            // для выхода из системы.

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

