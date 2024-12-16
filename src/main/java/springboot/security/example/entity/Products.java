package springboot.security.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
@Entity
public class Products extends BaseAuditorEntity<String>{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_product")
    private String id;

    @NotBlank(message = "product nama cannot be blank")
    @Column(name = "nama_product")
    private String namaProduct;

    private String deskripsi;

    private Long harga;

    private Integer stok;


    @ManyToOne()
    @JoinColumn(name = "id_category")
    @JsonBackReference
    private Categories categories;



//    @ManyToMany
//    @JoinTable(
//            name = "products_customers",
//            joinColumns = {
//                    @JoinColumn(name = "customers_id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "products_id")
//            }
//    )
//    private List<Customers> customers;


}
