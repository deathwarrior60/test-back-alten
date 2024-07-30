package wl.sop.testtech.api;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private String description;
    private int price;
    private int quantity;
    @Column(name = "INVENTORYSTATUS")
    private String inventoryStatus;
    private String category;
    private String image;
    private int rating;
}
