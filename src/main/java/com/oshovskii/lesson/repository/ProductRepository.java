package com.oshovskii.lesson.repository;

import com.oshovskii.lesson.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    List<Product> findAllByPriceIsGreaterThanEqual(int price);

    List<Product> findAllByPriceIsLessThanEqual(int price);

    List<Product> findAllByPriceIsBetween(int minPrice, int maxPrice);
}
