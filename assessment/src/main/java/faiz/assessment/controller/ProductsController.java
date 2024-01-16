package faiz.assessment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.validation.Valid;

import faiz.assessment.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import faiz.assessment.exception.ResourceNotFoundException;
import faiz.assessment.repository.ProductsRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductsController {
	@Autowired
	private ProductsRepository productsRepository;

	@GetMapping("/products")
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

    @GetMapping("/products/{id}")
	public ResponseEntity<Products> getProductsById(@PathVariable(value = "id") Long productId)
        throws ResourceNotFoundException {
            Objects.requireNonNull(productId, "Product ID must not be null");
            Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + productId));
        return ResponseEntity.ok().body(products);
	}

	@PostMapping("/products")
	public Products createProducts(@Valid @RequestBody Products products) {
        Objects.requireNonNull(products, "Product must not be null");
		return productsRepository.save(products);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Products> updateProducts(@PathVariable(value = "id") Long productId,
		@Valid @RequestBody Products productsDetails) throws ResourceNotFoundException {
            Objects.requireNonNull(productId, "Product ID must not be null");
            Products products = productsRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

            products.setBookTitle(productsDetails.getBookTitle());
            products.setBookAuthor(productsDetails.getBookAuthor());
            products.setBookGenre(productsDetails.getBookGenre());
            products.setBookPrice(productsDetails.getBookPrice());
            products.setBookQuantity(productsDetails.getBookQuantity());
		    final Products updatedProducts = productsRepository.save(products);
		    return ResponseEntity.ok(updatedProducts);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProducts(@PathVariable(value = "id") Long productId)
		throws ResourceNotFoundException {
            Objects.requireNonNull(productId, "Product ID must not be null");
            Products products = productsRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

            Objects.requireNonNull(products, "Customer ID must not be null");
            productsRepository.delete(products);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
	}
}