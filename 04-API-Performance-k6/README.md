## Performance Testing (k6)

### Overview
This section covers performance testing activities conducted using k6.
The objective is to evaluate API performance, stability, and responsiveness
under different load conditions.

---

### System Under Test
- API Name: DummyJSON API
- API Type: RESTful API
- Base URL: https://dummyjson.com
- Performance Testing Tool: k6

---

### Test Objectives
- Measure API response time under load
- Verify system stability with concurrent users
- Validate performance thresholds
- Ensure no request failures during execution

---

### Test Scenarios
Performance testing includes two main scenarios:

#### Smoke Test
- Virtual Users: 5
- Duration: 30 seconds
- Purpose:
  - Validate basic API functionality
  - Ensure the system works correctly under minimal load

#### Load Test
- Virtual Users: 23
- Duration: 2 minutes
- Start Time: After 40 seconds
- Purpose:
  - Measure system performance under moderate concurrent load
  - Identify performance bottlenecks

---

### Test Script
- Performance tests are implemented using a k6 JavaScript script.
- The script includes:
  - Defined scenarios (smoke and load)
  - Groups for API requests
  - Functional checks
  - Performance thresholds

---

### Performance Thresholds
The following thresholds are configured and validated:
- Success rate > 94%
- Response time (p95) < 1000 ms
- Failed request rate < 20%

All thresholds passed successfully.

---

### Test Execution Results
- Total HTTP requests executed: 2608
- Failed requests: 0
- Maximum virtual users: 23
- Average response time: ~172 ms
- 95th percentile response time (p95): ~264 ms

All performance checks passed successfully.

---

### Test Reporting
- Performance test results are documented in a detailed PDF report.
- The report includes:
  - Execution summary
  - Response time statistics
  - Requests and iterations metrics
  - Threshold evaluation
  - Final test result (PASS)

---

### Files Included
- k6 test script (.js)
- Performance test results report (PDF)

---

### Conclusion
The API demonstrated stable and efficient performance under both smoke
and load testing conditions, with no failed requests and acceptable
response times.
