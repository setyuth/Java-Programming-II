package com.university.week9api.model;

/**
 * ApiResponse — standard response wrapper for all API endpoints.
 *
 * Using a consistent response format makes your API predictable.
 * Every response (success OR error) has the same structure:
 *
 * Success example:
 * {
 *   "success": true,
 *   "message": "Student found",
 *   "data": { "id": 1, "name": "Alice" }
 * }
 *
 * Error example:
 * {
 *   "success": false,
 *   "message": "Student not found with ID: 99",
 *   "data": null
 * }
 */
public class ApiResponse {

    private boolean success;
    private String  message;
    private Object  data;     // Can hold any Java object — Student, List, String, etc.

    // ── Constructors ─────────────────────────────────────────────────────────
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data    = data;
    }

    // ── Static factory methods — convenient to use in controllers ────────────

    /** Call this when the operation succeeded and you have data to return. */
    public static ApiResponse ok(String message, Object data) {
        return new ApiResponse(true, message, data);
    }

    /** Call this when the operation succeeded but there is no data to return. */
    public static ApiResponse ok(String message) {
        return new ApiResponse(true, message, null);
    }

    /** Call this when something went wrong. */
    public static ApiResponse error(String message) {
        return new ApiResponse(false, message, null);
    }

    // ── Getters — required for Jackson JSON serialization ────────────────────
    public boolean isSuccess() { return success; }
    public String  getMessage(){ return message; }
    public Object  getData()   { return data; }
}