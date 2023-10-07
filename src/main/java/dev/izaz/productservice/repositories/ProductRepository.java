package dev.izaz.productservice.repositories;

import dev.izaz.productservice.dtos.GenericProductDto;
import dev.izaz.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    //GenericProductDto findById(Long id);

}
