package com.department.homeworkmockito.service;

import com.department.homeworkmockito.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    @Autowired
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public double getSalarySumByDepartmentId(int departmentId) {
        return getEmployeesByDepartmentId(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public double getMaxSalaryByDepartmentId(int departmentId) {
        return getEmployeesByDepartmentId(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
    }

    @Override
    public double getMinSalaryByDepartmentId(int departmentId) {
        return getEmployeesByDepartmentId(departmentId).stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        Map<Integer, List<Employee>> groupedEmployees = new HashMap<>();
        for (Employee employee : employeeService.getAllEmployees()) {
            groupedEmployees.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>()).add(employee);
        }
        return groupedEmployees;
    }
}

