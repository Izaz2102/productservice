package dev.izaz.productservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//public class Product extends BaseModel {
public class Product {
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    //@UuidGenerator
    private UUID productId;

    private String title;
    private String description;
    private String image;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    @ManyToOne
    private Category category;
    private double price;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
