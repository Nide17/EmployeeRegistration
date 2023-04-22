import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DisplayEmployeeStats extends JFrame implements ActionListener {

    JScrollPane scrollPane = new JScrollPane();
    JButton backButton;
    JTextArea textArea;
    JPanel panel;

    public DisplayEmployeeStats() {

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);

        JList<String> list = new JList<>();
        JScrollPane scrollPaneList = new JScrollPane();

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        textArea.setMaximumSize(new Dimension(770, 500));

        // DEPARTMENT STATS - IF THERE ARE EMPLOYEES IN THE DATABASE
        ArrayList<String> allDepartments = EmployeeDatabase.getDepartments();
        if (allDepartments.size() > 0) {

            textArea.append("ALL DEPARTMENTS:\n");

            // create a list and list the departments in JList
            list = new JList<>(allDepartments.toArray(new String[allDepartments.size()]));
            list.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            list.setBackground(Color.WHITE);
            list.setForeground(Color.BLUE);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            // add the list to the scroll pane
            scrollPaneList = new JScrollPane(list);
            scrollPaneList.setPreferredSize(new Dimension(300, 300));

            // make a JTable with all departments and number of employees in each department
            JLabel tableLabel = new JLabel("DEPARTMENTS AND NUMBER OF EMPLOYEES");
            String[] columnNames = { "Department", "Number of Employees" };
            Object[][] data = new Object[allDepartments.size()][2];
            for (int i = 0; i < allDepartments.size(); i++) {
                data[i][0] = allDepartments.get(i);
                data[i][1] = EmployeeDatabase.getNumberOfEmployeesInDepartment(allDepartments.get(i));
            }
            JTable table = new JTable(data, columnNames);

            JLabel tableLabelAll = new JLabel("OVERALL STATISTICS\n");
            String[] columnNamesAll = { "Title", "Number" };
            Object[][] dataAll = new Object[10][2];

            // MALE EMPLOYEES
            dataAll[0][0] = "MALE EMPLOYEES";
            dataAll[0][1] = EmployeeDatabase.getNumberOfMales();

            // FEMALES EMPLOYEES
            dataAll[1][0] = "FEMALE EMPLOYEES";
            dataAll[1][1] = EmployeeDatabase.getNumberOfFemales();

            // SINGLE EMPLOYEES
            dataAll[2][0] = "SINGLE EMPLOYEES";
            dataAll[2][1] = EmployeeDatabase.getNumberOfSingleEmployees();

            // MARRIED EMPLOYEES
            dataAll[3][0] = "MARRIED EMPLOYEES";
            dataAll[3][1] = EmployeeDatabase.getNumberOfMarriedEmployees();

            // DIVORCED EMPLOYEES
            dataAll[4][0] = "DIVORCED EMPLOYEES";
            dataAll[4][1] = EmployeeDatabase.getNumberOfDivorcedEmployees();

            // PHD EMPLOYEES
            dataAll[5][0] = "PHD EMPLOYEES";
            dataAll[5][1] = EmployeeDatabase.getNumberOfPhdEmployees();

            // MASTERS EMPLOYEES
            dataAll[6][0] = "MASTERS EMPLOYEES";
            dataAll[6][1] = EmployeeDatabase.getNumberOfMastersEmployees();

            // BACHELORS EMPLOYEES
            dataAll[7][0] = "BACHELORS EMPLOYEES";
            dataAll[7][1] = EmployeeDatabase.getNumberOfBachelorsEmployees();

            // HIGH SCHOOL EMPLOYEES
            dataAll[8][0] = "HIGH SCHOOL EMPLOYEES";
            dataAll[8][1] = EmployeeDatabase.getNumberOfHighSchoolEmployees();

            JTable tableAll = new JTable(dataAll, columnNamesAll);

            // create a table for age distribution using getAgeDistributionMap
            JLabel tableLabelAge = new JLabel("AGE DISTRIBUTION");
            String[] columnNamesAge = { "Age", "Number of Employees" };
            Object[][] dataAge = new Object[EmployeeDatabase.getAgeDistributionMap().size()][2];
            int i = 0;
            for (String age : EmployeeDatabase.getAgeDistributionMap().keySet()) {
                dataAge[i][0] = age;
                dataAge[i][1] = EmployeeDatabase.getAgeDistributionMap().get(age);
                i++;
            }
            JTable tableAge = new JTable(dataAge, columnNamesAge);

            // create a table for salary distribution using getSalaryDistributionMap
            JLabel tableLabelSalary = new JLabel("SALARY DISTRIBUTION");
            String[] columnNamesSalary = { "Salary", "Number of Employees" };
            Object[][] dataSalary = new Object[EmployeeDatabase.getSalaryDistributionMap().size()][2];

            i = 0;

            for (String salary : EmployeeDatabase.getSalaryDistributionMap().keySet()) {
                dataSalary[i][0] = salary;
                dataSalary[i][1] = EmployeeDatabase.getSalaryDistributionMap().get(salary);
                i++;
            }

            JTable tableSalary = new JTable(dataSalary, columnNamesSalary);

            // add both tables to the scroll pane
            JPanel tablePanel = new JPanel();
            tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
            tablePanel.add(tableLabel);
            tablePanel.add(table);

            // separate the tables with a spaces
            tablePanel.add(new JLabel("\n\n"));
            tablePanel.add(tableLabelAll);
            tablePanel.add(tableAll);

            tablePanel.add(new JLabel("\n\n"));
            tablePanel.add(tableLabelAge);
            tablePanel.add(tableAge);

            tablePanel.add(new JLabel("\n\n"));
            tablePanel.add(tableLabelSalary);
            tablePanel.add(tableSalary);
            scrollPane = new JScrollPane(tablePanel);

        } else {
            textArea.append("NO DEPARTMENTS FOUND");
        }

        // BUTTON TO GO BACK TO MAIN MENU
        backButton = new JButton("BACK");
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        backButton.setSize(100, 20);
        backButton.setBackground(Color.YELLOW);
        backButton.addActionListener(this);

        // add the text area to the panel
        panel.add(textArea);
        panel.add(scrollPaneList);
        panel.add(scrollPane);
        panel.add(backButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "EMPLOYEE STATS", 0, 0, new Font("Times New Roman", Font.PLAIN, 20), Color.BLUE));
        panel.setBackground(Color.WHITE);

        // add the panel to the frame
        add(panel);
        setMinimumSize(new Dimension(770, 720));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new EmployeeRegistration().setVisible(true);
        }
    }
}