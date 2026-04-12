import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;

public class EmployeeForm extends JFrame {

    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> departmentBox;
    JTree orgTree;

    public EmployeeForm() {

        setTitle("Employee Registration System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Full Name:"));
        nameField = new JTextField();
        add(nameField);


        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);


        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);


        add(new JLabel("Department:"));
        String[] departments = {"HR", "IT", "Finance", "Marketing"};
        departmentBox = new JComboBox<>(departments);
        add(departmentBox);

        add(new JLabel("Date of Birth:"));
        JTextField dobField = new JTextField("YYYY-MM-DD");
        add(dobField);

        add(new JLabel("Organization:"));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");
        DefaultMutableTreeNode dept1 = new DefaultMutableTreeNode("HR");
        DefaultMutableTreeNode dept2 = new DefaultMutableTreeNode("IT");
        root.add(dept1);
        root.add(dept2);

        orgTree = new JTree(root);
        add(new JScrollPane(orgTree));

        JButton submitBtn = new JButton("Submit");
        add(submitBtn);

        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String dept = departmentBox.getSelectedItem().toString();
                String dob = dobField.getText();

                if (!ValidationUtil.isValid(name, email, password, dob)) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields!");
                    return;
                }

                String hiddenPass = "******";

                Object selectedNode = orgTree.getLastSelectedPathComponent();
                String org = (selectedNode != null) ? selectedNode.toString() : "None";

                String message = "Name: " + name +
                        "\nEmail: " + email +
                        "\nPassword: " + hiddenPass +
                        "\nDepartment: " + dept +
                        "\nDOB: " + dob +
                        "\nOrganization: " + org;

                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
