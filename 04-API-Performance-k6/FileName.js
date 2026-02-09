import "./libs/shim/core.js";
import "./libs/shim/expect.js";
import "./libs/shim/urijs.js";
import { sleep, group } from "k6";

export const options = {
  maxRedirects: 4,

  scenarios: {
    smoke: {
      executor: "constant-vus",
      vus: 5,
      duration: "30s",
      gracefulStop: "10s",
    },

    load: {
      executor: "constant-vus",
      vus: 23,
      duration: "2m",
      startTime: "40s",
      gracefulStop: "10s",
    },
  },

  thresholds: {
    checks: ["rate>0.94"],
    http_req_duration: ["p(95)<1000"],
    http_req_failed: ["rate<0.2"],
  },
};

const Request = Symbol.for("request");

postman[Symbol.for("initial")]({
  options,
  environment: {
    baseURL: "https://dummyjson.com",
    userId: "4",
  },
});

export default function () {
  group("Search Users", () => {
    postman[Request]({
      name: "Search Users",
      id: "b9ca0aad-cabd-40a0-b559-a36c55f1c5f5",
      method: "GET",
      address: "{{baseURL}}/users/search?q=John",
      post(response) {
        const res = pm.response.json();

        pm.test("Status code is 200", () => {
          pm.response.to.have.status(200);
        });

        pm.test("Users array not empty", () => {
          pm.expect(res.users).to.be.an("array");
          pm.expect(res.users.length).to.be.above(0);
        });

        pm.test("First user has id", () => {
          pm.expect(res.users[0]).to.have.property("id");
        });

        // k6 thresholds handle performance, but this is OK as an extra check:
        pm.test("Response time is acceptable", () => {
          pm.expect(pm.response.responseTime).to.be.below(2000);
        });
      },
    });
  });

  sleep(1);

  group("Filter Users", () => {
    postman[Request]({
      name: "Filter Users",
      id: "69cff428-a742-47cf-93e6-524ddd3329f6",
      method: "GET",
      address: "{{baseURL}}/users/filter?key=hair.color&value=Brown",
      post(response) {
        pm.test("Status code is 200", () => {
          pm.response.to.have.status(200);
        });

        pm.test("Response time is acceptable", () => {
          pm.expect(pm.response.responseTime).to.be.below(2000);
        });
      },
    });
  });

  sleep(1);

  group("Limit and skip Users", () => {
    postman[Request]({
      name: "Limit and skip Users",
      id: "c6f9d256-d597-44d6-9839-27c45886df8c",
      method: "GET",
      address: "{{baseURL}}/users?limit=5&skip=10&select=firstName,age",
      post(response) {
        pm.test("Status code is 200", () => {
          pm.response.to.have.status(200);
        });

        pm.test("Response time is acceptable", () => {
          pm.expect(pm.response.responseTime).to.be.below(2000);
        });
      },
    });
  });

  sleep(1);
}
