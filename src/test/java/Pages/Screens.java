package Pages;

import com.microsoft.playwright.Page;

public class Screens {
    private Page page;
    private MainPage1 mainPage;

    public Screens() {
    }

    public Screens(Page page) {
        this.page = page;
    }


    public MainPage1 mainPage(){

        if(mainPage == null){
            mainPage = new MainPage1(page);
        }
        return mainPage;
    }






















}
