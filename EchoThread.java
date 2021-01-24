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
			boolean flag = true;	//��׼һ���ͻ��˲����Ƿ���ɣ�
			while(flag)
			{
				String str = buf.readLine();
				if(str==null||"".equals(str))	//�ж������Ƿ�Ϊ��
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
