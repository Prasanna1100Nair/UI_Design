package com.test.ui.prasannakumar.ui_design.Classes;

/**
 * Created by prasannakumar.nair on 26-Dec-18.
 */

public class Singleton {
    private static Singleton SingleObj=null;
    public String vars;
    private Singleton()
    {
        vars="hello";

    }
    public static Singleton getInstance()
    {
        if(SingleObj==null)
            SingleObj=new Singleton();
           return SingleObj;


    }
}
