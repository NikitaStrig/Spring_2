package ru.skypro.lessons.springboot.weblibrar.repository;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.skypro.lessons.springboot.weblibrar.controller.Employee;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeDTO;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition;
import ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeViewName;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>  {
@Query(value = "select name from employee " +
        "where salary = (select max(salary) from employee)", nativeQuery = true)
List<EmployeeViewName> findWithHighestSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeeFullInfo(e.name , e.salary , p.positioNname) FROM Employee e inner join  Position p WHERE e.id = :id and e.position = p.id")
    List<EmployeeFullInfo> findAllEmployeeFullInfo(@Param("id") Integer id);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition(e.name , e.salary , p.positioNname) FROM Employee e inner join  Position p WHERE p.positioNname = :positionName and e.position = p.id")
    List<EmployeePosition> findAllEmployeePosition(@Param("positionName") String positionName);

    @Query("SELECT new ru.skypro.lessons.springboot.weblibrar.repository.DTO.EmployeePosition(e.name , e.salary , p.positioNname)  FROM Employee e join fetch Position p WHERE e.position = p")
    List<EmployeePosition> findAllEmployeeNoPosition();


    @Query(value = "SELECT * FROM Employee e inner join  Position p on e.position_id = p.id where e.id > :page LIMIT 3",nativeQuery = true)
    List<EmployeeViewName> findAllEmployeeFullInfoPage(@Param("page") int page);

    @Query(value = "SELECT * FROM Employee e inner join  Position p on e.position_id = p.id LIMIT 3",nativeQuery = true)
    List<EmployeeViewName> findAllEmployeeFullInfoNoPage();


}






