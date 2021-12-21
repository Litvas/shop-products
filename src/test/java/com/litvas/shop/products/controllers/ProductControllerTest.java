package com.litvas.shop.products.controllers;

import com.litvas.shop.products.domain.Product;
import com.litvas.shop.products.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    private static final int PAGE = 3;
    private static final int PAGE_SIZE = 7;
    private static final Long PRODUCT_ID = 5L;
    private static final String PRODUCT_CODE = "code";
    private static final String PRODUCT_TITLE = "title";
    private static final Long PRODUCT_PRICE = 100L;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private final Product product = new Product();

    @Before
    public void setUp() {
        product.setId(PRODUCT_ID);
        product.setCode(PRODUCT_CODE);
        product.setTitle(PRODUCT_TITLE);
        product.setPrice(PRODUCT_PRICE);
        List<Product> products = singletonList(product);
        doReturn(products).when(productService).getProducts(any(Pageable.class));
    }

    @Test
    public void shouldReturnProducts() throws Exception {
        this.mockMvc.perform(get("/api/v1/products")
                        .param("page", String.valueOf(PAGE))
                        .param("pageSize", String.valueOf(PAGE_SIZE)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(PRODUCT_ID))
                .andExpect(jsonPath("$[0].code").value(PRODUCT_CODE))
                .andExpect(jsonPath("$[0].title").value(PRODUCT_TITLE))
                .andExpect(jsonPath("$[0].price").value(PRODUCT_PRICE));
    }
}