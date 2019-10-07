package dk.cooldev.productapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OrderLine> orderLines;
    private Double sum;
    private Date createdAt;
}
