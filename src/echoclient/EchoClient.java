package echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient{
    public static void main(String[] args) throws IOException{
        Socket s = null;
        BufferedReader in = null;
        PrintWriter out = null;
        boolean fine=false;
        try{
            s = new Socket("localhost",2000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
        }catch(IOException e){}
        BufferedReader std_in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("maiuscole:off");
        while(fine==false){
            String stringa=std_in.readLine();
            if(stringa.equals("fine")){
                fine=true;
            }
            out.println(stringa);
            if(!stringa.equals("fine")&&!stringa.equals("maiuscole:on")&&!stringa.equals("maiuscole:off")){
                    try{
                    System.out.println(in.readLine());
                    }catch(IOException e){}
            }
        }
    }
}