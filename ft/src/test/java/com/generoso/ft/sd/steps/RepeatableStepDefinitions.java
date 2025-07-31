package com.generoso.ft.sd.steps;

import com.generoso.ft.sd.client.model.Endpoint;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RepeatableStepDefinitions {

	private final RequestStepDefinitions requestStepDefinitions;
	private final ResponseStepDefinitions responseStepDefinitions;

	@Then("the app {word} is found registered")
	public void theAppIsRegistered(String name) {
		await().atMost(Duration.ofSeconds(30))
			.pollInterval(Duration.ofSeconds(5))
			.untilAsserted(() -> {
				requestStepDefinitions.anEndpointIsPrepared(Endpoint.GET_APPS);
				requestStepDefinitions.theEndpointReceivesARequest();
				responseStepDefinitions.appListContainsTheApp(name);
			});
	}
}
