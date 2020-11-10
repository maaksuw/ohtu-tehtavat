package ohtu;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import ohtu.io.*;
import ohtu.data_access.*;
import ohtu.services.*;

public class Stepdefs {
    App app;
    StubIO io;
    UserDao userDao;
    AuthenticationService auth;
    List<String> inputLines;
    
    @Before
    public void setup(){
        userDao = new InMemoryUserDao();
        auth = new AuthenticationService(userDao);
        inputLines = new ArrayList<>();      
    }
    
    @Given("^command login is selected$")
    public void commandLoginSelected() throws Throwable {
        inputLines.add("login");
    }

    @When("username {string} and password {string} are entered")
    public void usernameAndPasswordAreEntered(String username, String password) {
       inputLines.add(username);
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        assertTrue(io.getPrints().contains(expectedOutput));
    }    
    
    @Given("command new is selected")
    public void commandNewIsSelected() {
        inputLines.add("new");
    }
    
    @When("username {string} is entered")
    public void usernameIsEntered(String username) {
       inputLines.add(username);
    }
    
    @When("password {string} is entered")
    public void passwordIsEntered(String password) {
       inputLines.add(password);
       
       io = new StubIO(inputLines); 
       app = new App(io, auth);
       app.run();
    }
    
    @Given("user {string} with password {string} is created")
    public void userWithPasswordIsCreated(String username, String password) {
        auth.createUser(username, password);
    }

}
