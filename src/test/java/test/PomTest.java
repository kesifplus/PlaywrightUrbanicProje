package test;


import Pages.Screens;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static utilities.Hooks.page;


@Listeners(utilities.Hooks.class)
public class PomTest {

    private Screens screens;


    @Epic("User Interface Tests")
    @Feature("Login Feature")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test for successful login with valid credentials")
    @Test
    void shouldNavigate(){

        screens = new Screens(page);


        Allure.step("Navigate to the login page",() -> {

           screens.mainPage().phoneNumber.click();
           screens.mainPage().phoneNumber.fill("590-345");
           //Thread.sleep(4000);
        });




    }














}
