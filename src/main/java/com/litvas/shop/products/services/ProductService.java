package com.litvas.shop.products.services;

import com.litvas.shop.products.domain.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(Pageable pageable);

}
