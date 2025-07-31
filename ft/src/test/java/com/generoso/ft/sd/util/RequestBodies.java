package com.generoso.ft.sd.util;

import java.util.Map;

public class RequestBodies {

	private static final Map<String, String> BODY_MAP = Map.of(
		"APP_NAME", """
            {
                "instance": {
                    "instanceId": "5784ed89d3cf:app-name:8080",
                    "app": "APP_NAME",
                    "appGroupName": null,
                    "ipAddr": "172.20.0.3",
                    "sid": "na",
                    "homePageUrl": "http://172.20.0.3:8080/",
                    "statusPageUrl": "http://172.20.0.3:8080/private/info",
                    "healthCheckUrl": "http://172.20.0.3:8080/private/health",
                    "secureHealthCheckUrl": null,
                    "vipAddress": "app_name",
                    "secureVipAddress": "app_name",
                    "countryId": 1,
                    "dataCenterInfo": {
                      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
                      "name": "MyOwn"
                    },
                    "hostName": "172.20.0.3",
                    "status": "UP",
                    "overriddenStatus": "UNKNOWN",
                    "leaseInfo": {
                      "renewalIntervalInSecs": 30,
                      "durationInSecs": 90,
                      "registrationTimestamp": 0,
                      "lastRenewalTimestamp": 0,
                      "evictionTimestamp": 0,
                      "serviceUpTimestamp": 0
                    },
                    "isCoordinatingDiscoveryServer": false,
                    "lastUpdatedTimestamp": 1658954363496,
                    "lastDirtyTimestamp": 1658954365828,
                    "actionType": null,
                    "asgName": null,
                    "port": {
                       "$": 8080,
                      "@enabled": "true"
                    },
                    "securePort": {
                      "$": 443,
                      "@enabled": "false"
                    },
                    "metadata": {
                      "management.port": "8080"
                    }
                }
            }
            """
	);

	public static String getBody(String key) {
		return BODY_MAP.get(key);
	}
}
