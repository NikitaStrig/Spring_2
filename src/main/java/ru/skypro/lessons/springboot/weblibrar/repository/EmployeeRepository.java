package ru.skypro.lessons.springboot.weblibrar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeViewName;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {
@Query(value = "select name from employee " +
        "where salary = (select max(salary) from employee)", nativeQuery = true)
List<EmployeeViewName> findWithHighestSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo(e.name , e.salary , p.positioNname) FROM Employee e join fetch Position p WHERE e.position = :id")
    List<EmployeeFullInfo> findAllEmployeeFullInfo(@Param("id") Integer id);

}





