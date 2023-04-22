import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class EmployeeRegistration extends JFrame implements ActionListener {
        private JLabel fNameLabel;
        private JTextField fNameText;
        private JLabel lNameLabel;
        private JTextField lNameText;
        private JLabel addressLabel;
        private JTextField addressText;
        private JLabel contactLabel;
        private JTextField contactText;
        private JLabel salaryLabel;
        private JTextField salaryText;
        private JLabel departmentLabel;
        private JComboBox<String> departmentText;
        private JLabel positionLabel;
        private JComboBox<String> positionText;
        private JLabel profLevelLabel;
        private JComboBox<Employee.Level> profLevelText;

        private JLabel eduLevelLabel;
        private JComboBox<Employee.EducationLevel> eduLevelText;

        private JLabel employeeTypeLabel;
        private JComboBox<Employee.EmployeeType> employeeTypeText;

        private JLabel dateOfBirthLabel;
        private JComboBox<String> dateOB;
        private JComboBox<String> monthOB;
        private JComboBox<String> yearOB;

        private JLabel dateStartedLabel;
        private JComboBox<String> dateSD;
        private JComboBox<String> monthSD;
        private JComboBox<String> yearSD;

        private JLabel genderLabel;
        private JRadioButton male;
        private JRadioButton female;
        private JLabel maritalLabel;
        private JRadioButton single;
        private JRadioButton married;
        private ButtonGroup genderGroup;
        private ButtonGroup maritalGroup;
        private JButton submit;
        private JButton reset;
        private JButton showStats;
        private JButton backHomeButton;

        String dates[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15",
                        "16",
                        "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        String months[] = { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
        String years[] = { "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970",
                        "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982",
                        "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994",
                        "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
                        "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
                        "2019", "2020", "2021", "2022" };

        String departments[] = Employee.departments.values().toArray(new String[0]);
        String positions[] = Employee.positions.values().toArray(new String[0]);
        Employee.Level profLevels[] = Employee.Level.values();
        Employee.EmployeeType empTypes[] = Employee.EmployeeType.values();
        Employee.EducationLevel eduLevels[] = Employee.EducationLevel.values();
        String selectedDepartment, selectedPosition;

        // create the reset function
        public void resetForm() {
                fNameText.setText("");
                lNameText.setText("");
                contactText.setText("");
                addressText.setText("");
                salaryText.setText("");
                eduLevelText.setSelectedIndex(-1);
                genderGroup.clearSelection();
                maritalGroup.clearSelection();
                positionText.setSelectedIndex(0);
                eduLevelText.setSelectedIndex(0);
                profLevelText.setSelectedIndex(0);
                yearOB.setSelectedIndex(0);
                monthOB.setSelectedIndex(0);
                dateOB.setSelectedIndex(0);
                yearSD.setSelectedIndex(0);
                monthSD.setSelectedIndex(0);
                dateSD.setSelectedIndex(0);
                departmentText.setSelectedIndex(0);
                departmentText.setSelectedIndex(-1);
                positionText.setSelectedIndex(-1);
                eduLevelText.setSelectedIndex(-1);
                profLevelText.setSelectedIndex(-1);
                employeeTypeText.setSelectedIndex(-1);
                dateOB.setSelectedIndex(-1);
                monthOB.setSelectedIndex(-1);
                yearOB.setSelectedIndex(-1);
                dateSD.setSelectedIndex(-1);
                monthSD.setSelectedIndex(-1);
                yearSD.setSelectedIndex(-1);
        }

        public EmployeeRegistration() {
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                                "REGISTER EMPLOYEE", 0, 0, new Font("Times New Roman", Font.PLAIN, 20), Color.BLUE));
                panel.setBackground(Color.WHITE);

                fNameLabel = new JLabel("First Name");
                fNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                fNameLabel.setSize(100, 20);
                fNameLabel.setLocation(30, 100);
                panel.add(fNameLabel);

                fNameText = new JTextField();
                fNameText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                fNameText.setSize(200, 20);
                fNameText.setLocation(140, 100);
                panel.add(fNameText);

                lNameLabel = new JLabel("Last Name");
                lNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                lNameLabel.setSize(100, 20);
                lNameLabel.setLocation(400, 100);
                panel.add(lNameLabel);

                lNameText = new JTextField();
                lNameText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                lNameText.setSize(200, 20);
                lNameText.setLocation(510, 100);
                panel.add(lNameText);

                addressLabel = new JLabel("Address");
                addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                addressLabel.setSize(100, 20);
                addressLabel.setLocation(30, 140);
                panel.add(addressLabel);

                addressText = new JTextField();
                addressText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                addressText.setSize(200, 20);
                addressText.setLocation(140, 140);
                panel.add(addressText);

                contactLabel = new JLabel("Contact");
                contactLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                contactLabel.setSize(100, 20);
                contactLabel.setLocation(400, 140);
                panel.add(contactLabel);

                contactText = new JTextField();
                contactText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                contactText.setSize(200, 20);
                contactText.setLocation(510, 140);
                panel.add(contactText);

                // SALARY
                salaryLabel = new JLabel("Salary");
                salaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                salaryLabel.setSize(100, 20);
                salaryLabel.setLocation(30, 180);
                panel.add(salaryLabel);

                salaryText = new JTextField();
                salaryText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                salaryText.setSize(200, 20);
                salaryText.setLocation(140, 180);
                panel.add(salaryText);

                employeeTypeLabel = new JLabel("Employee Type");
                employeeTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                employeeTypeLabel.setSize(100, 20);
                employeeTypeLabel.setLocation(400, 180);
                panel.add(employeeTypeLabel);

                employeeTypeText = new JComboBox<Employee.EmployeeType>(empTypes);
                employeeTypeText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // employeeTypeText.setSelectedIndex(-1);
                employeeTypeText.setSize(170, 20);
                employeeTypeText.setLocation(510, 180);
                panel.add(employeeTypeText);

                // DEPARTMENT
                departmentLabel = new JLabel("Department");
                departmentLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                departmentLabel.setSize(100, 20);
                departmentLabel.setLocation(30, 220);
                panel.add(departmentLabel);

                departmentText = new JComboBox<String>(departments);
                departmentText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // departmentText.setSelectedIndex(-1);
                departmentText.setSize(170, 20);
                departmentText.setLocation(140, 220);
                panel.add(departmentText);

                // LEVEL
                profLevelLabel = new JLabel("Professional Level");
                profLevelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                profLevelLabel.setSize(100, 20);
                profLevelLabel.setLocation(400, 220);
                panel.add(profLevelLabel);

                profLevelText = new JComboBox<Employee.Level>(profLevels);
                profLevelText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // profLevelText.setSelectedIndex(-1);
                profLevelText.setSize(170, 20);
                profLevelText.setLocation(510, 220);
                panel.add(profLevelText);

                // DATE OF BIRTH
                dateOfBirthLabel = new JLabel("Date of Birth");
                dateOfBirthLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                dateOfBirthLabel.setSize(100, 20);
                dateOfBirthLabel.setLocation(30, 260);
                panel.add(dateOfBirthLabel);

                dateOB = new JComboBox<String>(dates);
                dateOB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // dateOB.setSelectedIndex(-1);
                dateOB.setSize(45, 20);
                dateOB.setLocation(140, 260);
                panel.add(dateOB);

                monthOB = new JComboBox<String>(months);
                monthOB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // monthOB.setSelectedIndex(-1);
                monthOB.setSize(45, 20);
                monthOB.setLocation(195, 260);
                panel.add(monthOB);

                yearOB = new JComboBox<String>(years);
                yearOB.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // yearOB.setSelectedIndex(-1);
                yearOB.setSize(60, 20);
                yearOB.setLocation(250, 260);
                panel.add(yearOB);

                // DATE STARTED
                dateStartedLabel = new JLabel("Date started");
                dateStartedLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                dateStartedLabel.setSize(100, 20);
                dateStartedLabel.setLocation(400, 260);
                panel.add(dateStartedLabel);

                dateSD = new JComboBox<String>(dates);
                dateSD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // dateSD.setSelectedIndex(-1);
                dateSD.setSize(45, 20);
                dateSD.setLocation(510, 260);
                panel.add(dateSD);

                monthSD = new JComboBox<String>(months);
                monthSD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // monthSD.setSelectedIndex(-1);
                monthSD.setSize(45, 20);
                monthSD.setLocation(565, 260);
                panel.add(monthSD);

                yearSD = new JComboBox<String>(years);
                yearSD.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // yearSD.setSelectedIndex(-1);
                yearSD.setSize(60, 20);
                yearSD.setLocation(620, 260);
                panel.add(yearSD);

                // GENDER
                genderLabel = new JLabel("Gender");
                genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                genderLabel.setSize(100, 20);
                genderLabel.setLocation(30, 300);
                panel.add(genderLabel);

                male = new JRadioButton("Male");
                male.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // male.setSelected(false);
                male.setSize(75, 20);
                male.setLocation(140, 300);
                panel.add(male);

                female = new JRadioButton("Female");
                female.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // female.setSelected(false);
                female.setSize(80, 20);
                female.setLocation(230, 300);
                panel.add(female);

                genderGroup = new ButtonGroup();
                genderGroup.add(male);
                genderGroup.add(female);

                // MARITAL STATUS
                maritalLabel = new JLabel("Marital Status");
                maritalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                maritalLabel.setSize(100, 20);
                maritalLabel.setLocation(400, 300);
                panel.add(maritalLabel);

                single = new JRadioButton("Single");
                single.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // single.setSelected(false);
                single.setSize(75, 20);
                single.setLocation(510, 300);
                panel.add(single);

                married = new JRadioButton("Married");
                married.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                // married.setSelected(false);
                married.setSize(80, 20);
                married.setLocation(600, 300);
                panel.add(married);

                maritalGroup = new ButtonGroup();
                maritalGroup.add(single);
                maritalGroup.add(married);

                // POSITION
                positionLabel = new JLabel("Position");
                positionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                positionLabel.setSize(100, 20);
                positionLabel.setLocation(30, 340);
                panel.add(positionLabel);

                // assign positionText to new JComboBox with the Employee.positions
                // linkedHashMap as the parameter
                positionText = new JComboBox<String>(positions);
                // positionText.setSelectedIndex(-1);
                positionText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                positionText.setSize(170, 20);
                positionText.setLocation(140, 340);
                panel.add(positionText);

                // EDUCATION LEVEL
                eduLevelLabel = new JLabel("Education");
                eduLevelLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
                eduLevelLabel.setSize(100, 20);
                eduLevelLabel.setLocation(400, 340);
                panel.add(eduLevelLabel);

                eduLevelText = new JComboBox<Employee.EducationLevel>(eduLevels);
                eduLevelText.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                eduLevelText.setSize(170, 20);
                // eduLevelText.setSelectedIndex(-1);
                eduLevelText.setLocation(510, 340);
                panel.add(eduLevelText);

                // SUBMIT & RESET BUTTONS
                submit = new JButton("Submit");
                submit.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                submit.setSize(100, 20);
                submit.setLocation(140, 450);
                submit.setBackground(Color.GREEN);
                submit.addActionListener(this);
                panel.add(submit);

                reset = new JButton("Reset");
                reset.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                reset.setSize(100, 20);
                reset.setLocation(510, 450);
                reset.setBackground(Color.YELLOW);
                reset.addActionListener(this);
                panel.add(reset);

                // add a button to the panel
                backHomeButton = new JButton("Back Home");
                backHomeButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                backHomeButton.setSize(100, 20);
                backHomeButton.setLocation(140, 500);
                backHomeButton.setBackground(Color.BLUE);
                backHomeButton.setForeground(Color.WHITE);
                backHomeButton.addActionListener(this);
                panel.add(backHomeButton);

                // add a button to the panel
                showStats = new JButton("Show Stats");
                showStats.setFont(new Font("Times New Roman", Font.PLAIN, 12));
                showStats.setSize(100, 20);
                showStats.setLocation(510, 500);
                showStats.setBackground(Color.MAGENTA);
                showStats.setForeground(Color.WHITE);
                showStats.addActionListener(this);
                panel.add(showStats);

                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setBounds(300, 90, 770, 600);
                setResizable(false);
                setSize(770, 600);
                add(panel);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

                if (e.getSource() == submit) {
                        // get department key from departmentText
                        for (String key : Employee.departments.keySet())
                                if (Employee.departments.get(key).equals(departmentText.getSelectedItem()))
                                        selectedDepartment = key;

                        for (String key : Employee.positions.keySet())
                                if (Employee.positions.get(key).equals(positionText.getSelectedItem()))
                                        selectedPosition = key;

                        // CREATE A NEW EMPLOYEE WITH THE DATA ENTERED
                        // check if all fields are filled
                        if (fNameText.getText().equals("") || lNameText.getText().equals("")
                                        || contactText.getText().equals("")
                                        || addressText.getText().equals("")
                                        || employeeTypeText.getSelectedItem().equals("")
                                        || profLevelText.getSelectedItem().equals("")
                                        || yearSD.getSelectedItem().equals("") || monthSD.getSelectedItem().equals("")
                                        || dateSD.getSelectedItem().equals("") || yearOB.getSelectedItem().equals("")
                                        || monthOB.getSelectedItem().equals("") || dateOB.getSelectedItem().equals("")
                                        || departmentText.getSelectedItem().equals("")
                                        || positionText.getSelectedItem().equals("")
                                        || eduLevelText.getSelectedItem().equals("")) {
                                JOptionPane.showMessageDialog(this, "Please fill all the fields");

                        } else {
                                // create a new employee
                                Employee newEmployee = new Employee(
                                                Integer.toString(WelcomePage.dbs.getLargestEmployeeId() + 1),
                                                Employee.EmployeeType
                                                                .valueOf(employeeTypeText.getSelectedItem().toString()),
                                                fNameText.getText(),
                                                lNameText.getText(),
                                                male.isSelected() ? Employee.Gender.MALE : Employee.Gender.FEMALE,
                                                contactText.getText(),
                                                addressText.getText(),
                                                Employee.Level.valueOf(profLevelText.getSelectedItem().toString()),
                                                LocalDate.of(Integer.parseInt(yearSD.getSelectedItem().toString()),
                                                                Integer.parseInt(monthSD.getSelectedItem().toString()),
                                                                Integer.parseInt(dateSD.getSelectedItem().toString())),
                                                LocalDate.of(Integer.parseInt(yearOB.getSelectedItem().toString()),
                                                                Integer.parseInt(monthOB.getSelectedItem().toString()),
                                                                Integer.parseInt(dateOB.getSelectedItem().toString())),
                                                Employee.EducationLevel
                                                                .valueOf(eduLevelText.getSelectedItem().toString()),
                                                salaryText.getText().trim().isEmpty() ? 0.0
                                                                : Double.parseDouble(salaryText.getText()),
                                                single.isSelected() ? Employee.MaritalStatus.SINGLE
                                                                : Employee.MaritalStatus.MARRIED,
                                                Employee.departments.get(selectedDepartment),
                                                Employee.positions.get(selectedPosition));

                                // CREATING A NEW EMPLOYEE IN THE DATABASE
                                WelcomePage.dbs.createEmployee(Integer.toString(
                                                WelcomePage.dbs.getLargestEmployeeId() + 1), newEmployee);
                                System.out.println(WelcomePage.dbs.getEmployeeNames());
                                JOptionPane.showMessageDialog(this, "Employee succesfully registered");

                                // clear the form after submission
                                resetForm();
                        }

                } else if (e.getSource() == reset) {
                        resetForm();
                }

                else if (e.getSource() == showStats) {
                        dispose();
                        new DisplayEmployeeStats().setVisible(true);
                }

                else if (e.getSource() == backHomeButton) {
                        dispose();
                        new WelcomePage().setVisible(true);
                }
        }
}
