package org.example.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BasicAssert extends AbstractAssert<BasicAssert, Response> {
    public BasicAssert(Response actual) {
        super(actual, BasicAssert.class);
    }

    public static BasicAssert assertThat(Response actual) {
        return new BasicAssert(actual);
    }

    public BasicAssert statusCodeIsEqualTo(int expectedCode) {
        Assertions.assertThat(actual.statusCode())
                .as("Код ответа не равен " + expectedCode)
                .isEqualTo(expectedCode);

        return this;
    }

    public BasicAssert responseContainsField(String path) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Поле '" + path + "' не найдено в теле ответа")
                .isNotNull();

        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, String value) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Поле '%s' не равно '%s'".formatted(path, value))
                .isEqualTo(value);

        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, int value) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Поле '%s' не равно '%d'".formatted(path, value))
                .isEqualTo(value);

        return this;
    }

    public BasicAssert responseFieldIsEqual(String path, double value) {
        Assertions.assertThat(actual.jsonPath().getString(path))
                .as("Поле '%s' не равно '%f'".formatted(path, value))
                .isEqualTo(value);

        return this;
    }

    //responseFieldIsEqual(String, Object)
}
