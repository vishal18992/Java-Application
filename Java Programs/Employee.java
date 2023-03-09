import java.util.ArrayList;
import java.util.HashMap;


public class Employee {
	String firstName;
	String lastName;
	short age; 
	static int empId = 0;
	float salary = 1000.0f;
	boolean active = false;
	byte gender = 'M';
	HashMap<String,String> country = new HashMap<String, String>();

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void setAge(short age) {
		this.age = age;
	}

	void autoIncrementEmpId() {
		this.empId++;
	}

	int getEmpId() {
		return this.empId;
	}

	void setSalary(float salary) {
		this.salary = salary;
	}

	void setActive(boolean active) {
		this.active = active;
	}

	void setGender(byte gender) {
		this.gender = gender;
	}

	String getFirstName() {
		return this.firstName;
	}

	String getLastName() {
		return this.lastName.toString();
	}

	short getAge() {
		return this.age;
	}

	float getSalary() {
		return this.salary;
	}
	boolean getActive() {
		return this.active;
	}
	byte getGender() {
		return this.gender;
	}

	public static void main(String[] args) {

		HashMap<String,String> employeeMap1 = new HashMap<String, String>();
		HashMap<String,String> employeeMap2 = new HashMap<String, String>();
		ArrayList<HashMap<String,String>> employeeArrayMap = new ArrayList<HashMap<String,String>>();
		ArrayList<Object> emps = new ArrayList<Object>();

		employeeMap1.put("firstName", "VishalKumar");
		employeeMap1.put("lastName", "Patel");
		employeeMap1.put("age", "30");
		employeeMap1.put("salary", "4000.87");
		employeeMap1.put("active", "true");
		employeeArrayMap.add(employeeMap1);

		employeeMap2.put("firstName", "Jigar");
		employeeMap2.put("lastName", "Raval");
		employeeMap2.put("age", "30");
		employeeMap2.put("salary", "4033.87");
		employeeMap2.put("active", "true");
		employeeArrayMap.add(employeeMap2);


		for(int i = 0; i < employeeArrayMap.size(); i++) {
            Employee emp = new Employee();
			emp.setFirstName(employeeArrayMap.get(i).get("firstName"));
			emp.setLastName(employeeArrayMap.get(i).get("lastName"));
			emp.setAge((short) Short.parseShort(employeeArrayMap.get(i).get("age")));
			emp.autoIncrementEmpId();
			emps.add(emp);
			System.out.println(emp.getEmpId() + ":" + emp.getFirstName());
		}

		System.out.println(emps);

		// Employee el = new Employee();
		// el.setFirstName("VishalKumar");
		// el.setLastName("Patel");
		// el.setAge((short) 10);
		// el.autoIncrementEmpId();

		// el.setFirstName("VishalKumar");
		// el.setLastName("Patel");
		// el.setAge((short) 10);
		// el.autoIncrementEmpId();
		// System.out.println(el.getFirstName());
		// System.out.println(el.getLastName());
		// System.out.println(el.getAge());
	}
}