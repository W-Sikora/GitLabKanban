package pl.wsikora.kanban.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**", "/signIn/**", "/register/**").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
//                .antMatchers("signIn").permitAll()
//                .antMatchers("/board/**", "/dashboard/**", "gitlab_resources/**").authenticated()
//                .and()
//                .formLogin().loginPage("/")
//                .and()
//                .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("test@test.com")
//                .password("test1234")
//                .roles("USER");
//    }
}
