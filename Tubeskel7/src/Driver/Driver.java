/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import Controller.Controller;
import model.aplikasi;
import viewConsole.console;

/**
 *
 * @author The Keong's
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        aplikasi ap = new aplikasi();
        //new Controller(ap);
       
        console view = new console(ap);
        view.mainMenu();
    }
    
}
