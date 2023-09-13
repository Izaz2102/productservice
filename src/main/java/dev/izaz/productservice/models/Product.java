package dev.izaz.productservice.models;

import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity
@Builder
public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    @ManyToOne
    private Category categery;
    private double price;

    Product(String title, String description, String image, Category categery, double price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.categery = categery;
        this.price = price;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private String title;
        private String description;
        private String image;
        private Category categery;
        private double price;

        ProductBuilder() {
        }

        public ProductBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ProductBuilder categery(Category categery) {
            this.categery = categery;
            return this;
        }

        public ProductBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this.title, this.description, this.image, this.categery, this.price);
        }

        public String toString() {
            return "Product.ProductBuilder(title=" + this.title + ", description=" + this.description + ", image=" + this.image + ", categery=" + this.categery + ", price=" + this.price + ")";
        }
    }
}
