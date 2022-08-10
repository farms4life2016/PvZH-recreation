package farms4life2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import farms4life2016.processing.Controller;

public class Driver {
	
    /**
     * This class is solely used for the main method.
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        //Controller.run(); 
        //now's your chance to be a big shot
        Test test = new Test(10);
        test.run();

        Thread t = new Thread(test, "print some squares");
        System.out.println(t.getState());
        t.run();


    } 
    
    
    
}

class Test implements Runnable {

    int limit = 0;

    public Test(int lim) {
        limit = lim;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 1; i <= limit; i++) {
            System.out.println(i*i);
        }
    }

}