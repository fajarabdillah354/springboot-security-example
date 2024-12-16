package springboot.security.example.helper;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperHelper {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}