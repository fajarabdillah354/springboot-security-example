package springboot.security.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.security.example.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, String> {




}
