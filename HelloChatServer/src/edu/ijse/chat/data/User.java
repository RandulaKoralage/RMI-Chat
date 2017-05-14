/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.chat.data;

/**
 *
 * @author Randula
 */
public class User {
    private String signUpDate;
    private String userName;
    private String passWord;

    public User() {
    }

    public User(String signUpDate, String userName, String passWord) {
        this.signUpDate = signUpDate;
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * @return the signUpDate
     */
    public String getSignUpDate() {
        return signUpDate;
    }

    /**
     * @param signUpDate the signUpDate to set
     */
    public void setSignUpDate(String signUpDate) {
        this.signUpDate = signUpDate;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    
}
