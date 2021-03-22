package projeto.pi.lanchonete.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/foods/cardapio").permitAll()
		.antMatchers("/").hasRole("ATUALIZAR/REMOVER")
		.antMatchers("/foods/form").hasRole("ADICIONAR")
		.anyRequest().authenticated()
		.and().formLogin().permitAll();
		
	}

}
