# Service Discovery
[![CI Workflow](https://github.com/groot-mg/service-discovery/actions/workflows/ci-workflow.yml/badge.svg)](https://github.com/groot-mg/service-discovery/actions/workflows/ci-workflow.yml) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=groot-mg_service-discovery&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=groot-mg_service-discovery) [![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/groot-mg/service-discovery/blob/main/LICENSE)

The purpose of a service discovery is load balancing and failover of middle-tier servers. It plays a critical role a mid-tier infra.

Each service will self register in the service discovery and the API Gateway responsible for receiving the user requests, will forward the requests to the registered services in the service discovery.

### References

* The eureka [docs](https://cloud.spring.io/spring-cloud-netflix/reference/html/)
* [Configuration properties](https://docs.spring.io/spring-cloud-netflix/reference/configprops.html)

## Build, tests and run

### Build + unit tests
Build with gradle (build + unit tests):
```
./gradlew app:build
```

### Functional tests

The application needs to be running before run the Functional Tests:
```shell
./gradlew app:bootRun
```

Run functional-tests:
```
./gradlew cucumber
```

### Run

Service discovery does not have any dependency on the `groot-mg` project, so it is easy to run it locally.

Local app is available on the port `8081`, health check endpoint is [http://localhost:8081/private/health](http://localhost:8081/private/health)

```
./gradlew bootRun
 ```

Alternatively, it is possible to run using `java -jar app/build/libs/service-discovery.jar`

### Run together with the project
Service discovery should run together with the API Gateway and other services in the project, to run all together, please see [docker-local-setup](https://github.com/groot-mg/docker-local-setup).
