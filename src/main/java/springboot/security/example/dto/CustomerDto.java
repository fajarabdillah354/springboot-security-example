package springboot.security.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerDto {


    @NotBlank(message = "nama customer cannot blank")
    private String namaCustomer;


    @Email(message = "format must be correct")
    private String email;


}
