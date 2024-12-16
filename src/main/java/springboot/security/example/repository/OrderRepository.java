package springboot.security.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.example.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, String> {

}
