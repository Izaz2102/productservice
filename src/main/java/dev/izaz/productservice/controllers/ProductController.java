package dev.izaz.productservice.controllers;

import java.util.List;
import java.util.UUID;

import dev.izaz.productservice.dtos.ExceptionDto;
import dev.izaz.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.izaz.productservice.dtos.GenericProductDto;
import dev.izaz.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	//@Autowired
	//field injection
	private ProductService productService;
	
	// constructor injection
	//@Autowired
	public ProductController(ProductService productService) {
	    this.productService = productService;
	}
	
	// setter injection
	//  @Autowired
	//  public void setProductService(ProductService productService) {
	//      this.productService = productService;
	//  }
	
	@GetMapping
	public List<GenericProductDto> getAllProducts() {
		System.out.println("in getAllProducts controller");
		/*return List.of(
			new GenericProductDto(),
			new GenericProductDto()
		);*/
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
		System.out.println("getProductById controller");
		return productService.getProductById(id);
	}

	//generally below method we should not write in controller class, this class is for specific to endpoints.
	/*@ExceptionHandler(NotFoundException.class)
	private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
		//System.out.println("handle not found exception");
		return new ResponseEntity(
				new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
				HttpStatus.NOT_FOUND
		);
	}*/
	
	@DeleteMapping("/{id}")
	//public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
	public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
		//return productService.deleteProductById(id);
		return new ResponseEntity<>(
				productService.deleteProductById(id),
				HttpStatus.OK
		);
	}
	
	@PostMapping()
	public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
		return productService.createProduct(product);
	}
	
	@PutMapping("/{id}")
	public GenericProductDto updateProductById(@RequestBody GenericProductDto genericProductDto, @PathVariable("id") Long id) {
		return productService.upateProductById(genericProductDto, id);
	}
}
