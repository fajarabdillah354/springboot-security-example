package springboot.security.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.security.example.entity.Categories;
import springboot.security.example.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/categories")
    public List<Categories> categoriesList(){
        return categoryService.categoriesList();
    }

    @PostMapping("/create")
    public Categories createCategory(@RequestBody Categories categories){
        return categoryService.createCategories(categories);
    }

    @PutMapping("/update")
    public ResponseEntity<Categories> updateCategory(@PathVariable String id, @RequestBody Categories categories){
        return categoryService.updateCategories(id, categories);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deteleCategory(String id){
        return categoryService.deleteCategory(id);
    }



}
