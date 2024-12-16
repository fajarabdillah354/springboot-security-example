package springboot.security.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import springboot.security.example.entity.AppUserRole;

@Data
public class AppUserDto {


    private String username;


    private String password;


    private AppUserRole appUserRole;


}
