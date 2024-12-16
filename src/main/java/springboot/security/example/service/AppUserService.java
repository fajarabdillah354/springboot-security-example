package springboot.security.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.security.example.entity.AppUser;
import springboot.security.example.repository.AppUserRepository;

import java.util.IllegalFormatCodePointException;

@Service
@Transactional
@Lazy
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)//ini bisa error maka perlu di tangkep errornya
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("username with name '%s' not found ",username)
                ));
    }

    public AppUser registerUser(AppUser user){
        boolean isUserExist = appUserRepository.findByUsername(user.getUsername()).isPresent();
        if (isUserExist){
            throw  new RuntimeException(String.format("User with name '%s' is exist ", user.getUsername()));
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return appUserRepository.save(user);

    }


}
