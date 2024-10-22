package org.example;

import org.example.endpoints.AuthApi;
import org.junit.jupiter.api.Test;

public class RegisterAndLoginTest {

    @Test
    void registerTest() {
        AuthApi.registerNewUser("1newUser1", "string").then().statusCode(201);
    }

    @Test
    void loginTest() {
        AuthApi.loginUser("1newUser1", "string").then().statusCode(200);
    }
}
