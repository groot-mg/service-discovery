package com.generoso.ft.sd.steps;

import com.generoso.ft.sd.client.model.EurekaAppResponse;
import com.generoso.ft.sd.state.ScenarioState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import static com.generoso.ft.sd.util.JsonMapper.fromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResponseStepDefinitions {

	private final ScenarioState scenarioState;

	@Then("the response status code should be {int}")
	public void theResponseCode(int expectedResponseCode) {
		assertEquals(expectedResponseCode, scenarioState.getActualResponse().statusCode());
	}

	@And("the app list should be empty")
	public void appListShouldBeEmpty() {
		var response = scenarioState.getActualResponse();
		var apps = fromJson(response.body(), EurekaAppResponse.class);

		assertTrue(apps.applications().application().isEmpty());
	}
}
