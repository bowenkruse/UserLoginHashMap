package Lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class LoginPage extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userNameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JTextField userNameTextField = new JTextField();
    JTextField PasswordTextField = new JPasswordField();
    JButton loginButton = new JButton("Login");

    static Map<String,String> validLogin = new HashMap<String, String>();

    public void fillValidLogin() {
        validLogin.put("user1","password1");
        validLogin.put("user2","password2");
        validLogin.put("user3","password3");
        validLogin.put("user4","password4");
        validLogin.put("user5","password5");
    }

    LoginPage() {
        setLayout();
        addComponents();
        addEvents();
        setSizeAndLocal();
        fillValidLogin();
    }

    public void addEvents() {
        loginButton.addActionListener(this);

    }

    public void addComponents() {
        container.add(userNameLabel);
        container.add(passwordLabel);
        container.add(userNameTextField);
        container.add(PasswordTextField);
        container.add(loginButton);
    }

    public void setLayout() {
        container.setLayout(null);
    }

    public void setSizeAndLocal() {
        userNameLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userNameTextField.setBounds(150,150,150,30);
        PasswordTextField.setBounds(150,220,150,30);
        loginButton.setBounds(50,300,100,30);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == loginButton) {
            String userNameInput;
            String PasswordInput;
            userNameInput = userNameTextField.getText();
            PasswordInput = PasswordTextField.getText();

            //todo test username and password against valid user names array
            boolean valid = false;
            for (Map.Entry LoginEntry: validLogin.entrySet()) {
                String ValidUserName = (String) LoginEntry.getKey();
                String ValidPassword = (String) LoginEntry.getValue();
                if (userNameInput.equals(ValidUserName) && PasswordInput.equals(ValidPassword)) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                JOptionPane.showMessageDialog(this,"Login success");
            }
            else {
                JOptionPane.showMessageDialog(this,"Login Failed");
            }

        }
    }

    public static void main(String[] args) {
        LoginPage frame = new LoginPage();
        frame.setTitle("Lab 8 User Login");
        frame.setVisible(true);
        frame.setBounds(10,10,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
