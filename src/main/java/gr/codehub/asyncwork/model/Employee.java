package gr.codehub.asyncwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Employee extends Person{
    private BigDecimal salary;

    @ManyToMany(mappedBy = "employees")
    private List<Project> projects= new ArrayList<>();
}
