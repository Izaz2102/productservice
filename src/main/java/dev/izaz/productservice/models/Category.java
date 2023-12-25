package dev.izaz.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//public class Category extends BaseModel{
public class Category {
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    //@GeneratedValue(generator = "izaz")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    //@Column(columnDefinition = "CHAR(32)")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    //@UuidGenerator
    private UUID catId;

    @Column
    private String name;
    //@OneToMany(mappedBy = "category")
    //private List<Product> products = new ArrayList<>();
    //this is the same relation being mapped by category attribute in the other (Product) class
    //this is the inverse side of the relationship

    public UUID getCatId() {
        return catId;
    }

    public void setCatId(UUID catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
// class Group {
//   m:m
//   List<User> members;
//   m:m
//   List<User> admins;
//
//   1----> 1
//   m<---- 1
//   m   :  1
//   User creator;
// }
