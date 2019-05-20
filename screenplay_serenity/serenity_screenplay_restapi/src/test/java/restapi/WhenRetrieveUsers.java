package restapi;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import restapi.pojo.User;

import java.util.List;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
public class WhenRetrieveUsers {

    private String theRestApiBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor sam;

    @Before
    public void configureBaseUrl() {
        theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("http://localhost:3000/");

        sam = Actor.named("Sam the supervisor").whoCan(CallAnApi.at(theRestApiBaseUrl));
    }

    @Test
    public void find_an_individual_json_ser() {

        sam.attemptsTo(Get.resource("/users/1"));

        sam.should(seeThatResponse("User details should be correct",
                response -> response.statusCode(200)
                        .body("id", equalTo(1))
                        .body("user", equalTo("admin"))
                        .body("password", equalTo("admin"))
        ));
    }

    @Test
    public void find_an_individual_object_user() {
        sam.attemptsTo(Get.resource("/users/1"));

        User user = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("", User.class);

        assertTrue(user.getId() == 1);
        assertTrue(user.getUser().equals("admin"));
        assertTrue(user.getPassword().equals("admin"));
    }

    @Test
    public void retrieve_all_users() {
        sam.attemptsTo(Get.resource("/users"));

        List<User> users = SerenityRest.lastResponse()
                .jsonPath()
                .getList("", User.class);

        sam.should(
                seeThatResponse("all the expected users should be returned",
                        response -> response.statusCode(200)
                                .body("id", contains(1,2))
                                .body("user", contains("admin","drohne"))
                                .body("password", contains("admin","admin"))
                ));

        assertEquals(2, users.size());

    }


}
