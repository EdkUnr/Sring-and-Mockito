package com.department.homeworkmockito.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.department.homeworkmockito.employee.Employee;
import com.department.homeworkmockito.service.DepartmentService;
import com.department.homeworkmockito.service.DepartmentServiceImpl;
import com.department.homeworkmockito.service.EmployeeService;
import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DepartmentServiceTest {

    @Test
    public void testGetEmployeesByDepartmentId() {
        // Создаем мок EmployeeService
        EmployeeService employeeService = mock(EmployeeService.class);

        // Создаем экземпляр DepartmentService с использованием мока
        DepartmentService departmentService = new DepartmentServiceImpl(employeeService);

        // Создаем список сотрудников для отдела с ID 1
        List<Employee> employees = Arrays.asList(
                new Employee("John", 34000, 1),
                new Employee("Jane", 29000, 1)
        );

        // Устанавливаем поведение мока
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Вызываем метод, который тестируем
        List<Employee> result = departmentService.getEmployeesByDepartmentId(1);

        // Проверяем результат
        assertEquals(2, result.size());
    }

    @Test
    public void testGetSalarySumByDepartmentId() {
        // Создаем мок EmployeeService
        EmployeeService employeeService = mock(EmployeeService.class);

        // Создаем экземпляр DepartmentService с использованием мока
        DepartmentService departmentService = new DepartmentServiceImpl(employeeService);

        // Создаем список сотрудников для отдела с ID 1
        List<Employee> employees = Arrays.asList(
                new Employee("John", 23134, 1),
                new Employee("Jane", 54542, 1)
        );

        // Устанавливаем поведение мока
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Вызываем метод, который тестируем
        double result = departmentService.getSalarySumByDepartmentId(1);

        // Проверяем результат
        assertEquals(0, result, 0.001); // Предполагается, что зарплаты сотрудников равны нулю
    }

    @Test
    public void testGetMaxSalaryByDepartmentId() {
        // Создаем мок EmployeeService
        EmployeeService employeeService = mock(EmployeeService.class);

        // Создаем экземпляр DepartmentService с использованием мока
        DepartmentService departmentService = new DepartmentServiceImpl(employeeService);

        // Создаем список сотрудников для отдела с ID 1
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Jane", "Smith", 1, 6000)
        );

        // Устанавливаем поведение мока
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Вызываем метод, который тестируем
        double result = departmentService.getMaxSalaryByDepartmentId(1);

        // Проверяем результат
        assertEquals(6000, result, 0.001);
    }

    @Test
    public void testGetMinSalaryByDepartmentId() {
        // Создаем мок EmployeeService
        EmployeeService employeeService = mock(EmployeeService.class);

        // Создаем экземпляр DepartmentService с использованием мока
        DepartmentService departmentService = new DepartmentServiceImpl(employeeService);

        // Создаем список сотрудников для отдела с ID 1
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Doe", 1, 5000),
                new Employee("Jane", "Smith", 1, 6000)
        );

        // Устанавливаем поведение мока
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Вызываем метод, который тестируем
        double result = departmentService.getMinSalaryByDepartmentId(1);

        // Проверяем результат
        assertEquals(5000, result, 0.001);
    }

    @Test
    public void testGetEmployeesGroupedByDepartment() {
        // Создаем мок EmployeeService
        EmployeeService employeeService = mock(EmployeeService.class);

        // Создаем экземпляр DepartmentService с использованием мока
        DepartmentService departmentService = new DepartmentServiceImpl(employeeService);

        // Создаем список сотрудников
        List<Employee> employees = Arrays.asList(
                new Employee("John", 54654, 1),
                new Employee("Jane", 53420, 1),
                new Employee("Bob", 21354, 2),
                new Employee("Alice", 46861, 2)
        );

        // Устанавливаем поведение мока
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // Вызываем метод, который тестируем
        Map<Integer, List<Employee>> result = departmentService.getEmployeesGroupedByDepartment();

        // Проверяем результат
        assertEquals(2, result.size()); // Предполагается, что есть 2 отдела
        assertEquals(2, result.get(1).size()); // Предполагается, что в отделе 1 есть 2 сотрудника
        assertEquals(2, result.get(2).size()); // Предполагается, что в отделе 2 есть 2 сотрудника
    }
}

