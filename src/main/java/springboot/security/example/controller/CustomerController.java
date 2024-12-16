package springboot.security.example.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springboot.security.example.dto.CustomerDto;
import springboot.security.example.entity.Customers;
import springboot.security.example.service.CustomerService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //SHOW ALL LIST CUSTOMER
    @GetMapping("/customers")
    public List<Customers> getListCustomer(){
        return customerService.customersList();
    }


    //CREATE NEW CUSTOMER
    @PostMapping("/create")
    public Customers createCustomer(@Valid @RequestBody CustomerDto dto){
        return customerService.createCustomer(dto);
    }


    //UPDATE CUSTOMER
    @PutMapping("/update/{id}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerDto dto){
        return customerService.updateCustomer(id, dto);
    }


    //DELETE CUSTOMER
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
        return customerService.deleteCustomer(id);
    }









    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerError(MethodArgumentNotValidException exception){
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
