package com.library.controllers;

import com.library.payloads.response.ProjectInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public @ResponseBody ProjectInfo indexPath() {
        return new ProjectInfo(
                "Wizer CodeChallenge",
                "You are required to build a simple book library"+
                        "This code challenge is designed to assess your general understanding of RESTful API principles and" +
                        "software development in Java. You will be accessed based on your ability to:" +
                        "• Develop clean, reusable and maintainable features; • Follow best practices for coding styles and conventions; and" +
                        "• Efficiently retrieve and manipulate data.",
                "Emmanuel Ogbinaka",
                LocalDate.of(2021, Month.OCTOBER,8),
                null
        );
    }
}
