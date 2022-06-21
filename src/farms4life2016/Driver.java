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
        ServerSocket ss = new ServerSocket(6667);
        
        Socket s = new Socket(ss.getInetAddress().getHostAddress(), ss.getLocalPort());

        BufferedReader br = new BufferedReader( new InputStreamReader(s.getInputStream()) );
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
    }  
    
}