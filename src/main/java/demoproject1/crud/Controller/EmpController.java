/**
 * 
 */
package demoproject1.crud.Controller;

import java.util.List;
import java.util.ArrayList;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import demoproject1.crud.Empmodel.Employee;
import demoproject1.crud.EmpmodelDto.EmployeeDto;
import demoroject1.crud.Empservice.empservice;

/**
 * @author shakul
 * @Process Crud operation
 */
@RestController
@RequestMapping("/spring_crud/v1")
public class EmpController {
	
//	private static final Logger logger=LoggerFactory.getLogger(EmpController.class);
	@Autowired
	private empservice empServ;
	
//	@RequestMapping("/Employee")
//	public String EmployeePage()
//	{
//		return "Welcome Employee Page";
//	}
	@PostMapping("/AddEmployee")
	public EmployeeDto addEmployee(@RequestBody EmployeeDto emp) {
//		logger.info("welcome to my channel");
		return empServ.addEmployeeservice(emp);
	}
	
	@GetMapping("/GetEmployee")
	public List<EmployeeDto> getAllEmployee(){
//		logger.trace("Welcome to my channel");
		List<EmployeeDto> getEmployeecont = new ArrayList<EmployeeDto>();
		getEmployeecont = empServ.getallEmpservice();
		return getEmployeecont;
	}
	
	@GetMapping("/GetEmployeeByID/{id}")
	public  EmployeeDto  GetEmployeebyIdcont(@PathVariable int id)
	{
		return empServ.GetEmployeebyIdserv(id);
		
	}
	
	@PutMapping("/UpdateEmployee/{id}")
	public EmployeeDto updateEmployeecont(@RequestBody EmployeeDto emp,@PathVariable int id) {
		return empServ.updateEmployeeserv(emp,id);
	}
	
	@DeleteMapping("/DeleteEmployee/{id}")
	public EmployeeDto DeleteEmployeecont(@PathVariable int id)
	{
		return empServ.deleteEmployeeserv(id);
	
	}
}
		
	