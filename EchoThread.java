import java.io.*;
import java.net.*;

public class EchoThread implements Runnable{
	private Socket client = null;
	public EchoThread(Socket client)
	{
		this.client=client;
	}
	public void run()
	{
		PrintStream out = null;
		BufferedReader buf = null;
		try {
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			boolean flag = true;	//标准一个客户端操作是否完成；
			while(flag)
			{
				String str = buf.readLine();
				if(str==null||"".equals(str))	//判断输入是否为空
				{
					flag=false;
				}
				else
				{
					if("bye".equals(str))
					{
						flag = false;
					}
					else
					{
						out.println(str);
					}

				}
			}
			out.close();
			buf.close();
			client.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
