package dev.izaz.productservice.services;

import dev.izaz.productservice.dtos.GenericProductDto;
import dev.izaz.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
	GenericProductDto getProductById(Long id) throws NotFoundException;
	GenericProductDto createProduct(GenericProductDto product);
	List<GenericProductDto> getAllProducts();
	GenericProductDto deleteProductById(Long id);
	GenericProductDto upateProductById(GenericProductDto genericProductDto, Long id);
}
