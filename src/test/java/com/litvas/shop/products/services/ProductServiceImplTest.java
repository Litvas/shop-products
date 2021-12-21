package com.litvas.shop.products.services;

import com.litvas.shop.products.domain.Product;
import com.litvas.shop.products.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    private static final int PAGE = 0;
    private static final int PAGE_SIZE = 10;

    @InjectMocks
    private ProductServiceImpl testedEntry;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private List<Product> products;

    @Mock
    private Page<Product> page;

    @Before
    public void setUp() {
        doReturn(products).when(page).getContent();
        doReturn(page).when(productRepository).findAll(any(Pageable.class));
    }

    @Test
    public void shouldReturnAllProducts() {
        assertThat(testedEntry.getProducts(PageRequest.of(PAGE, PAGE_SIZE))).isSameAs(products);
    }
}
