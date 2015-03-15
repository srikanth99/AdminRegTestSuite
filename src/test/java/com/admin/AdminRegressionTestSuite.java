package com.admin;

import org.junit.Assert;
import org.junit.Test;

public class AdminRegressionTestSuite extends BaseTest {

//--------------------------Test Data------------------------------
    String adminUsername="admin", adminPassword="Insoft12";
    String empUname="EmpName"+Utils.generateRandomNo();
    String empPassword="Password12";
    String empFname="EmpFirstName",empLname="EmpLastName";

    BussinessLibrary blib = new BussinessLibrary();

    //End to end scenario
    @Test
    public void empProbationEnds(){
        blib.login(adminUsername,adminPassword); //Admin Login
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin")); //checkpoint
        blib.adminCreateEmpLoginDetails(empFname, empLname, empUname, empPassword);
        blib.logout(); //Admin Logout
        blib.login(empUname,empPassword); //Employee login
        blib.empCheckLoginDetails();  //Employee checks the details
        blib.logout(); //Employee Logout
        blib.login(adminUsername,adminPassword); //Admin Login
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin")); //checkpoint
        blib.adminChangeEmpDetails();  //Admin makes Emp Permanent
        blib.logout(); //Admin Logout
        blib.login(empUname,empPassword); //Employee login
        blib.empCheckChangeDetails();
        blib.logout(); //Employee Logout
    }
}
