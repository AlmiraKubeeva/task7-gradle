package org.example;

import io.restassured.response.Response;
import org.example.assertions.ProductsAssert;
import org.example.endpoints.AuthApi;
import org.example.endpoints.ProductsApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetProductsTests {
    ProductsApi productsApi;

    @BeforeEach
    void getAuthToken() {
        String authToken = AuthApi.loginUser("string", "string").jsonPath().getString("access_token");
        productsApi = new ProductsApi(authToken);
    }

    @Test
    void getProducts() {
        Response response = productsApi.getProducts();
        ProductsAssert.assertThat(response).checkProductsResponse();
    }

    @Test
    void getProduct() {
        Response response = productsApi.getProduct("1");
        ProductsAssert.assertThat(response)
                .checkProductResponse("[Electronics]", "[10.0]", "[1]","[HP Pavilion Laptop]", "[10.99]");
    }
}
