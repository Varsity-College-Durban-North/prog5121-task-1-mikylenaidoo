/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task1;

/**
 *
 * @author ST100183186
 */
import javax.swing.JOptionPane;

public class Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // login class in linked in order to call the methods
        Login login = new Login();
        
        //user is prompted for input of the username, password, firstname and last name for register
        String usernameInput = JOptionPane.showInputDialog("Input username"),
                passwordInput = JOptionPane.showInputDialog("Input password"),
                firstnameInput = JOptionPane.showInputDialog("Input first name"),
                lastnameInput = JOptionPane.showInputDialog("Input last name");
        
        //register method is called
        login.registerUser(usernameInput, passwordInput, firstnameInput, lastnameInput);
        
        //prompted for the login details
        String usernameLoginInput = JOptionPane.showInputDialog("Enter your username"),
                passwordLoginInput = JOptionPane.showInputDialog("Enter your password");
        
        //login status is stored from the loginUser method
        boolean loginStatus = login.loginUser(usernameLoginInput, passwordLoginInput);
        String loginString = login.returnLoginStatus(loginStatus);
        
        JOptionPane.showMessageDialog(null, loginString);
        
    }
    
}
