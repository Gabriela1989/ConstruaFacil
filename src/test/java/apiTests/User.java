package apiTests;


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class User {
    String uri = "https://petstore.swagger.io/v2/user/createWithList";
    int userId = 1125;

        // Padrão
        // Given = Dado
        // .When = Quando
        // .Then = Então

        // Funções de Apoio
        public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
        }

    @Test(priority = 0)
    public void incluirUser() throws IOException { // Create - Post
        // String petID = 1125;

        String jsonBody = lerJson("src/test/resources/data/user.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
                .when()
                .post(uri)     //Comando + endpoint
                .then()
                .log().all()
                .statusCode(200)
                // .body("code", is(200))               /
                .body("id", is(userId))
                .body("\"username", is("1989"))
                .body("firstName", is("Gabriela"))
                .body("lastName", stringContainsInOrder("Lima"))

                ;

    }
    @Test(priority = 1)
    public void consultarUser() {

        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(uri + "/" + userId)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("\"username", is("1989"))
                .body("firstName", is("Gabriela"))
                .body("lastName", stringContainsInOrder("Lima"))
        ;
    }
    @Test (priority = 2)
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newpet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody) // Json a ser transmitido para a alteração
                .when()
                .put(uri)
                .then()
                .log().all()
                .statusCode(200)
                .body("status", is("Offline"));
    }

    @Test (priority = 3)
    public void excluirUser() {

        given()
                .contentType("applications/Json")
                .log().all()
                .when()
                .delete(uri + "/" + userId)
                .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is(Integer.toString(userId)))
        ;
    }
}
