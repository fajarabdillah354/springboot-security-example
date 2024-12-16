package springboot.security.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.example.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);

}
