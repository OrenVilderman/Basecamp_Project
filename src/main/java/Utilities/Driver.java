package Utilities;

import io.appium.java_client.android.AndroidDriver;

public class Driver extends CommonOps{

    protected AndroidDriver aDriver;

    public Driver(){
        this.aDriver = super.getDriver();
    }
}
