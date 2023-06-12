package ru.skypro.lessons.springboot.weblibrar.controller;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeViewName;
import ru.skypro.lessons.springboot.weblibrar.service.EmployeeService;

import java.io.*;

import java.util.List;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmp() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/salaryHigherThan")
    public List<EmployeeViewName> findWithHighestSalary() {
        return employeeService.findWithHighestSalary();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);


    }

    @GetMapping("/{id}/fullInfo")
    public List<EmployeeFullInfo> findAllEmployeeFullInfo(@PathVariable("id") Integer id) {
        return employeeService.findAllEmployeeFullInfo(id);
    }

    @GetMapping("/position")
    public List<EmployeePosition> findAllEmployeePosition(@RequestParam("position") String positionName) {
        if (positionName == "") {
            return employeeService.findAllEmployeeNoPosition();
        } else {
            return employeeService.findAllEmployeePosition(positionName);
        }
    }

    @GetMapping("/page")
    public List<EmployeeViewName> findAllEmployeeFullInfoPage(@RequestParam("page") Integer page) {
        int v = 3;
        if (page == null) {
            return employeeService.findAllEmployeeFullInfoNoPage();
        }
        if (page == 0) {
            return employeeService.findAllEmployeeFullInfoNoPage();
        }
        else {
            page = page * v;
            return employeeService.findAllEmployeeFullInfoPage(page);
        }
    }

  //  @PostMapping(value = "/upload")
//    public Employee uploadFile() throws IOException {
//        Employee employee = new Employee();
//        JSONParser parser = new JSONParser();
//        try(FileReader reader = new FileReader("test.json")) {
//            JSONObject jsonObjectPars = (JSONObject) parser.parse(reader);
//            JSONArray jsonArray = jsonObjectPars.get("")
//        }
//
//
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

       // }
    }




