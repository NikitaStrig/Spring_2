package ru.skypro.lessons.springboot.weblibrar.repository.DTO;

import lombok.Data;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;

@Data
public class EmployeeDTO {
    // Поля для хранения идентификатора, имени и зарплаты сотрудника
    private Integer id;
    private String name;
    private Integer salary;

    // Метод для преобразования сущности Employee в объект EmployeeDTO
    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        return employeeDTO;
    }

    // Метод для преобразования объекта EmployeeDTO в сущность Employee
    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        return employee;
    }
}
