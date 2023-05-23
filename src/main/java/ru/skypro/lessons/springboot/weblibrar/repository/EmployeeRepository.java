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

    @Query(value = "select e.name, e.salary, p.positio_nname " +
            "from Employee e inner join Position p  on e.position_id = p.id  where p.id = :id",
            nativeQuery = true)
    List<EmployeeFullInfo> findAllEmployeeFullInfo(@Param("id") Integer id);

}





