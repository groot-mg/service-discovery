package com.generoso.ft.sd.steps;

import com.generoso.ft.sd.client.model.Endpoint;
import com.generoso.ft.sd.client.model.EurekaAppResponse;
import com.generoso.ft.sd.client.model.EurekaStatus;
import com.generoso.ft.sd.state.ScenarioState;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.generoso.ft.sd.util.JsonMapper.fromJson;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EurekaStepsDefinitions {

	private final RequestStepDefinitions requestStepDefinitions;
	private final ScenarioState scenarioState;

	@Then("the app {word} is found registered with status {}")
	public void theAppIsRegistered(String name, EurekaStatus eurekaStatus) {
		await().atMost(Duration.ofSeconds(30))
			.pollInterval(Duration.ofSeconds(5))
			.untilAsserted(() -> {
				requestStepDefinitions.anEndpointIsPrepared(Endpoint.GET_APPS);
				requestStepDefinitions.theEndpointReceivesARequest();

				var response = scenarioState.getActualResponse();
				var apps = fromJson(response.body(), EurekaAppResponse.class);

				assertFalse(apps.applications().application().isEmpty());

				var application = apps.applications().application()
					.stream().filter(n -> n.name().equals(name)).findFirst()
					.orElseThrow();
				assertEquals(eurekaStatus, application.instance().getFirst().status());
			});
	}
}
