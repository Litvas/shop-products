package com.litvas.shop.products.services;

import com.litvas.shop.products.domain.Product;
import com.litvas.shop.products.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable).getContent();
    }

}
