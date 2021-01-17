package org.patrickkabongo.service;

import org.patrickkabongo.exception.ExceptionHandler;
import org.patrickkabongo.model.Employee;
import org.patrickkabongo.repository.EmployeeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){

        return employeeRepository.listAll();
    }

    @Transactional
    public Employee addEmployee (Employee employee){

        employeeRepository.persist(employee);

        return employee;
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employee){

        Employee employeeTemp = employeeRepository.findById(id);
        if (Objects.equals(employeeTemp, null)){
            throw new ExceptionHandler("The employee doesn't exist");
        }
        employeeTemp.setFirstName(employee.getFirstName());
        employeeTemp.setLastName(employee.getLastName());
        employeeTemp.setEmail(employee.getEmail());

        employeeRepository.persist(employeeTemp);
        return employeeTemp;
    }

    @Transactional
    public Boolean deleteEmployee(Long id){

        Employee employeeTemp = employeeRepository.findById(id);
        if (Objects.equals(employeeTemp, null)){
            throw new ExceptionHandler("The employee doesn't exist");
        }

        employeeRepository.deleteById(id);
        return true;
    }
}


