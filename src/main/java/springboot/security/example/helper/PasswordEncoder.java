package springboot.security.example.helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//menggunakan @Configuration agar saat spring dijalankan bisa di ikut berjalan
@Configuration
public class PasswordEncoder {

    //penempatan @Bean ini harus dalam class @Configuration, ini bisa di letakkan di SpringBootApplication
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
