package wl.sop.testtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wl.sop.testtech.api.Product;
import wl.sop.testtech.db.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(Product product) {
        product.setId(0);
        return this.productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @PatchMapping("/{id}")
    public boolean updateProduct(@PathVariable int id, Product product) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if (productOptional.isEmpty()) {
            return false;
        }

        Product existingProduct = productOptional.get();
        existingProduct.setCode(product.getCode());
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setInventoryStatus(product.getInventoryStatus());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setImage(product.getImage());
        existingProduct.setRating(product.getRating());

        this.productRepository.save(existingProduct);

        return true;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        this.productRepository.deleteById(id);
    }

}
