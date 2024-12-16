package springboot.security.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.example.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, String> {

}
