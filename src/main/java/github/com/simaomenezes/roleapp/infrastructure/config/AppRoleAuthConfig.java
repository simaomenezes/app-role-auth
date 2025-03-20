package github.com.simaomenezes.roleapp.infrastructure.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppRoleAuthConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
