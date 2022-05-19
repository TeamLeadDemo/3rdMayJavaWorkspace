package reflectiondemo;

// call this as an Entity in ORM

@MyTable(name="employee_details")
public class Employee {
	
	@MyColumn(name="emp_id")
	private int employeeId;
		
	@MyColumn(name="emp_name")
	private String employeeName;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
}
