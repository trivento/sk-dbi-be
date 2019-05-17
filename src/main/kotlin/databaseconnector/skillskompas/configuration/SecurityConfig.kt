package databaseconnector.skillskompas.configuration

import com.auth0.spring.security.api.JwtWebSecurityConfigurer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*


@PropertySource("auth0.properties")
@EnableWebSecurity
@Configuration
class SecurityConfig(
        @Value(value = "\${auth0.issuer}")
        private val issuer: String,
        @Value(value = "\${auth0.apiAudience}")
        val apiAudience: String
): WebSecurityConfigurerAdapter() {


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .authorizeRequests()
//                .antMatchers(HttpMethod.PUT, "/api/task/activatetask").permitAll()
                .antMatchers(HttpMethod.POST, "/api/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/api/task/activatetask").hasAuthority("read:messages")
    }


    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = Arrays.asList("http://localhost:3000")
        configuration.allowedMethods = Arrays.asList("GET", "POST")
        configuration.allowCredentials = true
        configuration.addAllowedHeader("Authorization")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}
