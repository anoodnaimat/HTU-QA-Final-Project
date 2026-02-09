## API Testing (Postman)

### Overview
This section covers API testing activities performed using Postman.
The testing focuses on validating RESTful APIs for a demo e-commerce platform
to ensure correct functionality, error handling, and response validation.

---

### API Under Test
- API Name: DummyJSON API
- API Type: RESTful API
- Base URL: https://dummyjson.com
- Testing Tool: Postman

---

### Testing Scope
The API testing covers the following areas:
- Authentication and authorization
- Products management
- Shopping carts operations
- Users management
- Posts and comments features

Both positive and negative test scenarios were included.

---

### Postman Collection
- A complete Postman collection is created to cover all API endpoints.
- The collection is organized into logical folders based on functionality:
  - Authentication
  - Products
  - Carts
  - Users & Posts
- Each request includes automated tests to validate responses.

---

### Environment Configuration
- A Postman environment file is used to manage test data and variables.
- Environment variables include:
  - baseURL
  - accessToken
  - userId
  - productId
  - cartId
- The access token is automatically captured after login and reused in secured requests.

---

### Automated API Tests
- Test scripts are added using Postman Tests.
- Automated validations include:
  - HTTP status code checks
  - Response body structure validation
  - Data existence and integrity checks
  - Token generation and storage
  - Response time validation

---

### Negative Testing
Negative test scenarios are included to validate API robustness, such as:
- Invalid endpoint paths
- Invalid or non-existent IDs
- Incorrect request parameters
- Empty or invalid request bodies

---

### Data-Driven Testing
- Data-driven testing is implemented using an external CSV file.
- Multiple iterations are executed using different test data.
- This approach improves test coverage and validation accuracy.

---

### Test Execution & Reporting
- The Postman collection is executed using Newman (Postman CLI).
- An HTML execution report is generated after the run.
- The report includes:
  - Total requests executed
  - Assertions count
  - Passed and failed tests
  - Execution time and performance metrics

---

### Files Included
- Postman Collection (.json)
- Postman Environment (.json)
- Data-driven test file (.csv)
- Newman HTML Execution Report

---

### Notes
- API responses are validated in JSON format.
- Negative test cases are clearly labeled.
- Automated tests are executed without manual intervention.
