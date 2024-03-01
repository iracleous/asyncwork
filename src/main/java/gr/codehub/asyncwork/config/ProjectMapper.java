package gr.codehub.asyncwork.config;

import gr.codehub.asyncwork.dto.EmployeeDto;
import gr.codehub.asyncwork.dto.ProjectDto;
import gr.codehub.asyncwork.model.Employee;
import gr.codehub.asyncwork.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {


   public ProjectDto projectToProjectDto(Project project);
    public EmployeeDto employeeToEmployeeDto(Employee employee);

}
