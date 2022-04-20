package srv.api.com.survey.boundary;

import io.quarkus.test.junit.QuarkusTest;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import srv.api.com.survey.dto.GetAllSurveysDTO;
import srv.api.com.survey.infrastructure.SurveyRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class SurveyResourceTest {

    @Inject
    SurveyRepository surveyRepository;

    @Transactional
    @AfterEach
    void tearDown() {
        surveyRepository.deleteAll();
    }

    // get by ID negative scenario
    @Test
    void getByIDTest() {
        given()
                .when()
                .get("/survey/069648d4-57c6-4cd0-adbe-f0d9d19b608d")
                .then()
                .statusCode(404);
    }

    @Test
    void saveAndDeleteTest() throws IOException {
        // create and receive location to resource
        String locationURL =
                given().body(
                        Files.readString(
                                Path.of("src", "test", "resources", "json-test-inputs", "survey-post-request.json"),
                                StandardCharsets.UTF_8))
                .header("Content-Type", "application/json")
                .post("/survey")
                .then()
                .statusCode(201)
                .header("location", containsString("/survey/"))
                .extract().header("location");

        // get by ID
        String uuid = locationURL.substring(locationURL.length() - 36);
        given()
                .when()
                .get(locationURL)
                .then()
                .statusCode(200)
                .body(containsString(uuid))
                .extract().asString();

        // delete
        given()
                .when()
                .header("Content-Type", "application/json")
                .delete(locationURL)
                .then().statusCode(204);

        // test if deleted
        given()
                .when()
                .get(locationURL)
                .then()
                .statusCode(404);
    }
}
