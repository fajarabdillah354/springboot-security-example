package springboot.security.example.provider;

import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.flywaydb.core.internal.schemahistory.BaseAppliedMigration;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import springboot.security.example.dto.AppUserDto;
import springboot.security.example.entity.AppUser;
import springboot.security.example.helper.PasswordEncoder;
import springboot.security.example.service.AppUserService;


@Component
@AllArgsConstructor
public class UsernamePasswordAuthProvider implements AuthenticationProvider {

    //penggunakan constructor base dependecy injection
    private final AppUserService appUserService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        UserDetails userDetails = appUserService.loadUserByUsername(username);

        if (!passwordEncoder.bCryptPasswordEncoder().matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("invalid.username.password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
