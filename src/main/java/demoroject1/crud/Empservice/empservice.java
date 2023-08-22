package demoroject1.crud.Empservice;

import java.util.List;

//import demoproject1.crud.Empmodel.Employee;
import demoproject1.crud.EmpmodelDto.EmployeeDto;

public interface empservice {
	
	

	EmployeeDto addEmployeeservice(EmployeeDto emp);

	List<EmployeeDto> getallEmpservice();

	EmployeeDto  GetEmployeebyIdserv(int id);

	EmployeeDto updateEmployeeserv(EmployeeDto emp, int id);

	EmployeeDto deleteEmployeeserv(int id);

//	List<Employee> getallEmpservice();
//
//	Employee GetEmployeebyIdserv(int id);
//
//	Employee updateEmployeeserv(Employee emp, int id);
//
//	String deleteEmployeeserv(int id);
//


	

     


}
