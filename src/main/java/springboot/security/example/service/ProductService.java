package springboot.security.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.security.example.entity.Products;
import springboot.security.example.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    //GET LIST PRODUCT
    public List<Products> productsList(){
        return productRepository.findAll();
    }

    // CREATE
    public Products create(Products products){
        return productRepository.save(products);
    }



    //UPDATE
    public ResponseEntity<Products> updateProduct(String id, Products products){
        Optional<Products> optional = productRepository.findById(id);
        if (optional.isPresent()){
            Products current = optional.get();
            current.setNamaProduct(products.getNamaProduct());
            current.setHarga(products.getHarga());
            current.setStok(products.getStok());
            products = current;


            return ResponseEntity.ok(productRepository.save(products));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE
    public ResponseEntity<?> deleteProduct(String id){
        return (ResponseEntity<?>) productRepository.findById(id)
                .map(products -> {
                    productRepository.delete(products);
                    return ResponseEntity.ok();
                }).orElse((ResponseEntity.BodyBuilder) ResponseEntity.notFound().build());
    }


}
