package com.oshovskii.lesson.controller;

import com.oshovskii.lesson.model.Product;
import com.oshovskii.lesson.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/search_by_title")
    public Product searchByTitle(@RequestParam String title) {
        return productRepository.findByTitle(title).get();
    }

    @GetMapping("/search_by_greater_min_price")
    public List<Product> searchByMinPrice(@RequestParam(name = "minPrice") Integer minPrice) {
        return productRepository.findAllByPriceIsGreaterThanEqual(minPrice);
    }

    @GetMapping("/search_by_less_max_price")
    public List<Product> searchByMaxPrice(@RequestParam(name = "maxPrice") Integer maxPrice) {
        return productRepository.findAllByPriceIsLessThanEqual(maxPrice);
    }

    // http://localhost:8189/app/products/search_by_between_min_price_max_price?minPrice=10000&maxPrice=15000
    @GetMapping("/search_by_between_min_price_max_price")
    public List<Product> searchByBetweenMinPriceToMaxPrice(@RequestParam(name = "minPrice") Integer minPrice, @RequestParam(name = "maxPrice") Integer maxPrice) {
        return productRepository.findAllByPriceIsBetween(minPrice, maxPrice);
    }

    @GetMapping("/delete/{id}")
    public Product deleteById(@PathVariable Long id) {
        return productRepository.getOne(id);
    }

    //http://localhost:8189/app/products/add_product
    @GetMapping("/add_product")
    public Product addProduct(@PathVariable Long id) {
        return productRepository.save(new Product("super cat", 9999));
    }
}
