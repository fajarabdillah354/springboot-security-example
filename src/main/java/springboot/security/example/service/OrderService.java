package springboot.security.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.security.example.entity.Orders;
import springboot.security.example.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    //ListOrder
    public List<Orders> ordersList(){
        return orderRepository.findAll();
    }

    public Orders createOrder(Orders orders){
        return orderRepository.save(orders);
    }

    public ResponseEntity<Orders> updateOrders(String id, Orders orders){
        return orderRepository.findById(id)
                .map(objectOrder -> {
                    Orders addOrders = new Orders();
                    addOrders.setTanggalPesanan(orders.getTanggalPesanan());
                    addOrders.setTotalHarga(orders.getTotalHarga());
                    addOrders.setStatusPembayaran(orders.getStatusPembayaran());

                    return ResponseEntity.ok(orderRepository.save(addOrders));
                })
                .orElse(ResponseEntity.notFound().build());
    }


    public ResponseEntity<?> deleteOrder(String id){
        Optional<Orders> optional = orderRepository.findById(id);
        if (optional.isPresent()){
            orderRepository.delete(optional.get());
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
