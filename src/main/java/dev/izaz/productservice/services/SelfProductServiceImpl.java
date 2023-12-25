package dev.izaz.productservice.services;

import dev.izaz.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.izaz.productservice.dtos.GenericProductDto;

import java.util.List;

@Primary
@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
	@Override
    public GenericProductDto getProductById(Long id) {
        //return productRepository.findById(id);
        return null;
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
    @Override
    public GenericProductDto deleteProductById(Long id) { return null; }
    @Override
    public GenericProductDto upateProductById(GenericProductDto genericProductDto, Long id) {
        return null;
    }
}
