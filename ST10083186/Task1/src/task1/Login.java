/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task1;

/**
 *
 * @author ST100183186
 */
public class Login {
    public boolean checkUserName(String username) {
        boolean usernamePass = false;
        //checks if the username has an underscore and has less than 6 characters
        if (username.contains("_") || (username.length() < 6)) {
            usernamePass = true;
        }
        return usernamePass;
    }
    
    public String returnLoginStatus(boolean status) {
        //using a class to retrieve details
        UserStorage storage = new UserStorage();
        
        //if true then displays welcome message
        if (status) {
            return "Welcome " + storage.getFirstName()+ ", " + storage.getLastName() + 
                    "it is great to see you.";            
        } else return "Username or password incorrect, please try again";
    }
    
    public boolean checkPasswordComplexity(String password) {
        //variables that are used as checks for length, numerical, special characters and alpha
        boolean lengthPass = false, numPass = false, alphaPass = false, specialPass = false, overallPass = false;   
        char letter;
        
        //true if password length is greater than 8
        if (password.length() >= 8) {
            lengthPass = true;
        }
        
        //for loop to check each letter for an uppercase, digit or special character
        for (int i = 0; i < password.length(); i++) {
             letter = password.charAt(i);
            
            if (Character.isUpperCase(letter)) {
                alphaPass = true;
            }
            
            if (Character.isDigit(letter)) {
                numPass = true;
            }
            
            if ((!Character.isDigit(letter)) || (!Character.isLetter(letter)) || (!Character.isWhitespace(letter))) {
                specialPass = true;
            }   
        }    
        
        //if all checks are true then the method can be passed successfully
        if ((specialPass == true) || (numPass == true) || (alphaPass == true) || (lengthPass == true)) {
                overallPass = true; 
        }
        return overallPass;
    }
    
    public boolean loginUser(String username, String password) {
        //using a class to test for the login section
        UserStorage storage = new UserStorage();
        
        boolean usernameCheck = false, passwordCheck = false;
        
        //if username in storage class is equal to the inputed username then it is passed
        if (storage.getUsername().matches(username)) {
            usernameCheck = true;
        }
        
        //if password in storage class is equal to the inputed password then it is passed
        if (storage.getPassword().matches(password)) {
            passwordCheck = true;
        }
        
        //if both checks are true then the method can be passed
        if ((usernameCheck == true) || (passwordCheck == true)) {
            return  true;
        } else {
            return false;
        }
    }
    
    public String registerUser(String username, String password, String firstName, String lastName) {
        //using a class to store the new user details
        UserStorage storage = new UserStorage();
        
        String displayMessage = "";
        
        //if the username and password passed the checks then it is saved
        if (checkPasswordComplexity(password) || checkUserName(username)) {
            storage.setFirstName(firstName);
            storage.setLastName(lastName);
            storage.setPassword(password);
            storage.setUsername(username);
            displayMessage = "User has been registered successfully"; 
            //if the password failed the check then an error is displayed
        } else if (checkPasswordComplexity(password) == false) {
            displayMessage = "Password is not correctly formatted, "
                    + "please ensure that the password contains at "
                    + "least 8 characters, a capital letter, a number and a special character.";       
            //if the username failed the check then an error is displayed
        } else if (checkUserName(username) == false) {
            displayMessage = "Username is not correctly formatted, "
                    + "please ensure that your username contains an "
                    + "underscore and is no more than 5 characters in length.";
        }
        return displayMessage;
    }
    
}
