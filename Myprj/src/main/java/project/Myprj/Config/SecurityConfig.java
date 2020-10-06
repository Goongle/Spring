package project.Myprj.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // http에 인증알 할 것이다.3
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/member/myinfo").hasRole("MEMBER")
                .antMatchers("/**").permitAll()
                .and() // 로그인 설정
                .formLogin()
                .loginPage("/login") // 커스텀 로그인 Page
                .defaultSuccessUrl("/") // 로그인 성공시 이동되는 페이지로 컨트롤러에서 URL Mapping 필수
                .permitAll()
                .and() // 로그아웃 설정
                .logout() // HTTP 세션 제거
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 기본 로그아웃 페이지가 아닌 다른 것으로 커스터마이징
                .logoutSuccessUrl("/") // logout 페이지 완료 페이지
                .invalidateHttpSession(true) // HTTP 세션 초기화
                .and()
                // 403 예외처리 핸들링
                .exceptionHandling().accessDeniedPage("/user/denied"); // 접근 권한이 없을 경우 로그인 페이지로 회귀
    }

    // Password Encoder 설정
    @Bean
    public PasswordEncoder passwordEncoder()
    {
       //  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

}
