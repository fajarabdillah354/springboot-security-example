package springboot.security.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import springboot.security.example.entity.Orders;
import springboot.security.example.service.OrderService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Orders> ordersList(){
        return orderService.ordersList();
    }

    @PostMapping("/create")
    public Orders createOrders(@RequestBody Orders orders){
        return orderService.createOrder(orders);
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> updateOrders(@PathVariable String id, @RequestBody Orders orders){
        return orderService.updateOrders(id, orders);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteOrders(@PathVariable String id){
        return orderService.deleteOrder(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> hadlerError(MethodArgumentNotValidException exception){

        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(objectError -> {

                    String fieldName = ((FieldError) objectError).getField();
                    String messageError = objectError.getDefaultMessage();
                    errors.put(fieldName, messageError);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }




}
