package gr.codehub.asyncwork.repository;

import gr.codehub.asyncwork.model.Employee;
import gr.codehub.asyncwork.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query("SELECT p FROM Project p left JOIN FETCH p.employees WHERE p.id = :projectId")
    Optional<Project> findProjectWithEmployeesById(@Param("projectId") Long projectId);


    @Query("SELECT p FROM Project p left JOIN FETCH p.employees")
    List<Project> findProjectWithEmployeesAll();

}
