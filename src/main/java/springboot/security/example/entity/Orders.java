package springboot.security.example.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import springboot.security.example.helper.StatusPembayaran;

import java.sql.Timestamp;
import java.util.List;
import java.util.NavigableMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pesanan")
    private String id;

    @Column(name = "tanggal_pesanan")
    private Timestamp tanggalPesanan;

    @Column(name = "total_harga")
    private Integer totalHarga;

    @Column(name = "status_pembayaran")
    @NotNull(message = "status pembayaran cannot be null")
    private StatusPembayaran statusPembayaran;

//    @OneToMany()
//    @JoinColumn(name = "id_customer")
//    private List<Customers> customers;



}
