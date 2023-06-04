package ru.skypro.lessons.springboot.weblibrar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/admin/employees")
public class AdminEmployeeController {

}
