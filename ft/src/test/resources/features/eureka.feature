Feature: Check application contains the eureka functionality

  Background:
    Given initial metrics are gathered

  Scenario: When application starts, get apps should returns an empty app list
    Given an endpoint GET_APPS is prepared
    When the request is sent
    Then the response status code should be 200
    And the app list should be empty
    And metrics are gathered again
    And the application_responses_total metric for endpoint GET_APPS with status response code 200 has incremented by 1
