package gr.codehub.asyncwork.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class EmployeeDto {
    private int id;
    private String name;
    private BigDecimal salary;
}
