import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class WelcomePage extends JFrame implements ActionListener {
        private JLabel welcome;
        private JLabel register;
        private JButton registerButton;
        private JLabel stats;
        private JButton viewStats;
        static EmployeeDatabase dbs = new EmployeeDatabase();

        public WelcomePage() {

                // ADMINISTRATIVE
                dbs.createEmployee("1",
                                new Employee("1", Employee.EmployeeType.PERMANENT, "John", "Smith",
                                                Employee.Gender.MALE, "0799522433",
                                                "123 Main St",
                                                Employee.Level.CSUITE,
                                                LocalDate.of(2012, 1, 1), LocalDate.of(1959, 1, 1),
                                                Employee.EducationLevel.PHD, 10000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("6"),
                                                Employee.positions.get("0")));

                dbs.createEmployee("2",
                                new Employee("2", Employee.EmployeeType.PERMANENT,
                                                "Jane", "Doe", Employee.Gender.FEMALE, "0786662454", "123 Main St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2014, 1, 1), LocalDate.of(1978, 1, 1),
                                                Employee.EducationLevel.BACHELORS, 1000.00,
                                                Employee.MaritalStatus.DIVORCED, Employee.departments.get("6"),
                                                Employee.positions.get("16")));

                // DIRECTORS
                dbs.createEmployee("3",
                                new Employee("3", Employee.EmployeeType.PERMANENT,
                                                "Tim", "Howard", Employee.Gender.MALE, "0785552588", "04 St",
                                                Employee.Level.DIRECTOR,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1965, 1, 1),
                                                Employee.EducationLevel.MASTERS, 6000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("2"),
                                                Employee.positions.get("1")));

                dbs.createEmployee("4",
                                new Employee("4", Employee.EmployeeType.PERMANENT,
                                                "Joe", "Emmanuel", Employee.Gender.MALE, "07855452588", "03 St",
                                                Employee.Level.DIRECTOR,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1968, 1, 1),
                                                Employee.EducationLevel.MASTERS,
                                                6000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("2"),
                                                Employee.positions.get("2")));

                dbs.createEmployee("5",
                                new Employee("5", Employee.EmployeeType.PERMANENT,
                                                "Mary", "Kellen", Employee.Gender.FEMALE, "0785552588", "07 St",
                                                Employee.Level.DIRECTOR,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1964, 1, 1),
                                                Employee.EducationLevel.PHD,
                                                6000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("3"),
                                                Employee.positions.get("3")));

                dbs.createEmployee("6",
                                new Employee("6", Employee.EmployeeType.PERMANENT,
                                                "Moses", "Huddlestone", Employee.Gender.MALE, "0785552588", "04 St",
                                                Employee.Level.DIRECTOR,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1970, 1, 1),
                                                Employee.EducationLevel.BACHELORS,
                                                6000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("4"),
                                                Employee.positions.get("4")));

                dbs.createEmployee("7",
                                new Employee("7", Employee.EmployeeType.PERMANENT,
                                                "Janet", "Barry", Employee.Gender.FEMALE, "0784552588", "45 St",
                                                Employee.Level.DIRECTOR,
                                                LocalDate.of(2018, 1, 1), LocalDate.of(1995, 1, 1),
                                                Employee.EducationLevel.MASTERS,
                                                6000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("5"),
                                                Employee.positions.get("5")));

                // MANAGERS
                dbs.createEmployee("8",
                                new Employee("8", Employee.EmployeeType.PERMANENT,
                                                "Anthony", "James", Employee.Gender.MALE, "0785552588", "78 St",
                                                Employee.Level.MANAGER,
                                                LocalDate.of(2018, 1, 1), LocalDate.of(1963, 1, 1),
                                                Employee.EducationLevel.BACHELORS,
                                                4000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("1"),
                                                Employee.positions.get("6")));

                dbs.createEmployee("9",
                                new Employee("9", Employee.EmployeeType.PERMANENT,
                                                "Julia", "Jones", Employee.Gender.FEMALE, "0786352588", "36 St",
                                                Employee.Level.MANAGER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1975, 1, 1),
                                                Employee.EducationLevel.BACHELORS,
                                                4000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("2"),
                                                Employee.positions.get("7")));

                dbs.createEmployee("10",
                                new Employee("10", Employee.EmployeeType.PERMANENT,
                                                "Thomas", "Raphael", Employee.Gender.MALE, "0785552588", "04 St",
                                                Employee.Level.MANAGER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1979, 1, 1),
                                                Employee.EducationLevel.MASTERS,
                                                4000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("3"),
                                                Employee.positions.get("8")));

                dbs.createEmployee("11",
                                new Employee("11", Employee.EmployeeType.PERMANENT,
                                                "Emmanuel", "George", Employee.Gender.MALE, "078362588", "36 St",
                                                Employee.Level.MANAGER,
                                                LocalDate.of(2016, 1, 1), LocalDate.of(1980, 1, 1),
                                                Employee.EducationLevel.MASTERS,
                                                4000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("4"),
                                                Employee.positions.get("9")));

                dbs.createEmployee("12",
                                new Employee("12", Employee.EmployeeType.PERMANENT,
                                                "Alice", "Jones", Employee.Gender.FEMALE, "0785552028", "45 St",
                                                Employee.Level.MANAGER,
                                                LocalDate.of(2017, 1, 1), LocalDate.of(1982, 1, 1),
                                                Employee.EducationLevel.PHD,
                                                4000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("5"),
                                                Employee.positions.get("10")));

                // OFFICERS
                dbs.createEmployee("13",
                                new Employee("13", Employee.EmployeeType.PERMANENT,
                                                "Carine", "Annan", Employee.Gender.FEMALE, "0785552588", "32 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2020, 1, 1), LocalDate.of(1989, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                1000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("1"),
                                                Employee.positions.get("11")));

                dbs.createEmployee("14",
                                new Employee("14", Employee.EmployeeType.PERMANENT,
                                                "Kim", "Joe", Employee.Gender.FEMALE, "0787752588", "04 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2017, 1, 1), LocalDate.of(1980, 1, 1),
                                                Employee.EducationLevel.MASTERS, 1000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("2"),
                                                Employee.positions.get("12")));

                dbs.createEmployee("15",
                                new Employee("15", Employee.EmployeeType.PERMANENT,
                                                "Marina", "Cole", Employee.Gender.FEMALE, "078566588", "04 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1993, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                1000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("3"),
                                                Employee.positions.get("14")));

                dbs.createEmployee("16",
                                new Employee("16", Employee.EmployeeType.PERMANENT,
                                                "Joyce", "Kimanyi", Employee.Gender.FEMALE, "078566588", "04 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(2000, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                1000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("4"),
                                                Employee.positions.get("14")));

                dbs.createEmployee("17",
                                new Employee("17", Employee.EmployeeType.PERMANENT,
                                                "Cathy", "Jones", Employee.Gender.FEMALE, "078566588", "04 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1998, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                1000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("5"),
                                                Employee.positions.get("15")));

                // INTERNS
                dbs.createEmployee("18",
                                new Employee("18", Employee.EmployeeType.INTERN,
                                                "Bayley", "Iglesias", Employee.Gender.FEMALE, "0785099588", "78 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2020, 1, 1), LocalDate.of(1997, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                300.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("1"),
                                                Employee.positions.get("11")));

                dbs.createEmployee("19",
                                new Employee("19", Employee.EmployeeType.INTERN,
                                                "Christian", "Kingsley", Employee.Gender.MALE, "0785553365", "74 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2022, 1, 1), LocalDate.of(1999, 1, 1),
                                                Employee.EducationLevel.HIGH_SCHOOL,
                                                300.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("2"),
                                                Employee.positions.get("12")));

                // CONTRACTUAL
                dbs.createEmployee("20",
                                new Employee("20", Employee.EmployeeType.CONTRACT,
                                                "Allan", "Smith", Employee.Gender.MALE, "078005566", "85 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2021, 1, 1), LocalDate.of(1997, 1, 1),
                                                Employee.EducationLevel.BACHELORS,
                                                70000.00,
                                                Employee.MaritalStatus.MARRIED, Employee.departments.get("3"),
                                                Employee.positions.get("14")));

                dbs.createEmployee("21",
                                new Employee("21", Employee.EmployeeType.CONTRACT,
                                                "Jane", "Cohen", Employee.Gender.FEMALE, "078566588", "04 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2018, 1, 1), LocalDate.of(1980, 1, 1),
                                                Employee.EducationLevel.BACHELORS,
                                                70000.00,
                                                Employee.MaritalStatus.SINGLE, Employee.departments.get("4"),
                                                Employee.positions.get("14")));

                dbs.createEmployee("22",
                                new Employee("22", Employee.EmployeeType.CONTRACT,
                                                "Mason", "Terry", Employee.Gender.MALE, "078566588", "84 St",
                                                Employee.Level.OFFICER,
                                                LocalDate.of(2015, 1, 1), LocalDate.of(1968, 1, 1),
                                                Employee.EducationLevel.MASTERS,
                                                270000.00,
                                                Employee.MaritalStatus.DIVORCED, Employee.departments.get("5"),
                                                Employee.positions.get("15")));

                JPanel page = new JPanel();
                page.setLayout(null);
                page.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                page.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                                "Home Page", 0, 0, new Font("Times New Roman", Font.PLAIN, 20), Color.BLUE));
                page.setBackground(Color.WHITE);

                welcome = new JLabel("Welcome");
                welcome.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                welcome.setSize(450, 20);
                welcome.setLocation(150, 100);
                page.add(welcome);

                register = new JLabel("Want to register a new Employee?");
                register.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                register.setSize(450, 20);
                register.setLocation(80, 150);
                page.add(register);

                registerButton = new JButton("Register");
                registerButton.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
                registerButton.setSize(100, 30);
                registerButton.setLocation(150, 200);
                registerButton.setBackground(Color.BLUE);
                registerButton.setForeground(Color.WHITE);
                registerButton.addActionListener(this);
                page.add(registerButton);

                stats = new JLabel("or view current employees");
                stats.setFont(new Font("Times New Roman", Font.PLAIN, 17));
                stats.setSize(450, 20);
                stats.setLocation(80, 250);
                page.add(stats);

                viewStats = new JButton("View");
                viewStats.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 15));
                viewStats.setSize(100, 30);
                viewStats.setLocation(150, 300);
                viewStats.setBackground(Color.BLUE);
                viewStats.setForeground(Color.WHITE);
                viewStats.addActionListener(this);
                page.add(viewStats);

                setResizable(false);
                setSize(500, 500);
                add(page);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registerButton) {
                        dispose();
                        new EmployeeRegistration().setVisible(true);

                } else if (e.getSource() == viewStats) {
                        dispose();
                        new DisplayEmployee().setVisible(true);
                }
        }
}
