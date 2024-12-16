package springboot.security.example.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springboot.security.example.entity.Products;
import springboot.security.example.service.ProductService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    //GET ALL PRODUCTS
    @GetMapping("/products")
    public List<Products> getListCustomer(){
        return productService.productsList();
    }


    //ADD NEW PRODUCT
    @PostMapping("/create")
    public Products createProduct(@Valid @RequestBody Products products){
        return productService.create(products);
    }


    //UPDATE PRODUCT
    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable String id, @Valid @RequestBody Products products){
        return productService.updateProduct(id, products);
    }

    //DELETE PRODUCT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<?> errorHandler(MethodArgumentNotValidException exception){
        var errors = new HashMap<String, String>();

        exception.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String getMessage = objectError.getDefaultMessage();

                    errors.put(fieldName, getMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }






}
