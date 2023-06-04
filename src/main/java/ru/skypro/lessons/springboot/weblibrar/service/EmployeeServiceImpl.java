package ru.skypro.lessons.springboot.weblibrar.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.jni.FileInfo;
//import org.hamcrest.MatcherAssert;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeViewName;
import ru.skypro.lessons.springboot.weblibrar.repository.EmployeeRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> resolt = new ArrayList<>();
        employeeRepository.findAll()
                .forEach(resolt::add);
        return resolt.stream()
                .map(EmployeeDTO::fromEmployee)
                .toList();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void addFile(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeViewName> findWithHighestSalary() {
        return employeeRepository.findWithHighestSalary();

    }

    @Override
    public List<EmployeeFullInfo> findAllEmployeeFullInfo(Integer id) {
        return employeeRepository.findAllEmployeeFullInfo(id);

    }

    @Override
    public List<EmployeePosition> findAllEmployeePosition(String positionName) {
        return employeeRepository.findAllEmployeePosition(positionName);
    }

    @Override
    public List<EmployeePosition> findAllEmployeeNoPosition() {
        return employeeRepository.findAllEmployeeNoPosition();
    }

    @Override
    public List<EmployeeViewName> findAllEmployeeFullInfoPage(int page) {
        return employeeRepository.findAllEmployeeFullInfoPage(page);
    }

    @Override
    public List<EmployeeViewName> findAllEmployeeFullInfoNoPage() {
        return employeeRepository.findAllEmployeeFullInfoNoPage();
    }

    @Override
    public List<Employee> parser() {
        return null;
    }

}





