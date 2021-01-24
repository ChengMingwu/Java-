
import java.io.*;
import java.net.*;

public class Client{
	public static void main(String args[]) throws Exception{
		Socket client = new Socket("localhost",8888);
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out = new PrintStream(client.getOutputStream());
		boolean f = true;
		while(f)
		{
			System.out.println("«Î ‰»Îœ˚œ¢£∫");
			String str = input.readLine();
			out.println(str);
			if("bye".equals(str))
			{
				f = false;
			}
			else
			{
				System.out.println(buf.readLine());
			}
		}
	}
}