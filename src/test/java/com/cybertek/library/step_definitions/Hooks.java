package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @After
    public void tearDown(){
        BrowserUtils.sleep(2);
        Driver.killDriver();
    }
}
