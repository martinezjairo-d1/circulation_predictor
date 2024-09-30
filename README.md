# Circulation Predictor

This application determines if a vehicle can circulate based on the "Pico y Placa" regulations, considering the license plate number, date, and time.

## Technologies Used

- **Java**: 17
- **Spring Boot**: 3.3.4
- **Maven**: For project management and dependency management
  
## Requirements
- Ensure that port 8080 is free before running the application.
  
## How to Run the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/martinezjairo-d1/circulation_predictor.git
   cd circulation_predictor
   
2. **Run the application**:
 - Execute the CirculationPredictorApplication class to start the application.
 - The application will automatically open the web browser. However, if the system does not support the Desktop API, no action will be performed, and you will need to manually navigate to:
http://localhost:8080/index.html

## Access Swagger Documentation:
To view the services documentation in Swagger, visit:
http://localhost:8080/swagger-ui/index.html

## Running Tests
You can run tests from your IDE by executing the application as Maven test, or from the command line in the project directory using:
 ```bash
mvn test

