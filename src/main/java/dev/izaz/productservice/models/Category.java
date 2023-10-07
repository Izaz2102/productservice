package dev.izaz.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//public class Category extends BaseModel{
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    //@Column
    private String name;
    //@OneToMany(mappedBy = "category")
    //private List<Product> products = new ArrayList<>();
    //this is the same relation being mapped by category attribute in the other (Product) class
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
