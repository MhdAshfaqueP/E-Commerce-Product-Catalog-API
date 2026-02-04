package ecommerce.catalog.service;

import ecommerce.catalog.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Service class for managing products.
 * Uses an in-memory ArrayList to store product data.
 */
@Service
public class ProductService {

    // In-memory storage for products
    private final List<Product> productList = new ArrayList<>();
    
    // Atomic counter for generating unique IDs
    private final AtomicLong idCounter = new AtomicLong(1);

    /**
     * Adds a new product to the list.
     * Assigns a unique ID to the product.
     *
     * @param product The product to add.
     * @return The added product with its generated ID.
     */
    public Product addProduct(Product product) {
        product.setId(idCounter.getAndIncrement());
        productList.add(product);
        return product;
    }

    /**
     * Retrieves all products.
     *
     * @return A list of all products.
     */
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList); // Return a copy to protect internal list
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return An Optional containing the product if found, or empty if not.
     */
    public Optional<Product> getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return true if the product was found and deleted, false otherwise.
     */
    public boolean deleteProduct(Long id) {
        return productList.removeIf(product -> product.getId().equals(id));
    }
}
