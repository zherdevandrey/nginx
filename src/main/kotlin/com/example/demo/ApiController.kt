package com.example.demo

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController {

    @GetMapping("/api")
    fun getApi(request: HttpServletRequest): MutableMap<String, String> {
        return mutableMap(request)
    }

    @GetMapping
    fun getRoot(request: HttpServletRequest): MutableMap<String, String> {
        return mutableMap(request)
    }

    private fun mutableMap(request: HttpServletRequest): MutableMap<String, String> {
        val headers = mutableMapOf<String, String>()
        val headerNames = request.headerNames

        while (headerNames.hasMoreElements()) {
            val headerName = headerNames.nextElement()
            headers[headerName] = request.getHeader(headerName) ?: ""
        }
        println("Headers:")
        headers.forEach { (key, value) -> println("$key: $value") }
        return headers
    }
}