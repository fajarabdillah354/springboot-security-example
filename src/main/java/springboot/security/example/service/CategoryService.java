package springboot.security.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.security.example.entity.Categories;
import springboot.security.example.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;



    public List<Categories> categoriesList(){
        return categoryRepository.findAll();
    }


    public Categories createCategories(Categories categories){
        if (categories.getId()!=null){
            Categories currentCategory = categoryRepository.findById(categories.getId()).get();
            currentCategory.setNamaKategori(categories.getNamaKategori());
            categories = currentCategory;
        }

        return categoryRepository.save(categories);
    }


    public ResponseEntity<Categories> updateCategories(String id, Categories categories){
        return categoryRepository.findById(id)
                .map(category -> {
                    Categories addCategory = new Categories();
                    addCategory.setNamaKategori(categories.getNamaKategori());

                    return ResponseEntity.ok(categoryRepository.save(addCategory));

                }).orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<?> deleteCategory(String id){
        Optional<Categories> optional = categoryRepository.findById(id);
        if (optional.isPresent()){
            categoryRepository.delete(optional.get());
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
