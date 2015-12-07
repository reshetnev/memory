package com.epam.reshetnev.memory.core.config.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // @Autowired
    // private DataSource dataSource;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder registry) throws Exception {
        /*
         * registry .inMemoryAuthentication() .withUser("siva")
         * .password("siva") .roles("USER") .and() .withUser("admin")
         * .password("admin") .roles("ADMIN","USER");
         */

        // registry.jdbcAuthentication().dataSource(dataSource);
        registry.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and().authorizeRequests().antMatchers("/index.html", "/home.html", "/login.html", "/", "/login?logout")
                .permitAll().anyRequest().authenticated()
            .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
                .csrf().csrfTokenRepository(csrfTokenRepository());
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }







    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager authenticationManager = new ProviderManager(Arrays.asList(authenticationProvider()));
        return authenticationManager;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
//        authenticationProvider.setSaltSource(saltSource());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        authenticationProvider.afterPropertiesSet();
        return authenticationProvider;
    }

//    @Bean
//    public SaltSource saltSource() throws Exception {
//        ReflectionSaltSource saltSource = new ReflectionSaltSource();
//        saltSource.setUserPropertyToUse("salt");
//        saltSource.afterPropertiesSet();
//        return saltSource;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new Md5PasswordEncoder();
//    }
//
//    @Bean
//    public FilterChainProxy springSecurityFilterChain()
//            throws ServletException, Exception {
//        List<SecurityFilterChain> securityFilterChains = new ArrayList<SecurityFilterChain>();
//        securityFilterChains.add(new DefaultSecurityFilterChain(
//                new AntPathRequestMatcher("/login**")));
//        securityFilterChains.add(new DefaultSecurityFilterChain(
//                new AntPathRequestMatcher("/resources/**")));
//        securityFilterChains.add(new DefaultSecurityFilterChain(
//                new AntPathRequestMatcher("/**"),
//                securityContextPersistenceFilter(), 
//                logoutFilter(),
//                usernamePasswordAuthenticationFilter(),
//                exceptionTranslationFilter(),
//                filterSecurityInterceptor()));
//        return new FilterChainProxy(securityFilterChains);
//    }
//
//    @Bean
//    public SecurityContextPersistenceFilter securityContextPersistenceFilter() {
//        return new SecurityContextPersistenceFilter(
//                new HttpSessionSecurityContextRepository());
//    }
//
//    @Bean
//    public ExceptionTranslationFilter exceptionTranslationFilter() {
//        ExceptionTranslationFilter exceptionTranslationFilter = new ExceptionTranslationFilter(
//                new LoginUrlAuthenticationEntryPoint("/login"));
//        AccessDeniedHandlerImpl accessDeniedHandlerImpl = new AccessDeniedHandlerImpl();
//        accessDeniedHandlerImpl.setErrorPage("/exception");
//        exceptionTranslationFilter
//                .setAccessDeniedHandler(accessDeniedHandlerImpl);
//        exceptionTranslationFilter.afterPropertiesSet();
//        return exceptionTranslationFilter;
//    }

    @Bean
    public UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter()
            throws Exception {
        UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
        usernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/login");
        usernamePasswordAuthenticationFilter.setAllowSessionCreation(true);
        SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler(
                "/");
        successHandler.setAlwaysUseDefaultTargetUrl(true);
        usernamePasswordAuthenticationFilter
                .setAuthenticationSuccessHandler(successHandler);
        usernamePasswordAuthenticationFilter
                .setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(
                        "/login?error=true"));
        usernamePasswordAuthenticationFilter.afterPropertiesSet();

        return usernamePasswordAuthenticationFilter;

    }

//    @Bean
//    public FilterSecurityInterceptor filterSecurityInterceptor()
//            throws Exception {
//        FilterSecurityInterceptor filterSecurityInterceptor = new FilterSecurityInterceptor();
//        filterSecurityInterceptor
//                .setAuthenticationManager(authenticationManager());
//        filterSecurityInterceptor
//                .setAccessDecisionManager(accessDecisionManager());
//        filterSecurityInterceptor.setRunAsManager(runAsManager());
//        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();
//        List<ConfigAttribute> configs = new ArrayList<ConfigAttribute>();
//        configs.add(new org.springframework.security.access.SecurityConfig(
//                "isAuthenticated()"));
//        requestMap.put(new AntPathRequestMatcher("/**"), configs);
//        FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource(
//                requestMap, new DefaultWebSecurityExpressionHandler());
//        filterSecurityInterceptor
//                .setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
//        filterSecurityInterceptor.afterPropertiesSet();
//
//        return filterSecurityInterceptor;
//    }
//
//    public AffirmativeBased accessDecisionManager() throws Exception {
//        List<AccessDecisionVoter> voters = new ArrayList<AccessDecisionVoter>();
//        voters.add(new WebExpressionVoter());
//        voters.add(new RoleVoter());
//        AffirmativeBased affirmativeBased = new AffirmativeBased(voters);
//        affirmativeBased.setAllowIfAllAbstainDecisions(false);
//        affirmativeBased.afterPropertiesSet();
//
//        return affirmativeBased;
//    }
//
//    @Bean
//    public RunAsManager runAsManager() throws Exception {
//        RunAsManagerImpl runAsManager = new RunAsManagerImpl();
//        runAsManager.setKey("V_RUN_AS");
//        runAsManager.afterPropertiesSet();
//        return runAsManager;
//    }

    @Bean
    public LogoutFilter logoutFilter() throws ServletException {
        List<LogoutHandler> handlers = new ArrayList<LogoutHandler>();
        handlers.add(new CookieClearingLogoutHandler("JSESSIONID"));
        handlers.add(new SecurityContextLogoutHandler());
        LogoutFilter logoutFilter = new LogoutFilter("/login",
                handlers.toArray(new LogoutHandler[] {}));
        logoutFilter.afterPropertiesSet();
        return logoutFilter;
    }







}
