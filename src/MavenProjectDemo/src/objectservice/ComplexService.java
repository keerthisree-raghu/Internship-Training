package objectservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Path("empservice")
public class ComplexService {
	Employee emp;
	List<Employee> list = new ArrayList<>();

public ComplexService() {
	emp=new Employee(1,"ramu",1000);
	list.add(emp);
	emp=new Employee(2,"somu",2000);
	list.add(emp);
}

	@POST
	@Path("setemp")
//	@Consumes("application/xml")
	@Consumes("application/json")
	public void setEmployee(Employee emp) {
		System.out.println("New employee added: " + emp.getEid() + ": " + emp.getEname());
		this.emp = emp;
		list.add(emp);
	}
	
	@POST
	@Path("setAllEmp")
//	@Consumes("application/xml")
	@Consumes("application/json")
	public void setAllEmployee(List<Employee> list) {
		System.out.println("All employees are added: " + list);
		this.list = list;
	}

	@GET
	@Path("getemp/{eid}")
	// @Produces("application/xml")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("eid") String eid) {
		Iterator<Employee> iter = list.iterator();
		int eidnum = Integer.parseInt(eid);
		while (iter.hasNext()) {
			Employee e = iter.next();
			if (e.getEid() == eidnum) {
				return e;
			} else {
				return null;
			}
		}
		return null;
	}

	@GET
	@Path("getall")
	// @Produces("application/xml")
	@Produces("application/json")
	public List<Employee> getAllEmployees() {
		return this.list;
	}
}

@XmlRootElement(name = "employee")
class Employee {
	private int eid;
	private String ename;
	private int esal;

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, int esal) {
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	public final int getEid() {
		return eid;
	}

	public final void setEid(int eid) {
		this.eid = eid;
	}

	public final String getEname() {
		return ename;
	}

	public final void setEname(String ename) {
		this.ename = ename;
	}

	public final int getEsal() {
		return esal;
	}

	public final void setEsal(int esal) {
		this.esal = esal;
	}
}