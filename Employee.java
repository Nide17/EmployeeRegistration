import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.Map;

public class Employee {
	private final int pensionAge = 65;
	private String employeeID;
	private EmployeeType employeeType;
	private String firstName;
	private String lastName;
	private Gender empGender;
	private String contactNumber;
	private String address;
	private Level empLevel;
	private LocalDate dateStarted;
	private LocalDate dob;
	private EducationLevel empEducationLevel;
	private double salary;
	private MaritalStatus empMaritalStatus;
	private String empDepartment;
	private String empPosition;

	// CONSTRUCTORS
	public Employee() {

		this.setEmployeeID("00");
		this.setEmployeeType(EmployeeType.INTERN);
		this.setFirstName("Mark");
		this.setLastName("Cuban");
		this.setEmpGender(Gender.MALE);
		this.setContactNumber("0794352134");
		this.setAddress("KG 154 Street, Kigali");
		this.setEmpLevel(Level.MANAGER);
		this.setDateStarted(LocalDate.of(2020, 05, 19));
		this.setDob(LocalDate.of(1980, 4, 12));
		this.setEmpEducationLevel(EducationLevel.MASTERS);
		this.setSalary(5000.00);
		this.setEmpMaritalStatus(MaritalStatus.SINGLE);
		this.setEmpDepartment(departments.get("1"));
		this.setEmpPosition(positions.get("3"));
	}

	public Employee(String employeeID, EmployeeType employeeType, String firstName, String lastName, Gender empGender,
			String contactNumber,
			String address, Level empLevel, LocalDate dateStarted, LocalDate dob, EducationLevel empEducationLevel,
			double salary, MaritalStatus empMaritalStatus, String empDepartment, String empPosition) {
		this.employeeID = employeeID;
		this.employeeType = employeeType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empGender = empGender;
		this.contactNumber = contactNumber;
		this.address = address;
		this.empLevel = empLevel;
		this.dateStarted = dateStarted;
		this.dob = dob;
		this.empEducationLevel = empEducationLevel;
		this.salary = salary;
		this.empMaritalStatus = empMaritalStatus;
		this.empDepartment = empDepartment;
		this.empPosition = empPosition;
	}

	// GETTERS AND SETTERS
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public int getPensionAge() {
		return this.pensionAge;
	}

	public EmployeeType getEmployeeType() {
		return this.employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getEmpGender() {
		return this.empGender;
	}

	public void setEmpGender(Gender empGender) {
		this.empGender = empGender;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Level getEmpLevel() {
		return this.empLevel;
	}

	public void setEmpLevel(Level empLevel) {
		this.empLevel = empLevel;
	}

	public LocalDate getDateStarted() {
		return this.dateStarted;
	}

	public void setDateStarted(LocalDate dateStarted) {
		this.dateStarted = dateStarted;
	}

	public LocalDate getDob() {
		return this.dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public EducationLevel getEmpEducationLevel() {
		return this.empEducationLevel;
	}

	public void setEmpEducationLevel(EducationLevel empEducationLevel) {
		this.empEducationLevel = empEducationLevel;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MaritalStatus getEmpMaritalStatus() {
		return this.empMaritalStatus;
	}

	public void setEmpMaritalStatus(MaritalStatus empMaritalStatus) {
		this.empMaritalStatus = empMaritalStatus;
	}

	// getter and setter for department
	public String getEmpDepartment() {
		return this.empDepartment;
	}

	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}

	// getter and setter for position
	public String getEmpPosition() {
		return this.empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}

	// METHODS
	/**
	 * @return the number years worked in the company
	 */
	public int yearsInCompany() {
		Period years = Period.between(this.dateStarted, LocalDate.now());
		return years.getYears();
	}

	/**
	 * @return the age of the employee
	 */
	public int calculateAge() {
		Period years = Period.between(this.dob, LocalDate.now());
		return years.getYears();
	}

	/**
	 * @return the age remaining for an employee to go on persion
	 */
	public int yearsToPension() {
		return this.pensionAge - this.calculateAge();
	}

	@Override
	// create a toString method to display the employee details using formatter
	public String toString() {
		return String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s",
				this.employeeType, this.firstName, this.lastName, this.empGender, this.contactNumber, this.address,
				this.empLevel, this.dateStarted, this.dob, this.empEducationLevel, this.salary, this.empMaritalStatus,
				this.empDepartment, this.empPosition);
	}

	// create gender of enum type
	static enum Gender {
		MALE,
		FEMALE
	}

	// create level of enum type
	static enum Level {
		CSUITE,
		DIRECTOR,
		MANAGER,
		OFFICER
	}

	// create education level of enum type
	static enum EducationLevel {
		HIGH_SCHOOL,
		BACHELORS,
		MASTERS,
		PHD
	}

	// create marital status of enum type
	static enum MaritalStatus {
		SINGLE,
		MARRIED,
		DIVORCED
	}

	// create enum for employee type
	static enum EmployeeType {
		PERMANENT,
		CONTRACT,
		INTERN
	}

	// create hashmap for departments
	public static Map<String, String> departments = new LinkedHashMap<String, String>();
	static {
		departments.put("1", "Human Resources");
		departments.put("2", "Finance");
		departments.put("3", "Sales");
		departments.put("4", "Marketing");
		departments.put("5", "Technology");
		departments.put("6", "Administration");
	}

	// create hashmap for positions
	public static Map<String, String> positions = new LinkedHashMap<String, String>();

	static {

		positions.put("0", "Human Resources Officer");

		positions.put("1", "Director of Human Resources");
		positions.put("2", "Director of Finance");
		positions.put("3", "Director of Sales");
		positions.put("4", "Director of Marketing");
		positions.put("5", "Director of Technology");

		positions.put("6", "Manager of Human Resources");
		positions.put("7", "Manager of Finance");
		positions.put("8", "Manager of Sales");
		positions.put("9", "Manager of Marketing");
		positions.put("10", "Manager of Technology");

		positions.put("11", "Human Resources Officer");
		positions.put("12", "Financial Officer");
		positions.put("13", "Sales Officer");
		positions.put("14", "Marketing Officer");
		positions.put("15", "Technology Officer");

		positions.put("16", "Administration Officer");
	}
}
