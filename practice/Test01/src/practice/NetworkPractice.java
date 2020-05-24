package practice;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetworkPractice {
    public static void main(String[] args) throws Exception{
        run1();
    }

    //1、使用java程序连接到服务器
    public static void run1() throws Exception{
        try {
            Socket s = new Socket("time-a.nist.gov", 13);//打开一个套接字
            Scanner in = new Scanner(s.getInputStream(), "UTF-8");
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } finally {
        }
    }
}
