# Mini E-Commerce Product Catalog API

This is a simple Spring Boot REST API backend for a mini e-commerce product management system. It uses in-memory storage (ArrayList) to manage products.

## Project Overview

The project is built using:
- Java 21
- Spring Boot 3.2.2
- Maven
- Spring Web (REST API)
- Spring Validation (Input Validation)

It follows a layered architecture with:
- `controller`: Handles HTTP requests.
- `service`: Contains business logic and data manipulation.
- `model`: Defines the data structure.

## Live Deployment
This application is deployed and publicly accessible. You can interact with the live API at the following URL:

**Live API URL**: [`https://e-commerce-product-catalog-api.onrender.com`](https://e-commerce-product-catalog-api.onrender.com)

You can use the endpoints listed below with this base URL. For example, to get all products, use `GET https://e-commerce-product-catalog-api.onrender.com/products`.

## How to Run the Project Locally

1.  **Prerequisites**: Ensure you have Java 21 (or higher) and Maven installed.
2.  **Clone/Download**: Navigate to the project root directory (`D:/SpringWeb/catalog`).
3.  **Build**: Run the following command to build the project:
    ```bash
    ./mvnw clean install
    ```
    (On Windows, use `mvnw.cmd clean install`)
4.  **Run**: Start the application using:
    ```bash
    ./mvnw spring-boot:run
    ```
    (On Windows, use `mvnw.cmd spring-boot:run`)
5.  The application will start on `http://localhost:8080`.

## How to Test the Project

### Unit Tests
The project includes unit tests for the controller layer using `MockMvc`. To run the tests:

```bash
./mvnw test
```
(On Windows, use `mvnw.cmd test`)

### Manual Testing
You can use tools like Postman or `curl` to test the API endpoints, either locally or with the live URL.

## API Endpoints

### 1. Add a New Product
*   **URL**: `/products`
*   **Method**: `POST`
*   **Description**: Adds a new product to the catalog.
*   **Request Body (JSON)**:
    ```json
    {
      "name": "Smartphone",
      "description": "Latest model smartphone",
      "price": 699.99,
      "quantity": 50
    }
    ```
*   **Response (201 Created)**:
    ```json
    {
      "id": 1,
      "name": "Smartphone",
      "description": "Latest model smartphone",
      "price": 699.99,
      "quantity": 50
    }
    ```
*   **Validation Errors (400 Bad Request)**:
    *   `name`: Should not be empty.
    *   `price`: Should be positive.
    *   `quantity`: Should be zero or more.

### 2. Get All Products
*   **URL**: `/products`
*   **Method**: `GET`
*   **Description**: Retrieves a list of all products.
*   **Response (200 OK)**:
    ```json
    [
      {
        "id": 1,
        "name": "Smartphone",
        "description": "Latest model smartphone",
        "price": 699.99,
        "quantity": 50
      },
      {
        "id": 2,
        "name": "Laptop",
        "description": "High performance laptop",
        "price": 1200.00,
        "quantity": 20
      }
    ]
    ```

### 3. Get Product by ID
*   **URL**: `/products/{id}`
*   **Method**: `GET`
*   **Description**: Retrieves a specific product by its ID.
*   **Example**: `/products/1`
*   **Response (200 OK)**:
    ```json
    {
      "id": 1,
      "name": "Smartphone",
      "description": "Latest model smartphone",
      "price": 699.99,
      "quantity": 50
    }
    ```
*   **Response (404 Not Found)**: If the product ID does not exist.

### 4. Delete Product by ID
*   **URL**: `/products/{id}`
*   **Method**: `DELETE`
*   **Description**: Deletes a product by its ID.
*   **Example**: `/products/1`
*   **Response (204 No Content)**: If the deletion was successful.
*   **Response (404 Not Found)**: If the product ID does not exist.
