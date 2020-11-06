package io.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static io.restassured.RestAssured.given;

public class Request {
    public static ResponseOptions<Response> address() {
        return given()
                .headers("Accept-Language", "en-US,en;q=0.5")
                .contentType(ContentType.URLENC)
               // .body(Coordinates.get())
                .when()
                .post("URL")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public static ResponseOptions<Response> jobSearch() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                // .body(Coordinates.get())
                .when()
                .post("https://api.linkedin.com/v1/job-search?job-title=Software+Engineer")
                .then()
                .statusCode(401)
                .extract()
                .response();
    }




    public static ResponseOptions<Response> authorizationCode() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                //.body("grant_type=client_credentials&client_id=77rbb08w9su57v&client_secret=o9WSA8iMiAIhViFP")
                .body("response_type=code&client_id=77rbb08w9su57v&redirect_uri=https%3A%2F%2Fdev.example.com%2Fauth%2Flinkedin%2Fcallback&state=fooobar&scope=r_liteprofile%20r_emailaddress%20w_member_social")
                .when()  //http://www.example.com/callback
                .post("https://www.linkedin.com/oauth/v2/authorization")
                .then()
                .statusCode(403)
                .extract()
                .response();
    }

    public static ResponseOptions<Response> accessToken() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                /*.param("grant_type","authorization_code")
                .param("code","AQQ9NnpF3Qj3e3XGuidQ9G2BSho1qvgRoj07PFW2vMC1nyOKS9uz36BSehjObz5WrlZfH06CylgA-Czy3S89nL8GUj0baNUyc3SsgRCj0yIDmuXbxtmoqZk2svdYSHAzfZ2m7D5pqsq6pU5V_j55Na_h3LUYPSCNs3j5nU_FcZjunyoF6SxxltTMMA3oWw&state=fooobar")
                .param("redirect_uri","https://example.com/auth/callback")
                .param("client_id","77rbb08w9su57v")
                .param("client_secret","o9WSA8iMiAIhViFP")*/
                .body("grant_type=authorization_code&code=AQQdrhFZtwtdRYPnYCTsjQjA8kqgLOf0NKl9DjI64-L2wbP2MtWWs4s5u1HaJI0nd9_2tPTYf3hshEFvi3lJzXswI7ewIPOISQYCLcf5xiz5XN2A4iWM7VUYRzErbLZfsM-9mX4q-li0lnCL69a74s0BZdedYiNRBv_UkQsL6A_v9BInnUwC1Y-xY5fBXw&state=fooobar&redirect_uri=https://example.com/auth/callback&client_id=77rbb08w9su57v&client_secret=o9WSA8iMiAIhViFP")
                .when()
                .post("https://www.linkedin.com/oauth/v2/accessToken")
                .then()
                //.statusCode(200)
                .extract()
                .response();
    }

    public static ResponseOptions<Response> findPeople() {
        return given()
                .header("Authorization", "Bearer AQV87YWVQ4kbHYq5zFe8mrubP4XNzmx-T45uNhyRvrF9je52YsgzSvoYUeUtR1bAhOU0BKN9EZV0K3MAmByihVJDUh9uCCCxZ5joQtke_gUnHympzAks1ctrw39of-kWsaOCvRHJ3dCwrHM8mn7qIJa8i9Iftj26P3HtF4_kZZlzql6cEcFgs6YXbpwp1ow18iP2kh73f6RLM1V9DNZ6F6wP46qeoPL6wapsJZIf31neDbDVRiATbir8TnObWnxrlS2d76gPl9KoX0uLJMTAWzFh3_D4cEoEdLI665HtQjOTTnfeffbj2U86AKPENTG5DjUbnp1HpuafoZigJVpiqSQBEbrtAQ")
                .queryParam("job-title", "Software+Engineer")
                .when()
                .get("https://api.linkedin.com/v1/job-search")
                .then()
                .extract()
                .response();
    }


}
