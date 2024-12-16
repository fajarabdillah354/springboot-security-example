package springboot.security.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_customer")
    private String id;

    @Column(name = "nama_customer")
    private String namaCustomer;


    private String Email;

    @Column(name = "nomor_telepon")
    private Long nomorTelepon;


//    @ManyToOne()
//    private Orders orders;


    private String alamat;





}
