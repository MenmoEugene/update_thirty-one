/*
DataInputStream �� DataOutputStream

�������ڲ��������������͵����ݵ�������
*/
import java.io.*;
class DataStreamDemo
{
	public static void main(String[] args) throws IOException
	{
		writeData();
		readData();

		writeUTFDemo();
		readUTFDemo();
/*
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"utf-8");//gbk

		osw.write("С���������֤");
		osw.close();
*/
	}

	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("utfdate.txt"));

		String s = dis.readUTF();

		System.out.println(s);
		dis.close();
	}
	
	public static void writeUTFDemo() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdate.txt"));

		dos.writeUTF("С���������֤");
	}
	public static void readData() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

		int num = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();

		sop("num="+num);
		sop("b="+b);
		sop("d="+d);
	}

	public static void writeData() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(1995.1210);

		dos.close();
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}
