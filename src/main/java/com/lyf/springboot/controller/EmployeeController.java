package com.lyf.springboot.controller;

import com.lyf.springboot.dao.DepartmentDao;
import com.lyf.springboot.dao.EmployeeDao;
import com.lyf.springboot.entities.Department;
import com.lyf.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    //查询所有员工，返回列表页面
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面，查出所有部门，在页面显示
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //来到员工列表页面
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("emp",employee);
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
