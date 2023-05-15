package ru.skypro.lessons.springboot.weblibrar.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;

import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    // Коллекция для имитации данных
    private final List<Employee> employeeList = List.of(
                new Employee(1,"Koka", 95000),
                new Employee(2,"Dima", 102000),
                new Employee(3,"Lera", 500000),
                new Employee(4,"Mary", 340000),
                new Employee(5,"Kokaf", 450000));
    Collection<Employee> values = employeeList;
    List<Employee> employeeArrayListMod = new ArrayList<>(values);


    @Override
    public List<Employee> getAllEmployees() {
        return employeeArrayListMod;
    }

    @Override
    public String getMaxSolary(){
            int i;
            int  max = employeeArrayListMod.get(0).getSalary();
            String name = "";
            for (i = 0; i < employeeArrayListMod.size(); i++) {
                if (employeeArrayListMod.get(i).getSalary() >= max) {
                    max = employeeArrayListMod.get(i).getSalary();
                    name = employeeArrayListMod.get(i).getName();
                }
            }
            return "Мксимальная зарплата у "  + name;
        }

    @Override
    public String getMinSolary(){
        int i;
        int  max = employeeArrayListMod.get(0).getSalary();
        String name = "";
        for (i = 0; i < employeeArrayListMod.size(); i++) {
            if (employeeArrayListMod.get(i).getSalary() <= max) {
                max = employeeArrayListMod.get(i).getSalary();
                name = employeeArrayListMod.get(i).getName();
            }
        }
        return "Минимальная  зарплата у "  + name;
    }

    @Override
    public int getSumAllSolary(){
        int i;
        int sum = 0;
        for (i = 0; i < employeeArrayListMod.size(); i++) {
                sum = sum + employeeArrayListMod.get(i).getSalary();
        }
        return sum;
    }
    public String getHighSolary(){
        int i;
        int avg = getSumAllSolary() / employeeArrayListMod.size();
        String nameavg = "";
        for (i = 0; i < employeeArrayListMod.size(); i++) {
           if (employeeArrayListMod.get(i).getSalary() >= avg){
               nameavg = nameavg + "\n" + employeeArrayListMod.get(i).getName() + " " + employeeArrayListMod.get(i).getSalary();
            }

        }


        return nameavg;
    }
   @Override
    public void deleteId(int id){
        employeeArrayListMod.removeIf(employee -> employee.getId() == id);
}

    @Override
    public String getSearchId(int id){
        String idf = "";
        for (int i = 0; i < employeeArrayListMod.size() ; i++) {
            if (employeeArrayListMod.get(i).getId() == id){
                idf = employeeArrayListMod.get(i).getName() + " " + employeeArrayListMod.get(i).getSalary();
            }
        }
        return idf;
    }

    public String getsalaryHigherThan(int salary){
        String getEmp = " ";
        for (int i = 0; i < employeeArrayListMod.size(); i++) {
            if (employeeArrayListMod.get(i).getSalary() > salary) {
                getEmp = getEmp + "\n" + employeeArrayListMod.get(i).getName();
            }
        }
        return getEmp;

    }

public String addEmployee (Employee employee){
       employeeArrayListMod.add(employee);
        return "Add Complited";
}
public String updateEmployee(Employee employee, int id){
        for (Employee employees: employeeArrayListMod){
            if (employees.getId() == id){
                employees.setName(employee.getName());
                employees.setSalary(employee.getSalary());
            }
        }return "Update complited";

}






}
