package fr.kybox.ws.dao;

import fr.kybox.ws.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e " +
            "WHERE " +
            "UPPER(e.firstName) LIKE CONCAT('%', upper(?1), '%') " +
            "OR " +
            "UPPER(e.lastName) LIKE CONCAT('%', upper(?1), '%') ")
    List<Employee> findEmployees(String keyword);
}
