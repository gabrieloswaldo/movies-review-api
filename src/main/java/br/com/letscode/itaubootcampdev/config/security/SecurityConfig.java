package br.com.letscode.itaubootcampdev.config.security;

import br.com.letscode.itaubootcampdev.enumeration.UserRoleEnum;
import br.com.letscode.itaubootcampdev.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/movies").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/auth/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/scores").hasAnyRole(
                        UserRoleEnum.READER.name(), UserRoleEnum.BASIC.name(), UserRoleEnum.ADVANCED.name(), UserRoleEnum.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/api/v1/comments").hasAnyRole(
                        UserRoleEnum.BASIC.name(), UserRoleEnum.ADVANCED.name(), UserRoleEnum.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/api/v1/comments/*").hasRole(UserRoleEnum.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/api/v1/replies").hasAnyRole(
                        UserRoleEnum.BASIC.name(), UserRoleEnum.ADVANCED.name(), UserRoleEnum.ADMIN.name())
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new TokenAuthFilter(authService), UsernamePasswordAuthenticationFilter.class);
    }
}
