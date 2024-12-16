package springboot.security.example.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.security.example.dto.AppUserDto;
import springboot.security.example.entity.AppUser;
import springboot.security.example.helper.ResponseData;
import springboot.security.example.service.AppUserService;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AppUserDto dto){
        AppUser user = new AppUser();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAppUserRole(dto.getAppUserRole());

        modelMapper.map(dto, AppUserDto.class);

        appUserService.registerUser(user);

        return new ResponseEntity<>("User Registered Success", HttpStatus.CREATED);

    }


}
