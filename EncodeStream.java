import java.io.*;
class EncodeStream
{
	public static void main(String[] args) throws IOException
	{
		writeText();
		readText();
	}

	public static void readText() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("gbk.txt"),"UTF-8");

		char[] buf = new char[10];
		int len = isr.read(buf);

		String str = new String(buf,0,len);

		System.out.println(str);

		isr.close();
	}

	public static void writeText() throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"UTF-8");

		osw.write("小萝莉漫许可证");

		osw.close();
	}
}
