package com.litvas.shop.products.repositories;

import com.litvas.shop.products.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Page<Product> findAll(Pageable pageable);

}
