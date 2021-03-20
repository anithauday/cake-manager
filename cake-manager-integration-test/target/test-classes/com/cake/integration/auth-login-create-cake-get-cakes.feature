Feature: Cake Create

  Background:
    * url baseUrl

  Scenario: Auth Login and Create Cake and Get Cakes

    Given path '/auth/login'
    And header Content-Type = 'application/json'
    And request { "username": "user", "password": "user"}
    When method POST
    Then status 200
    And def accessToken = response.accessToken

    Given path '/api/v1/cake'
    And header Authorization = "Bearer " + accessToken
    And request {"title": "myTitle", "description": "myDesc" , "image":"myimage" }
    When method post
    Then status 201

    Given path '/api/v1/'
    And header Authorization = "Bearer " + accessToken
    When method GET
    Then status 200
    Then assert response.size()>1




