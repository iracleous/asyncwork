package gr.codehub.asyncwork.repository;

import gr.codehub.asyncwork.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e left JOIN FETCH e.projects WHERE e.id = :employeeId")
    Optional<Employee> findEmployeeWithProjectsById(@Param("employeeId") Long employeeId);

}
