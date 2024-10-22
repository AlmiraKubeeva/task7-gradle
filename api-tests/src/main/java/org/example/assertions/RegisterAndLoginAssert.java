package org.example.assertions;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;

public class RegisterAndLoginAssert extends AbstractAssert<RegisterAndLoginAssert, Response> {
    RegisterAndLoginAssert(Response actual) {
        super(actual, RegisterAndLoginAssert.class);
    }

    public static RegisterAndLoginAssert assertThat(Response actual) {
        return new RegisterAndLoginAssert(actual);
    }

    public RegisterAndLoginAssert statusIsEqualTo(int status) {
        BasicAssert.assertThat(actual)
                .statusCodeIsEqualTo(status);

        return this;
    }
}
