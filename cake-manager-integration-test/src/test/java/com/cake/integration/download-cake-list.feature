Feature: Download cake list

  Background:
    * url baseUrl
    

  Scenario: Auth Login and Create Cake and Get Cakes
    
    Given path '/auth/login'
    And header Content-Type = 'application/json'
    And request { "username": "user", "password": "user"}
    When method POST
    Then status 200
    And def accessToken = response.accessToken
    
    Given path '/api/v1/cakes'
    And header Authorization = "Bearer " + accessToken
    When method GET
    Then status 200
    Then assert response.size()>1
    And match $ == read('download-cake.json')

