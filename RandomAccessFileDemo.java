/*
RandomAccessFile

���಻����IO��ϵ�е����ࡣ
����ֱ�Ӽ̳���Object��

������IO���г�Ա����Ϊ���߱�����д���ܡ�
�ڲ���װ��һ�����飬����ͨ��ָ��������Ԫ�ؽ��в�����
����ͨ��getFilePointer��ȡָ��λ�á�
ͬʱ����ͨ��seek�ı�ָ���λ�á�

��ʵ��ɶ�д��ԭ�������ڲ���װ���ֽ����������������

ͨ�����캯�����Կ���������ֻ�ܲ����ļ���
���Ҳ����ļ�����ģʽ��ֻ��r����дrw�ȡ�

���ģʽΪֻ��r�����ᴴ���ļ�����ȥ��ȡһ���Ѵ��ڵ��ļ���������ļ������ڣ��������쳣��
���ģʽrw���������ļ������ڣ����Զ���������������򲻻Ḳ�ǡ�
*/
import java.io.*;
class RandomAccessFileDemo
{
	public static void main(String[] args) throws IOException
	{
//		writeFile();
//		readFile();
		writeFile_2();
	}
	public static void readFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","r");

		//���������е�ָ�롣
//		raf.seek(8*1);

		//����ָ�����ֽ���
		raf.skipBytes(8);

		byte[] buf = new byte[4];

		raf.read(buf);

		String name = new String(buf);
		int age = raf.readInt();

		System.out.println("name="+name);
		System.out.println("age="+age);

		raf.close();
	}

	public static void writeFile_2() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
		raf.seek(8*3);
		raf.write("����".getBytes());
		raf.writeInt(103);

		raf.close();
	}
	public static void writeFile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");

		raf.write("xml".getBytes());
		raf.writeInt(22);
		raf.write("wzx".getBytes());
		raf.writeInt(23);

		raf.close();
	}
}