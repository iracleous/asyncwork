package gr.codehub.asyncwork.bootstrap;

import gr.codehub.asyncwork.model.Employee;
import gr.codehub.asyncwork.model.Project;
import gr.codehub.asyncwork.repository.EmployeeRepository;
import gr.codehub.asyncwork.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class SampleContent implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    @Override
    public void run(String... args) throws Exception {

        Employee employeeDimitris = Employee.builder()
                .name("Dimitris")
                .salary(new BigDecimal("999.99"))
                .build();
                employeeRepository.save(employeeDimitris);

        Employee employeeGeorge = Employee.builder()
                    .name("George")
                    .salary(new BigDecimal("999.99"))
                    .build();
                employeeRepository.save(employeeGeorge);

                Project projectA = Project.builder().name("A").build();
                projectRepository.save(projectA);


        Employee e1 =     employeeRepository.findEmployeeWithProjectsById(1L).get();
        Employee e2 =     employeeRepository.findEmployeeWithProjectsById(2L).get();
        Project p = projectRepository.findProjectWithEmployeesById(1L).get();
        logger.info("111111------"+e1.getProjects().size());
        logger.info("111111-------"+p.getEmployees().size());

        p.getEmployees().add(e1);
        p.getEmployees().add(e2);

        projectRepository.save( p);


    }
}
