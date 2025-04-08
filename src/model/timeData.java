/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author acer
 */
public class timeData {
    public static  void time() {

        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    
                    Date time = new Date();
                    SimpleDateFormat form1Time = new SimpleDateFormat("hh:mm:ss a");
                    String stringTime = form1Time.format(time);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        
                    }
                }
            }
        };
        Thread thred = new Thread(runnable);
        thred.start();

    }
    
    public static  void date() {

        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    Date date = new Date();
                    SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
                    String stringDate = form1.format(date);                   
                    
                    
                    
                    Date time = new Date();
                    SimpleDateFormat form1Time = new SimpleDateFormat("hh:mm:ss a");
                    String stringTime = form1Time.format(time);
                    
                    
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        
                    }
                }
            }
        };
        Thread thred = new Thread(runnable);
        thred.start();

    }
}
