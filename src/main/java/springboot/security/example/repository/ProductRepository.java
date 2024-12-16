package springboot.security.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.example.entity.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

}
