import java.io.*;
import java.net.*;
public class Srever {
	public static void main(String args[]) throws Exception{
		ServerSocket server = null;
		Socket client = null;
		server = new ServerSocket(8888);
		boolean f = true;
		while(f)
		{
			System.out.println("服务器运行中！");
			client = server.accept();
			new Thread(new EchoThread(client)).start();
		}
		server.close();
	}
}
