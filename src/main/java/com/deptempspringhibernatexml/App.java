package com.deptempspringhibernatexml;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.deptempspringhibernatexml.dao.DeptEmpDao;
import com.deptempspringhibernatexml.model.Department;
import com.deptempspringhibernatexml.model.Employee;




public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appc = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        DeptEmpDao empDao = (DeptEmpDao) appc.getBean("eDao");
        
        System.out.println("insert into department");
        
        Department dept = new Department(3,"HR","Chennai");
        Department dept2 = new Department(7,"Technical","palakkad");
       
        

        	empDao.createDept(dept2);
        System.out.println("update");
        
       dept.setDeptName("support");
       dept.setDeptLoc("america");
        
        empDao.updateDept(dept);
        
        System.out.println("show employee");
        List<Department> dep = empDao.readAllDept();
        for (Department department : dep) {
 		  System.out.println(department.getDeptId()+" "+department.getDeptName()+department.getDeptLoc());
 	}
        System.out.println("delete");
       empDao.delteDept(2);
        
        System.out.println("show employee");
       List<Department> depp = empDao.readAllDept();
        for (Department department : depp) {
 		  System.out.println(department.getDeptId()+" "+department.getDeptName()+department.getDeptLoc());
 	}
     
    Department dfg = new Department();
     dfg.setDeptId(dept.getDeptId());
     
     Employee emp = new Employee(10,"udhay","1997-07-29","udhaya@gmail.com",9876543215L,45632.26f,"HCL",dfg);
     dfg.setDeptId(4);
     Employee emp1 = new Employee(12,"Soorya","1994-04-29","udhaya@gmail.com",9876543215L,45632.26f,"HCL",dfg);
    
     Employee emp2 = new Employee(13,"Raj","1997-07-29","udhaya@gmail.com",9876543215L,45632.26f,"HCL",dfg);
     dfg.setDeptId(1);
     Employee emp3 = new Employee(14,"Kishore","1997-07-29","udhaya@gmail.com",9876543215L,45632.26f,"HCL",dfg);
     
     System.out.println("Employee inserted");
        empDao.createEmp(emp3);
   
     
     System.out.println("update employee name");
     emp.setDateOfBirth("1997-07-29");
     emp.setMailId("udhaya@gmail.com");
     empDao.updateEmp(emp);
     
     
     
     System.out.println("list emp from dept");
     empDao.readEmpFromDept(1);
     
    
     List<Employee> empLis = empDao.readEmpFromDept(1);
     
     for (Employee employee : empLis) {
 		System.out.println("employee name :"+employee.getEmpName());
 	}
     System.out.println("delete emp from dept");
     
     Employee emps = new Employee();
     
     
     empDao.deleteEmpFromDept(dept.getDeptId(), 8);
     
List<Employee> empList = empDao.readEmpFromDept(dept.getDeptId());
     
     for (Employee employee : empList) {
 		System.out.println("employee name :"+employee.getEmpName());
 		
 	}
     System.out.println("delete");
     empDao.deleteEmpFromDept(12, 3);
    }
     
}
