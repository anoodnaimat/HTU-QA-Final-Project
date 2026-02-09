# Full-Stack QA Testing Portfolio: SauceDemo & DummyJSON

## Project Scope

Complete QA testing portfolio covering manual testing, API testing (Postman), API performance testing (k6), and UI automation (Selenium Java) for the SauceDemo web application and DummyJSON API.

**System Under Test:**

- Web UI: https://www.saucedemo.com
- REST API: https://dummyjson.com

---

## Project Structure

```
├── 01-Planning/
│   └── Test_Plan_SauceDemo_Updated.pdf
├── 02-Manual-Testing/
│   └── (Test Cases & Bug Reports)
├── 03-API-Postman/
│   ├── Final Project-HTU.postman_collection.json
│   ├── anood env.postman_environment.json
│   └── index.html (Newman report)
├── 04-API-Performance-k6/
│   ├── FileName.js
│   └── k6-test-results-complete.pdf
├── 05-UI-Automation/
│   └── FinalProject-HTU/
└── 06-Report/
    └── final-project-4-Final.docx
```

---

## Setup Steps

### Prerequisites

```bash
# Required software
- Java JDK 21+
- Maven 3.6+
- Node.js v14+
- Microsoft Edge browser

# Install Newman and k6
npm install -g newman newman-reporter-html
# Install k6: https://k6.io/docs/get-started/installation
```

---

## How to Run Postman/Newman

### Using Postman (GUI)

1. Import `03-API-Postman/Final Project-HTU.postman_collection.json`
2. Import `03-API-Postman/anood env.postman_environment.json`
3. Select "anood env" environment
4. Run collection

### Using Newman (CLI)

```bash
cd 03-API-Postman/

# Basic run (Note: Quotes are used because of spaces in filenames)
newman run "Final Project-HTU.postman_collection.json" -e "anood env.postman_environment.json"

# With HTML report
newman run "Final Project-HTU.postman_collection.json" -e "anood env.postman_environment.json" -r html
```

---

## How to Run K6

```bash
cd 04-API-Performance-k6/

# Run performance tests
k6 run FileName.js

# Export results
k6 run FileName.js --summary-export=summary.json
```

**Test Configuration:**

- Smoke test: 5 VUs for 30s
- Load test: 23 VUs for 2min

---

## How to Run UI Automation

```bash
cd 05-UI-Automation/FinalProject-HTU/

# Using Maven
mvn clean test

# Or import into Eclipse/IntelliJ and run as TestNG test
```

**Test Details:**

- Framework: Selenium WebDriver + TestNG
- Browser: Microsoft Edge
- Test Cases: 9 automated tests
- Credentials: `standard_user / secret_sauce`

---

## Evidence & Screenshots

### Manual Testing

- **Location:** `02-Manual-Testing/` (Test Reports) & `06-Report/final-project-4-Final.docx`
- Contains: 20+ test cases with execution evidence and defect log

### API Testing

- **Postman Report:** `03-API-Postman/index.html`
- Coverage: 20+ API operations with assertions

### Performance Testing

- **k6 Results:** `04-API-Performance-k6/k6-test-results-complete.pdf`
- Metrics: Response times, throughput, error rates

### UI Automation

- **TestNG Reports:** `05-UI-Automation/FinalProject-HTU/test-output/index.html`
- Results: 9/9 tests passing

### Complete Documentation

- **Final Report:** `06-Report/final-project-4-Final.docx`

---

**Author:** Anood Alnaimat | HTU QA Track  
**Date:** February 2026
