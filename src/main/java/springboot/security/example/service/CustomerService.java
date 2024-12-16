package springboot.security.example.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.security.example.dto.CustomerDto;
import springboot.security.example.entity.Customers;
import springboot.security.example.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ModelMapper modelMapper;

    //GET LIST
    public List<Customers> customersList(){
        return customerRepository.findAll();
    }


    //CREATE
    public Customers createCustomer(CustomerDto dto){

        Customers customers = new Customers();
        customers.setNamaCustomer(dto.getNamaCustomer());
        customers.setEmail(dto.getEmail());

        modelMapper.map(dto, Customers.class);

        return customerRepository.save(customers);
    }

    //UPDATE
    public ResponseEntity<Customers> updateCustomer(String id, CustomerDto dto){
        return customerRepository.findById(id)
                .map(customers -> {
                    Customers updateCustomer = new Customers();
                    updateCustomer.setNamaCustomer(dto.getNamaCustomer());
                    updateCustomer.setEmail(dto.getEmail());
                    modelMapper.map(dto, Customers.class);
                    return ResponseEntity.ok(updateCustomer);
                }).orElse(ResponseEntity.notFound().build());

    }

    //DELETE
    public ResponseEntity<?> deleteCustomer(String id){
        Optional<Customers> customers = customerRepository.findById(id);
        if (customers.isPresent()){
            customerRepository.delete(customers.get());
            return ResponseEntity.ok(customers);
        }else {
            return ResponseEntity.notFound().build();
        }

    }




}
