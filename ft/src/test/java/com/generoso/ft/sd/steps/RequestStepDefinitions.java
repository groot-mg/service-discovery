package com.generoso.ft.sd.steps;

import com.generoso.ft.sd.client.Client;
import com.generoso.ft.sd.client.RequestTemplate;
import com.generoso.ft.sd.client.model.Endpoint;
import com.generoso.ft.sd.state.ScenarioState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RequestStepDefinitions {

	private final Map<Endpoint, RequestTemplate> requestTemplates;
	private final Client client;
	private final ScenarioState scenarioState;

	@Given("an endpoint {} is prepared")
	public void anEndpointIsPrepared(Endpoint endpoint) {
		var requestTemplate = getRequestTemplate(endpoint);
		scenarioState.setRequestTemplate(requestTemplate);
	}

	@When("the request is sent")
	public void theEndpointReceivesARequest() {
		var response = client.execute(scenarioState.getRequestTemplate());
		scenarioState.setActualResponse(response);
	}

	private RequestTemplate getRequestTemplate(Endpoint endpoint) {
		if (requestTemplates.containsKey(endpoint)) {
			return requestTemplates.get(endpoint);
		}

		throw new RuntimeException("Invalid request template provided.");
	}
}
