package springboot.security.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class Categories{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_categori")
    private String id;

    @Column(name = "nama_kategori")
    private String namaKategori;


    @OneToMany(mappedBy = "categories")
    @JsonManagedReference
    private List<Products> products;

}
