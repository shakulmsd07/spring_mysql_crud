package demoproject1.crud.Emprepostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import demoproject1.crud.Empmodel.Employee;

public interface EmprepositoryImp extends JpaRepository<Employee,Integer> {
	

}