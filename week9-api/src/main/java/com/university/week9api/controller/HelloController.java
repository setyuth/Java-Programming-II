package com.university.week9api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * HelloController — demonstrates the four most important Spring MVC annotations.
 *
 * Base URL for all endpoints in this controller: /api/hello
 *
 * Annotation summary:
 *   @RestController    = this class handles HTTP requests and returns data (not a web page)
 *   @RequestMapping    = sets the base URL path for all methods in this class
 *   @GetMapping        = handles HTTP GET requests
 *   @PathVariable      = reads a value from inside the URL  e.g. /hello/{name}
 *   @RequestParam      = reads a value from the query string e.g. /hello?name=Alice
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    // ── GET /api/hello ────────────────────────────────────────────────────────
    // Simplest possible endpoint — returns a plain String
    @GetMapping
    public String sayHello() {
        return "Hello from Spring Boot! Week 9 API is running.";
    }

    // ── GET /api/hello/{name} ─────────────────────────────────────────────────
    // @PathVariable reads {name} directly from the URL path
    // Example: GET /api/hello/Alice  →  name = "Alice"
    @GetMapping("/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello, " + name + "! Welcome to the Spring Boot API.";
    }

    // ── GET /api/hello/greet?name=Alice ──────────────────────────────────────
    // @RequestParam reads the query string parameter
    // Example: GET /api/hello/greet?name=Alice  →  name = "Alice"
    // required = false means the parameter is optional; defaultValue is used if missing
    @GetMapping("/greet")
    public String greetWithParam(
            @RequestParam(required = false, defaultValue = "World") String name) {
        return "Greetings, " + name + "!";
    }

    // ── GET /api/hello/info ───────────────────────────────────────────────────
    // Returns a JSON object (Map becomes a JSON object automatically)
    @GetMapping("/info")
    public Map<String, String> getAppInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("appName",    "Week 9 REST API");
        info.put("version",    "1.0.0");
        info.put("framework",  "Spring Boot 4.0.5");
        info.put("developer",  "KhmerSide Java Course");
        info.put("serverTime", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return info;
    }

    // ── GET /api/hello/add?a=5&b=3 ───────────────────────────────────────────
    // Multiple query parameters in one endpoint
    // Example: GET /api/hello/add?a=10&b=4  →  returns 14
    @GetMapping("/add")
    public Map<String, Object> addNumbers(
            @RequestParam int a,
            @RequestParam int b) {
        Map<String, Object> result = new HashMap<>();
        result.put("a",      a);
        result.put("b",      b);
        result.put("sum",    a + b);
        result.put("operation", a + " + " + b + " = " + (a + b));
        return result;
    }
}