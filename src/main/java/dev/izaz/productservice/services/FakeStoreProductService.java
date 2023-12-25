package dev.izaz.productservice.services;

import dev.izaz.productservice.exceptions.NotFoundException;
import dev.izaz.productservice.thirdpartyclients.productsservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import dev.izaz.productservice.thirdpartyclients.FakeStoreProductDto;
import dev.izaz.productservice.dtos.GenericProductDto;

import java.util.ArrayList;
import java.util.List;
//@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
	private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException{
        System.out.println("test 1");
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        System.out.println("in createProduct Service 11");
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }
    @Override
    public List<GenericProductDto> getAllProducts() {
        System.out.println("in getAllProducts Service 1");
        List<GenericProductDto> answer = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()) {
            answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        System.out.println("before return in getAllProducts...");
        return answer;
    }
    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }
    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }
    @Override
    public GenericProductDto upateProductById(GenericProductDto genericProductDto, Long id) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.upateProductById(genericProductDto, id));
    }
}
