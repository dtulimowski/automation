package restassured;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public class Runner {

    public static void main(String[] args) {
        ResponseOptions<Response> responseResponseOptions = Request.findPeople();
        System.out.println(responseResponseOptions.body().prettyPrint());
    }
}
