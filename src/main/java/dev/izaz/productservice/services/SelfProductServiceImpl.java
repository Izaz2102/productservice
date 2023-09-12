package dev.izaz.productservice.services;

import org.springframework.stereotype.Service;

import dev.izaz.productservice.dtos.GenericProductDto;

import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{
	@Override
    public GenericProductDto getProductById(Long id) {
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
