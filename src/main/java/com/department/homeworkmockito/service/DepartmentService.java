package com.department.homeworkmockito.service;

import com.department.homeworkmockito.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> getEmployeesByDepartmentId(int departmentId);

    double getSalarySumByDepartmentId(int departmentId);

    double getMaxSalaryByDepartmentId(int departmentId);

    double getMinSalaryByDepartmentId(int departmentId);

    Map<Integer, List<Employee>> getEmployeesGroupedByDepartment();
}
