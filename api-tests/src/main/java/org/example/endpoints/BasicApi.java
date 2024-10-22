package org.example.endpoints;

import io.restassured.mapper.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import org.example.utils.RestApiBuilder;

import static org.example.endpoints.Urls.BASE_URL;

public class BasicApi {
    protected String token;

    public BasicApi(String token) {
        this.token = token;
    }

    public RequestSpecification getBuilder() {
        return new RestApiBuilder(BASE_URL)
                .addAuth(token)
                .build();
    }

    public RequestSpecification getBuilderWithoutAuth() {
        return new RestApiBuilder(BASE_URL)
                .build();
    }
//
//    protected static String toJSON(Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        }
//        catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
