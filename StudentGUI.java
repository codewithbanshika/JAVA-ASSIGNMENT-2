import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame implements ActionListener {

    JTextField idField, nameField, ageField, courseField;
    JTextArea displayArea;

    JButton addButton, updateButton, deleteButton, clearButton;

    ArrayList<Student> students = new ArrayList<>();

    StudentGUI() {

        setTitle("Student Management System");
        setSize(500, 500);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels and TextFields
        add(new JLabel("ID"));
        idField = new JTextField(20);
        add(idField);

        add(new JLabel("Name"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Age"));
        ageField = new JTextField(20);
        add(ageField);

        add(new JLabel("Course"));
        courseField = new JTextField(20);
        add(courseField);

        // Buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(clearButton);

        // Action Listeners
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Display Area
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);

        add(new JScrollPane(displayArea));

        setVisible(true);
    }

    // Refresh Display
    void refreshDisplay() {

        displayArea.setText("");

        for (Student s : students) {
            displayArea.append(s.toString() + "\n");
        }
    }

    // Button Actions
    public void actionPerformed(ActionEvent e) {

        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String course = courseField.getText();

        if (e.getSource() == addButton) {

            students.add(new Student(id, name, age, course));

        } else if (e.getSource() == updateButton) {

            for (Student s : students) {

                if (s.id == id) {
                    s.name = name;
                    s.age = age;
                    s.course = course;
                }
            }

        } else if (e.getSource() == deleteButton) {

            students.removeIf(s -> s.id == id);

        } else if (e.getSource() == clearButton) {

            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            courseField.setText("");
        }

        refreshDisplay();
    }

    public static void main(String[] args) {

        new StudentGUI();
    }
}