package ModuloMetricasInnovatech.Metricas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${GATEWAY_SECRET:local_test_back}")
    private String secretoCompartido;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable()) 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/**").permitAll() // Permite el health check de Render
                .anyRequest().access((authentication, context) -> {
                    String cabeceraSecreta = context.getRequest().getHeader("X-Gateway-Secret");
                    boolean headerGateway = secretoCompartido != null && secretoCompartido.equals(cabeceraSecreta);
                    return new AuthorizationDecision(headerGateway);
                })
            )
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}