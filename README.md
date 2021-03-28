# cake project 

## Applications

- ### cake-ui
  
  In order to access the application, a `user` must login using his/her `username` and `password`. 
  All the requests coming from `cake-ui` to secured endpoints in `cake-api` have the JWT access token.
  This token is generated when the `user` logins.
  
  `cake-ui` uses [`Semantic UI React`](https://react.semantic-ui.com/) as CSS-styled framework.

## Prerequisites

- [`npm`](https://www.npmjs.com/get-npm)
- [`Java 8`](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [`Docker`](https://www.docker.com/)
- [`Docker-Compose`](https://docs.docker.com/compose/install/)

## Start Environment

- Open a terminal and inside `cake-manager` root folder run

   mvn clean install 
  ```
   docker-compose  up  --build -d  
  ```
  
- Wait a little bit until `mysql` container is Up (healthy). You can check their status running
  ```
  docker-compose ps
  ```

## Running cake-app using Maven & Npm

- **cake-api**

  - Open a terminal and navigate to `cake-manager/cake-api` folder

  - Run the following `Maven` command to start the application
    ```
    mvn clean package 
    ```

- **cake-ui**

  - Open another terminal and navigate to `cake-manager/cake-ui` folder

  - Run the command below if you are running the application for the first time
    ```
    npm install
    ```

  - Run the `npm` command below to start the application
    ```
    npm start
    ```



## Running Integration Tests

- **cake-manager-integration-test**

  - Open a terminal and navigate to `cake-manager/cake-manager-integration-test` folder

  - Run the following `Maven` command to start the application
    ```
    mvn clean test 
    ```

## Applications URLs

| Application | URL                                   | Credentials                                         |
| ----------- | ------------------------------------- | --------------------------------------------------- |
| cake-api   | http://localhost:8080/swagger-ui.html |                                                     |
| cake-ui    | http://localhost:3000                 |  `user/user`  |

> **Note:** the credentials shown in the table are the ones already pre-defined. 

## Demo

- The gif below shows a `user` loging in

  ![user-login](images/user-login.gif)


## Testing cake-api Endpoints

- **Manual Endpoints Test using Swagger**
  
  - Open a browser and access http://localhost:8080/swagger-ui.html. All endpoints with the lock sign are secured. In order to access them, you need a valid JWT access token.


## Shutdown

- Go to `cake-api` and `cake-ui` terminals and press `Ctrl+C` on each one

- To stop and remove docker-compose containers, networks and volumes, run the command below in `cake-manager` root folder
  ```
  docker-compose down -v
  ```


