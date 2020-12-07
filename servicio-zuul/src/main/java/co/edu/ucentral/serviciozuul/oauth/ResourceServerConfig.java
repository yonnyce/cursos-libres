package co.edu.ucentral.serviciozuul.oauth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/security/**").permitAll()
		.antMatchers(HttpMethod.GET,"/api/productos/uploads/img/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/api/facultades","/api/departamentos","/api/usuarios","/api/profesores","/api/estudiantes","/api/cursos","/api/grupos","/api/preguntas","/api/evaluaciones","/api/intentosEvaluaciones","/api/periodosAcademicos").permitAll()

		.antMatchers(HttpMethod.GET,"/api/facultades/pagina","/api/departamentos/pagina","/api/usuarios/pagina","/api/profesores/pagina","/api/estudiantes/pagina","/api/cursos/pagina","/api/grupos/pagina","/api/preguntas/pagina","/api/evaluaciones/pagina","/api/intentosEvaluaciones/pagina","/api/periodosAcademicos/pagina").permitAll()
		.antMatchers(HttpMethod.GET,"/api/facultades/{id}","/api/departamentos/{id}","/api/usuarios/{id}","/api/profesores/{id}","/api/estudiantes/{id}","/api/cursos/{id}","/api/grupos/{id}","/api/preguntas/{id}","/api/evaluaciones/{id}","/api/intentosEvaluaciones/{id}","/api/periodosAcademicos/{id}").hasAnyRole("USER","ADMIN")
		
		.antMatchers("/api/facultades/**","/api/departamentos/**","/api/usuarios/**","/api/profesores/**","/api/estudiantes/**","/api/cursos/**","/api/grupos/**","/api/preguntas/**","/api/evaluaciones/**","/api/intentosEvaluaciones/**","/api/periodosAcademicos/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("POST","GET","PUT","DELETE","OPTIONS"));
		corsConfig.setAllowCredentials(true);
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization","Content-type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean <CorsFilter> bean = new FilterRegistrationBean <CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}



	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("algun_codigo_secreto_aeiou");
		return tokenConverter;
	}
}
