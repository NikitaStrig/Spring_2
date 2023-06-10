package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;

import java.util.List;

@RestController
@RequestMapping("/appInfo")
public class InfoController {
    @Value("${app.env}")
    private String apiKey;
    @GetMapping
    public void info () {
        System.out.println(apiKey);
    }
}
