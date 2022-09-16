package com.spring.ItemsData.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

import javax.sql.DataSource;

//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.*;

/**
 * Класс SecurityConfig
 * - DataSource - отвечает за подключение к БД
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private DataSource dataSource;


//	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	/**
	 * Прописание правила доступа, описание запросов которых необходимо обезопасить
	 * -.anyRequest().permitAll() - абсолютно всем авторизованным польз-ям разрешается гулять
	 * -.antMatchers("/secured/**") - есть блок сайта (админка), которую необходимо защитить
	 * -.hasAnyRole("ADMIN") - необходимы права админа
	 * -.antMatchers("/products/edit**").hasAnyRole("MANAGER", "ADMIN") -в данный блок необходимы права менеджера и	 админа
	 * -.httpBasic() - базовая уатентификация (логин, пароль) (старенькое окошко)
	 * -.formLogin() - так же можно использовть, стандартная форма
	 * -.loginPage("/login").loginProcessingUrl("/authenticateTheUser") - форма логина и указание места запроса
	 * -
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.anyRequest().permitAll()
//			.antMatchers("/secured/**").hasAnyRole("ADMIN")
			.antMatchers("/items/**").hasAnyRole("ADMIN")
//			.anyRequest().permitAll()
			.and()
//			.httpBasic();
			.formLogin()
////			.loginPage("/login")
////			.loginProcessingUrl("/authenticateTheUser")
			.permitAll();
	}
}