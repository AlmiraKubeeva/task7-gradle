package org.example.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class ProductsAssert extends AbstractAssert<ProductsAssert, Response> {
    public ProductsAssert(Response actual) {
        super(actual, ProductsAssert.class);
    }

    public static ProductsAssert assertThat(Response actual) {
        return new ProductsAssert(actual);
    }

    public ProductsAssert checkProductsResponse() {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqualTo(200);

        return this;
    }

    public ProductsAssert checkProductResponse(String category, String discount, String id, String name, String price) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqualTo(200)
                .responseFieldIsEqual("category", category)
                .responseFieldIsEqual("discount", discount)
                .responseFieldIsEqual("id", id)
                .responseFieldIsEqual("name", name)
                .responseFieldIsEqual("price", price);

        return this;
    }
}
