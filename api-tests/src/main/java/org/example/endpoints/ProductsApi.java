package org.example.endpoints;

import io.restassured.response.Response;

import static org.example.endpoints.Urls.PRODUCTS;

public class ProductsApi extends BasicApi {

    public ProductsApi(String token) {
        super(token);
    }

    public Response getProducts() {
        return getBuilder()
                .get(PRODUCTS);
    }

    public Response getProductsWithoutAuth() {
        return getBuilderWithoutAuth()
                .get(PRODUCTS);
    }

    public Response addNewProduct(String name, String category, int price, int discount) {
        return getBuilder()
                .body("""
                           {
                               "name": %s,
                               "category": %s,
                               "price": %d,
                               "discount": %d
                           }
                        """.formatted(name, category, price, discount))
                .post(PRODUCTS);
    }

    public Response getProduct(String id) {
        return getBuilder()
                .get(PRODUCTS + "/" + id);
    }

}
