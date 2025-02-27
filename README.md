# Product Service

## Description
The **Product Service** manages product data and stock levels. It receives order requests from the **Order Service**, verifies availability, and updates stock accordingly.

## Features
- Provides product details via gRPC.
- Listens for order requests from Kafka.
- Updates product stock and responds with availability status.

## Technologies Used
- **Spring Boot**
- **Spring gRPC**
- **Spring Cloud Stream** (Kafka integration)
- **Spring Data JPA** 
- **In memory H2 database**

## Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/elmerjani/product-service.git
   cd product-service
   ```

2. **Build the application**  
   We’ll want to define the stubs for a Java service based on the product_service.proto file: 
   ```sh
   ./mvnw clean package
   ```
   You’ll get two new folders in the target directory : target/target/generated-sources/protobuf/grpc-java and target/target/generated-sources/protobuf/java.
   You may need to instruct your IDE to mark them as source roots. In IntelliJ IDEA, you’d right-click the folder, choose Mark Directory As → Generated Source Root. Eclipse or VSCode will add them automatically for you.


4. **Run Kafka with docker**
   ```sh
   docker run -d -p 9092:9092 --name kafka apche/kafka:latest
   ```


4. **Run the service**
   ```sh
   ./mvnw spring-boot:run
   ```

## Kafka Topics
| Topic Name      | Purpose  |
|----------------|---------|
| `orders-topic`  | Receives order requests from Order Service |
| `products-topic` | Sends product availability status |

## gRPC Endpoints
| Method | Description |
|--------|-------------|
| `getProductById` | Fetches product details |

