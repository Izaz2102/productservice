package dev.izaz.productservice.thirdpartyclients.productsservice.fakestore;

import dev.izaz.productservice.dtos.GenericProductDto;
import dev.izaz.productservice.exceptions.NotFoundException;
import dev.izaz.productservice.thirdpartyclients.FakeStoreProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;
    private String specificProductRequestUrl;
    private String productRequestsBaseUrl;
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }
    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        System.out.println("test 111111");
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        System.out.println("test 2");
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        //response.getStatusCode()
        if (fakeStoreProductDto == null){
            throw new NotFoundException("The requested id "+ id +" does not exist");
        }
        System.out.println("test 3");
        return fakeStoreProductDto;
    }
    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
                productRequestsBaseUrl, product, FakeStoreProductDto.class
        );
        return response.getBody();
    }
    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        System.out.println("in getAllProducts() Service 1");
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);
        System.out.println("in getAllProducts Service 2");

        System.out.println("before return in getAllProducts...");
        return Arrays.stream(response.getBody()).toList();
    }
    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE,requestCallback,responseExtractor,id);
        System.out.println("deleteProductById in service");
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }
    public FakeStoreProductDto upateProductById(GenericProductDto genericProductDto, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl,HttpMethod.PUT,requestCallback,responseExtractor,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }
}
