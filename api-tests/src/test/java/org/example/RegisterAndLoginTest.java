package org.example;

import io.restassured.response.Response;
import org.example.assertions.RegisterAndLoginAssert;
import org.example.endpoints.AuthApi;
import org.junit.jupiter.api.Test;

public class RegisterAndLoginTest {

    @Test
    void registerTest() {
        Response response = AuthApi.registerNewUser("111211newUser111", "string");
        RegisterAndLoginAssert.assertThat(response)
                .statusIsEqualTo(201);
    }

    @Test
    void loginTest() {
        Response response = AuthApi.loginUser("string", "string");
        RegisterAndLoginAssert.assertThat(response)
                .statusIsEqualTo(200);
    }

    @Test
    void wrongLoginTest() {
        Response response = AuthApi.loginUser("xcvlkjh", "lrkgmk");
        RegisterAndLoginAssert.assertThat(response)
                .statusIsEqualTo(401);
    }
}
