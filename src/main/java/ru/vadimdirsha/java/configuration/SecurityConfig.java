package ru.vadimdirsha.java.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * @author = Vadim Dirsha
 */
@Configuration
@ComponentScan("ru.vadimdirsha.java.configuration")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
        throws Exception {

        String sqlUsers = "SELECT username, password FROM users "
                + "WHERE username=?";

        String sqlAuth = "SELECT username, role FROM users "
                + "WHERE username=?";

        auth
            .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(sqlUsers)
                .authoritiesByUsernameQuery(sqlAuth)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests()

                .antMatchers("/professor").hasRole("Professor")
                .antMatchers("/student").hasRole("Student")

                .antMatchers("/").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/auth/login/**").permitAll()
                .antMatchers("/auth/logout").permitAll()
                .antMatchers("/auth/register").permitAll()
                .antMatchers("/auth/register/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
        .and()
            .formLogin()
                .loginPage("/auth/login")
                .loginProcessingUrl("/auth/login/processing")
                .defaultSuccessUrl("/")
                .permitAll()
        .and()
            .rememberMe()
                .tokenValiditySeconds(30)
                .key("KnowledgeCheckKey")
        .and()
            .logout()
                .logoutSuccessUrl("/")
                .permitAll()
        .and()
            .requiresChannel()
                .antMatchers("/spitter/form")
                    .requiresSecure();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
