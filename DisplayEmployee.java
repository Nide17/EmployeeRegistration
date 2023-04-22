
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DisplayEmployee extends JFrame implements ActionListener {
    private JButton back = new JButton("Back");
    private JPanel panel = new JPanel();
    JScrollPane scrollPane = new JScrollPane();

    public DisplayEmployee() {
        
        panel = new JPanel();
        panel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "EMPLOYEE INFO", 0, 0, new Font("Times New Roman", Font.PLAIN, 20), Color.BLUE));
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // add a back button
        back.setSize(100, 30);
        back.setLocation(100, 410);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLUE);
        back.addActionListener(this);

        JScrollPane scrollPaneT = new JScrollPane(EmployeeDatabase.getEmployeesTable());

        panel.add(scrollPaneT);
        panel.add(back);

        // add the panel to the frame
        add(panel);
        setMinimumSize(new Dimension(770, 720));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            dispose();
            new WelcomePage().setVisible(true);
        }
    }
}
