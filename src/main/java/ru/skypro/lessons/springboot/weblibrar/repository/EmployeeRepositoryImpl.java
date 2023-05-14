package ru.skypro.lessons.springboot.weblibrar.repository;

import org.springframework.stereotype.Repository;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    // Коллекция для имитации данных
    private final List<Employee> employeeList = List.of(
            new Employee(1,"Koka", 95000),
            new Employee(2,"Dima", 102000),
            new Employee(3,"Lera", 500000),
            new Employee(4,"Mary", 340000),
            new Employee(5,"Kokaf", 450000));

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public String getMaxSolary(){
            int i;
            int  max = employeeList.get(0).getSalary();
            String name = "";
            for (i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getSalary() >= max) {
                    max = employeeList.get(i).getSalary();
                    name = employeeList.get(i).getName();
                }
            }
            return "Мксимальная зарплата у "  + name;
        }

    @Override
    public String getMinSolary(){
        int i;
        int  max = employeeList.get(0).getSalary();
        String name = "";
        for (i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSalary() <= max) {
                max = employeeList.get(i).getSalary();
                name = employeeList.get(i).getName();
            }
        }
        return "Минимальная  зарплата у "  + name;
    }

    @Override
    public int getSumAllSolary(){
        int i;
        int sum = 0;
        for (i = 0; i < employeeList.size(); i++) {
                sum = sum + employeeList.get(i).getSalary();
        }
        return sum;
    }
    public String getHighSolary(){
        int i;
        int avg = getSumAllSolary() / employeeList.size();
        String nameavg = "";
        for (i = 0; i < employeeList.size(); i++) {
           if (employeeList.get(i).getSalary() >= avg){
               nameavg = nameavg + "\n" + employeeList.get(i).getName() + " " + employeeList.get(i).getSalary();
            }

        }


        return nameavg;
    }
   @Override
    public void deleteId(int id){
        employeeList.removeIf(employee -> employee.getId() == id);
}

    @Override
    public String getSearchId(int id){
        String idf = "";
        for (int i = 0; i < employeeList.size() ; i++) {
            if (employeeList.get(i).getId() == id){
                idf = employeeList.get(i).getName() + " " + employeeList.get(i).getSalary();
            }
        }
        return idf;
    }

    public String getsalaryHigherThan(int salary){
        String getEmp = " ";
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getSalary() > salary) {
                getEmp = getEmp + "\n" + employeeList.get(i).getName();
            }
        }
        return getEmp;
    }








}
