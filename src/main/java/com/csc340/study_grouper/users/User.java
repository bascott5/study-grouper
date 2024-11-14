package com.csc340.study_grouper.users;

import jakarta.persistence.*;

import java.sql.Blob;

/**
 * Class to store user information from the users table in the database
 * @author Adam Cichoski
 */
@Entity
@Table(name="users")
public class User {

    public static final String INSTRUCTOR = "instructor";
    public static final String STUDENT = "student";
    public static final String ADMIN = "admin";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="uID")
    private int uID;

    @Column(nullable = false)
    private String email;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(name="first_name", nullable=false)
    private String first_name;

    @Column(name="last_name", nullable=false)
    private String last_name;

    @Column(nullable=false)
    private String accountType;

    @Column
    private String title;

    @Column
    private Blob profile_picture;


    /**
     * Constructor with all columns
     * @param uID
     * @param email
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param accountType
     * @param title
     * @param profile_picture
     */
    public User(int uID, String email, String username, String password, String first_name, String last_name, String accountType, String title, Blob profile_picture){
        this.uID = uID;
        this.email = email;
        this.username=username;
        this.password=password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.accountType = accountType;
        this.title = title;
        this.profile_picture = profile_picture;
    }

    /**
     * Constructor with all columns except uId
     * @param email
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param accountType
     * @param title
     * @param profile_picture
     */
    public User(String email, String username, String password, String first_name, String last_name, String accountType, String title, Blob profile_picture){
        this.email=email;
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        this.accountType =accountType;
        this.title=title;
        this.profile_picture=profile_picture;
    }

    /**
     * Constructor with only required fields
     * @param email
     * @param username
     * @param password
     * @param first_name
     * @param last_name
     * @param accountType
     */
    public User(String email, String username, String password, String first_name, String last_name, String accountType){
        this(email,username,password,first_name,last_name,accountType,null,null);
    }

    /**
     * Default empty constructor
     */
    public User(){}

    public int getuID() {
        return uID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getTitle() {
        return title;
    }

    public Blob getProfile_picture() {
        return profile_picture;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProfile_picture(Blob profile_picture) {
        this.profile_picture = profile_picture;
    }
}
