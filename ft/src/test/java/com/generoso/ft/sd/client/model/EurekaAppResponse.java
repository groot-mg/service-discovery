package com.generoso.ft.sd.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EurekaAppResponse(Applications applications) {

	public record Applications(
		@JsonProperty("versions__delta") String version,
		@JsonProperty("apps__hashcode") String appHashCode,
		List<Application> application
	) {
	}

	public record Application(String name, List<Instance> instance) {
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record Instance(
		String instanceId,
		String hostName,
		String app,
		String ipAddr,
		EurekaStatus status,
		String overriddenStatus,
		int countryId,
		LeaseInfo leaseInfo,
		Map<String, String> metadata,
		String homePageUrl,
		String statusPageUrl,
		String healthCheckUrl,
		String vipAddress,
		String secureVipAddress,
		String isCoordinatingDiscoveryServer,
		String lastUpdatedTimestamp,
		String lastDirtyTimestamp,
		String actionType
	) {
	}

	public record LeaseInfo(
		int renewalIntervalInSecs,
		int durationInSecs,
		long registrationTimestamp,
		long lastRenewalTimestamp,
		long evictionTimestamp,
		long serviceUpTimestamp
	) {
	}
}
