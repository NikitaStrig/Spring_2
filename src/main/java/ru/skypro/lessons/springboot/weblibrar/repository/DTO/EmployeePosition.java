package ru.skypro.lessons.springboot.weblibrar.repository.DTO;

import lombok.Data;

@Data
public class EmployeePosition {
    // Имя сотрудника
    private String name;
    private Integer salary;
    private String positionName;
    public EmployeePosition(String name, Integer salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
    }
}
