package org.example.endpoints;

import io.restassured.response.Response;
import org.example.utils.RestApiBuilder;

import static org.example.endpoints.Urls.*;

public class AuthApi {
    public static Response registerNewUser(String login, String password) {
        return new RestApiBuilder(REGISTER).build()
                .body("""
                         {
                             "username": "%s",
                             "password": "%s"
                         }
                      """.formatted(login, password))
                .post();

    }

    public static Response loginUser(String login, String password) {
        return new RestApiBuilder(LOGIN).build()
                .body("""
                         {
                             "username": "%s",
                             "password": "%s"
                         }
                      """.formatted(login, password))
                .post();
    }
}
