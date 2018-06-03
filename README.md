### care-weather-adapter
This is an application-server created to work as an adapter to provide weather data from Open Weather API.

## What is necessary to run this project:

- ```gradle 2.14```
- ```JDK 1.8```

## How can I build and run this project?
Once you downloaded the project,to build it is necessary to ```cd care-weather-adapter``` and run the follows command:

```./gradlew clean build```

After you build the project following the step above, inside the directory "care-weather-adapter" execute the follows command:

```gradle bootRun```

It will start the SpringBoot server and the service will be running at ```localhost:8080```.

## Endpoints

This project will be running with the context-path ```/care-weather-adapter```.

The endpoint provided is:

- ```/v1/weather```

It receives as parameters:

- city
- country

Example: ```/v1/weather?city=Berlin&country=DE```

The response JSON provided will be:

```
{
    "location": {
        "id": 2950159,
        "city": "Berlin",
        "country": "DE",
        "coordinate": {
            "latitude": 52.52,
            "longitude": 13.39
        }
    },
    "description": "clear sky",
    "temperature": {
        "current": 21.45,
        "minimum": 21.45,
        "maximum": 21.45
    },
    "humidity": 70,
    "pressure": 1029.14,
    "visibility": null,
    "wind": {
        "speed": 4.71,
        "degree": 108.003
    }
}
```

## Future improvements

Follows the list of futures improvements to be applied:

  - Create a cache on the provided endpoint.
  - Separate the modules "care-model" and "open-weather-model" to be separate and versioned artifacts.
  - Create a Spring Cloud Config project to store the application properties.
  - Encrypt the API key.
  - Set up circuit breakers on the communication with "Open Weather API".
  - Use Spring RestDocs to create the project documentation.
  - Create a Docker image.

## Observation

 - This project was created to provide data to the project "care-weather-app" (https://github.com/gdunhao/care-weather-app).
