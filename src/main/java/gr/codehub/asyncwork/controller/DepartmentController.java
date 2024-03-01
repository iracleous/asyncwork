package gr.codehub.asyncwork.controller;

import gr.codehub.asyncwork.config.ProjectMapper;
import gr.codehub.asyncwork.dto.EmployeeDto;
import gr.codehub.asyncwork.dto.ProjectDto;
import gr.codehub.asyncwork.repository.EmployeeRepository;
import gr.codehub.asyncwork.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class DepartmentController {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMapper mapper;
    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees(){
        return employeeRepository
                .findAll()
                .stream()
                .map(mapper::employeeToEmployeeDto )
                .collect(Collectors.toList());
    }

    @GetMapping("/projects")
    public List<ProjectDto> getProjects(){

        return projectRepository
                .findProjectWithEmployeesAll()
                .stream()
                .map(mapper::projectToProjectDto)
                .collect(Collectors.toList());
    }
}
