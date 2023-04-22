import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeDatabase {

    private static Map<String, Employee> employees;

    public EmployeeDatabase() {
        employees = new LinkedHashMap<>();

    }

    public Employee getEmployee(String i) {
        return employees.get(i);
    }

    public void createEmployee(String i, Employee employee) {
        employees.put(i, employee);
    }

    // get the the largest employee id
    public int getLargestEmployeeId() {
        String largestId = "0";
        Set<String> keys = employees.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (Integer.parseInt(key) > Integer.parseInt(largestId)) {
                largestId = key;
            }
        }
        return Integer.parseInt(largestId);
    }

    public ArrayList<String> getEmployeeNames() {
        ArrayList<String> names = new ArrayList<>();

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            names.add(employees.get(key).getFirstName());
        }

        return names;
    }

    // list employee information by employee id on separate lines
    public void listEmployeeInformation() {
        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println(employees.get(key).toString());
        }
    }

    // return the list of departments in the company
    public static ArrayList<String> getDepartments() {
        ArrayList<String> departments = new ArrayList<>();

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();

            // check if the department is already in the list
            if (!departments.contains(employees.get(key).getEmpDepartment()))
                departments.add(employees.get(key).getEmpDepartment());
        }

        return departments;
    }

    // return number of employees in a department

    public static int getNumberOfEmployeesInDepartment(String department) {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpDepartment().equals(department)) {
                count++;
            }
        }

        return count;
    }

    // get the list of departments and the number of employees in each department on
    // separate lines
    public static String getDepartmentListAndNumberOfEmployees() {
        ArrayList<String> departments = getDepartments();

        String departInfo = "";

        String title = "\n\nDepartment\t\tNumber of Employees";
        departInfo += title;

        for (String department : departments) {
            String departStat = "";
            departStat += "\n" + department + "\t\t";
            departStat += getNumberOfEmployeesInDepartment(department);
            departInfo += departStat;
        }
        return departInfo;
    }

    // return total number of employees
    public static int getNumberOfEmployees() {
        return employees.size();
    }

    // return average salary of employees
    public double getAverageSalary() {
        double totalSalary = 0;
        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            totalSalary += employees.get(key).getSalary();
        }

        return totalSalary / employees.size();
    }

    // return the list of positions in the company
    public ArrayList<String> getPositions() {
        ArrayList<String> positions = new ArrayList<>();

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            positions.add(employees.get(key).getEmpPosition());
        }

        return positions;
    }

    // return total counts of males
    public static int getNumberOfMales() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpGender().equals(Employee.Gender.MALE)) {
                count++;
            }
        }

        return count;
    }

    // return total counts of females
    public static int getNumberOfFemales() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpGender().equals(Employee.Gender.FEMALE)) {
                count++;
            }
        }
        return count;
    }

    // return total single employees
    public static int getNumberOfSingleEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpMaritalStatus().equals(Employee.MaritalStatus.SINGLE)) {
                count++;
            }
        }

        return count;
    }

    // return total married employees
    public static int getNumberOfMarriedEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpMaritalStatus().equals(Employee.MaritalStatus.MARRIED)) {
                count++;
            }
        }

        return count;
    }

    // return of divorced employees
    public static int getNumberOfDivorcedEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpMaritalStatus().equals(Employee.MaritalStatus.DIVORCED)) {
                count++;
            }
        }

        return count;
    }

    // return total phd employees
    public static int getNumberOfPhdEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpEducationLevel().equals(Employee.EducationLevel.PHD)) {
                count++;
            }
        }

        return count;
    }

    // return total masters employees
    public static int getNumberOfMastersEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpEducationLevel().equals(Employee.EducationLevel.MASTERS)) {
                count++;
            }
        }

        return count;
    }

    // return total bachelors employees
    public static int getNumberOfBachelorsEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpEducationLevel().equals(Employee.EducationLevel.BACHELORS)) {
                count++;
            }
        }

        return count;
    }

    // return total high school employees
    public static int getNumberOfHighSchoolEmployees() {
        int count = 0;

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (employees.get(key).getEmpEducationLevel().equals(Employee.EducationLevel.HIGH_SCHOOL)) {
                count++;
            }
        }

        return count;
    }

    // return average tenure of employees
    public static double getAverageTenure() {
        double totalTenure = 0;
        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            totalTenure += employees.get(key).yearsInCompany();
        }

        return totalTenure / employees.size();
    }

    // compute the age distribution and return them in a linkedHashMap
    public static LinkedHashMap<String, Integer> getAgeDistributionMap() {
        int countUnder20 = 0;
        int count20to30 = 0;
        int count30to40 = 0;
        int count40to50 = 0;
        int countOver50 = 0;

        LinkedHashMap<String, Integer> ageDistributionMap = new LinkedHashMap<>();

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            int age = employees.get(key).calculateAge();
            if (age < 20) {
                countUnder20++;
            } else if (age >= 20 && age < 30) {
                count20to30++;
            } else if (age >= 30 && age < 40) {
                count30to40++;
            } else if (age >= 40 && age < 50) {
                count40to50++;
            } else {
                countOver50++;
            }
        }

        ageDistributionMap.put("Under 20", countUnder20);
        ageDistributionMap.put("20 to 30", count20to30);
        ageDistributionMap.put("30 to 40", count30to40);
        ageDistributionMap.put("40 to 50", count40to50);
        ageDistributionMap.put("Over 50", countOver50);

        return ageDistributionMap;
    }

    // create salary distribution map
    public static LinkedHashMap<String, Integer> getSalaryDistributionMap() {
        int countUnder1k = 0;
        int count1kto3k = 0;
        int count3kto4k = 0;
        int count4kto5k = 0;
        int countOver5k = 0;

        LinkedHashMap<String, Integer> salaryDistributionMap = new LinkedHashMap<>();

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            double salary = employees.get(key).getSalary();
            if (salary < 1000) {
                countUnder1k++;
            } else if (salary >= 1000 && salary < 3000) {
                count1kto3k++;
            } else if (salary >= 3000 && salary < 4000) {
                count3kto4k++;
            } else if (salary >= 4000 && salary < 5000) {
                count4kto5k++;
            } else {
                countOver5k++;
            }
        }

        salaryDistributionMap.put("UNDER 1K", countUnder1k);
        salaryDistributionMap.put("1K TO 3K", count1kto3k);
        salaryDistributionMap.put("3K TO 4K", count3kto4k);
        salaryDistributionMap.put("4K TO 5K", count4kto5k);
        salaryDistributionMap.put("Over 5K", countOver5k);

        return salaryDistributionMap;
    }

    // RETURN all employees in a DefaultTableModel and JTable
    public static JTable getEmployeesTable() {
        String[] columnNames = { "First Name", "Last Name", "Position", "Department", "Years in Company",
                "Date Started" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        Iterator<String> iterator = null;
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String firstName = employees.get(key).getFirstName();
            String lastName = employees.get(key).getLastName();
            String position = employees.get(key).getEmpPosition().toString();
            String department = employees.get(key).getEmpDepartment().toString();
            int yearsInCompany = employees.get(key).yearsInCompany();
            String dateStarted = employees.get(key).getDateStarted().toString();

            Object[] data = { firstName, lastName, position, department, yearsInCompany, dateStarted };
            model.addRow(data);
        }

        return table;
    }

    // Returns an arraylist of all employees as objects
    public static ArrayList<String> getEmployees() {
        ArrayList<String> info = new ArrayList<String>();
        String title = "First Name\tLast Name\tPosition\t\t\tDepartment\t\tYears in Company\tDate Started";
        info.add(title);
        Iterator<String> iterator = null;
        System.out.println(employees);
        Set<String> hashMapKeys = employees.keySet();

        iterator = hashMapKeys.iterator();
        while (iterator.hasNext()) {
            String str = "";
            String key = (String) iterator.next();
            str += "\n" + employees.get(key).getFirstName() + "\t";
            str += employees.get(key).getLastName() + "\t";
            str += employees.get(key).getEmpPosition() + "\t\t";
            str += employees.get(key).getEmpDepartment() + "\t\t";
            str += employees.get(key).yearsInCompany() + "\t\t";
            str += employees.get(key).getDateStarted() + "\t\t";
            info.add(str);
        }

        return info;
    }

}
