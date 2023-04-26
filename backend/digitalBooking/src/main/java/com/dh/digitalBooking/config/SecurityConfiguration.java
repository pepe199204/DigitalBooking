package com.dh.digitalBooking.config;

import com.dh.digitalBooking.filter.JwtRequestFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.core.Ordered;

import java.util.Arrays;

@Log4j2
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    public void configure(HttpSecurity http) throws Exception{
        final String admin= "admin";
        final String user = "user";

        http.csrf().disable().authorizeRequests()
                .antMatchers("/authenticate").permitAll()

                .antMatchers(HttpMethod.POST,"/productos/create").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/productos").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/categorias").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/categorias").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/caracteristicas").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/caracteristicas").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/roles").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/roles").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/imagenes").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/imagenes").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/provincias").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/provincias").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/ciudades").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/ciudades").hasAuthority(admin)
                .antMatchers(HttpMethod.POST,"/paises").hasAuthority(admin)
                .antMatchers(HttpMethod.PUT,"/paises").hasAuthority(admin)
                .antMatchers("/reservas/newBooking").permitAll()

                .antMatchers("/categorias/**").permitAll()
                .antMatchers("/caracteristicas/**").permitAll()
                .antMatchers("/roles/**").permitAll()
                .antMatchers("/imagenes/**").permitAll()
                .antMatchers("/ciudades/**").permitAll()
                .antMatchers("/paises/**").permitAll()
                .antMatchers("/provincias/**").permitAll()
                .antMatchers("/usuarios/**").permitAll()
                .antMatchers("/productos/listAll").permitAll()
                .antMatchers("/productos/**").permitAll()
                .antMatchers("/caracteristicas_producto/**").permitAll()

                .antMatchers("/logOut/**").permitAll()

                //Si esto no esta comentado no me deja editar los productos //.anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

//        http.logout()
//                .logoutUrl("/logOut")
//                .logoutSuccessHandler((request, response, authentication) -> {
//                    //log.info("User logged out");
//                });
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/", config);
        return cors;
    }

//    /
//            * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
//     * de esta manera uso e implemento el registro y apertura de los cors
//     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }


}
