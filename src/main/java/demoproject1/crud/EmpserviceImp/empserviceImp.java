package demoproject1.crud.EmpserviceImp;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demoproject1.crud.Empmodel.Employee;
import demoproject1.crud.EmpmodelDto.EmployeeDto;
import demoproject1.crud.Emprepostiory.EmprepositoryImp;
import demoroject1.crud.Empservice.empservice;

@Service
public class empserviceImp implements empservice {
	
	@Autowired
	private EmprepositoryImp empreposImp;
	
//	@Override
//	public Employee addEmployeeservice(Employee emp) {
//		
//        Employee empserviceImp = new Employee();
//		
//        empserviceImp.setId(emp.getId());
//        empserviceImp.setName(emp.getName());
//        empreposImp.save(empserviceImp);
//		return empserviceImp;
//	}

	@Override
	public EmployeeDto addEmployeeservice(EmployeeDto empDto) {
		// TODO Auto-generated method stub
		 EmployeeDto resultempDto = new EmployeeDto();
		 Employee emp= new Employee();
		 
//		 emp.setId(empDto.getId());
		 emp.setName(empDto.getName());
		 emp.setDesignation(empDto.getDesignation());
		 emp.setSalary(empDto.getSalary());
		 emp.setMobile_number(empDto.getMobile_number());
		 empreposImp.save(emp);
		 resultempDto.setMessage("Employee Added");
		 resultempDto.setStaus(1);
		 return resultempDto;
	}

	@Override
	public List<EmployeeDto> getallEmpservice() {
		// TODO Auto-generated method stub
		List<EmployeeDto> empDtolist=new ArrayList<EmployeeDto>();
		List<Employee> emplist=empreposImp.findAll();
		for (Employee emp:emplist) {
			
		empDtolist.add(this.getallEmpserviceDto(emp));
		
    	}
		
		
		return empDtolist;
	}

	private EmployeeDto getallEmpserviceDto(Employee emp) {
		// TODO Auto-generated method stub
		EmployeeDto empDtolist=new EmployeeDto();
	     empDtolist.setId(emp.getId());
	     empDtolist.setName(emp.getName());
	     empDtolist.setDesignation(emp.getDesignation());
	     empDtolist.setSalary(emp.getSalary());
	     empDtolist.setMobile_number(emp.getMobile_number());
		
		return (EmployeeDto) empDtolist;
	}

	@Override
	public EmployeeDto GetEmployeebyIdserv(int id) {
		// TODO Auto-generated method stub
		EmployeeDto empDto= new EmployeeDto();
	    Employee emp=empreposImp.findById(id).orElse(null);
	    if(emp!=null)
	    {
	    	empDto.setId(emp.getId());
			empDto.setName(emp.getName());
			empDto.setDesignation(emp.getDesignation());
			empDto.setSalary(emp.getSalary());
			empDto.setMobile_number(emp.getMobile_number());
			return empDto;
	     }
	    else
	    {
	    	empDto.setMessage("Given Id does not exist");
	    	empDto.setStaus(0);
	    	return empDto;
	    }
		
	}

	@Override
	public EmployeeDto updateEmployeeserv(EmployeeDto emp, int id) {
		// TODO Auto-generated method stub
		Employee empupdate=empreposImp.findById(id).orElse(null);
		
		EmployeeDto empupdatedto=new EmployeeDto();
		if (empupdate != null )
		{
//			empupdate.setId(emp.getId());-->stuck with alter id error
			empupdate.setName(emp.getName());
			empupdate.setDesignation(emp.getDesignation());
			empupdate.setSalary(emp.getSalary());
			empupdate.setMobile_number(emp.getMobile_number());
			empreposImp.save(empupdate);
			empupdatedto.setMessage("update successfully");
			empupdatedto.setStaus(1);
			return empupdatedto;
		}
		else 
		{
			empupdatedto.setMessage("Given Id does not exist");
			empupdatedto.setStaus(0);
		   return empupdatedto;
		}
	}

	@Override
	public EmployeeDto deleteEmployeeserv(int id) {
		// TODO Auto-generated method stub
		EmployeeDto delempdto=new EmployeeDto();
		Employee delemp=empreposImp.findById(id).orElse(null);
		if(delemp != null)
		{
			empreposImp.deleteById(id);
			delempdto.setMessage("Delete Successfully");
			delempdto.setStaus(1);
			return delempdto;
		}
		else
		{
			delempdto.setMessage("Given Id does not exist");
			delempdto.setStaus(0);
			return delempdto;
			
		}
		
	}

//	@Override
//	public List<Employee> getallEmpservice() {
//		List<Employee> empserviceImp=new ArrayList<Employee>();
//		empserviceImp=empreposImp.findAll();
//		return empserviceImp;
//	}
//
//	@Override
//	public Employee GetEmployeebyIdserv(int id) {
//		Employee empserviceImp=empreposImp.findById(id).orElse(null);
//		return empserviceImp;
//		
//	}
//
//	public Employee updateEmployeeserv(Employee emp, int id) {
//		
//	    Employee empserviceImp=empreposImp.findById(id).orElse(null);
//		
//		if(empserviceImp !=null)
//		{
////	      empserviceImp.setId(emp.getId());
//          empserviceImp.setName(emp.getName());
//          empreposImp.save(empserviceImp);
//          return empserviceImp;
//		}
//		return null;
//		
//	}
//
//	@Override
//	public String deleteEmployeeserv(int id) {
//		Employee empserviceImp=empreposImp.findById(id).orElse(null);
//		if(empserviceImp !=null)
//		{		
//			empreposImp.deleteById(id);
//			return "True";
//		}
//		else
//		{
//		return "False";
//		}
//	}

	

	

}
