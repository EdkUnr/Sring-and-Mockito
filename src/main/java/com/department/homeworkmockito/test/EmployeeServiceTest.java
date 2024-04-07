package com.department.homeworkmockito.test;

import static org.junit.Assert.*;

import com.department.homeworkmockito.employee.Employee;
import com.department.homeworkmockito.service.EmployeeService;
import org.junit.Test;

public class EmployeeServiceTest {

    @Test
    public void testAddEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John", "Doe");
        employeeService.addEmployee(employee);
        assertTrue(employeeService.getAllEmployees().contains(employee));
    }

    @Test
    public void testRemoveExistingEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John", "Doe");
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee);
        assertFalse(employeeService.getAllEmployees().contains(employee));
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveNonExistingEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John", "Doe");
        employeeService.removeEmployee(employee);
    }

    @Test
    public void testFindExistingEmployee() {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = new Employee("John", "Doe");
        employeeService.addEmployee(employee);
        assertEquals(employee, employeeService.findEmployee("John", "Doe"));
    }

    @Test(expected = RuntimeException.class)
    public void testFindNonExistingEmployee() {
        EmployeeService employeeService = new EmployeeService();
        employeeService.findEmployee("John", "Doe");
    }
}
