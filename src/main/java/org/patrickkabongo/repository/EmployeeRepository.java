package org.patrickkabongo.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.patrickkabongo.model.Employee;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

}
