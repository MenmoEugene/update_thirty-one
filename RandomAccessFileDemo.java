/*
RandomAccessFile

该类不算是IO体系中的子类。
而是直接继承自Object。

但它是IO包中成员，因为它具备读和写功能。
内部封装了一个数组，而且通过指针对数组的元素进行操作。
可以通过getFilePointer获取指针位置。
同时可以通过seek改变指针的位置。

其实完成读写的原理就是内部封装了字节输入流和输出流。

通过构造函数可以看出，该类只能操作文件。
而且操作文件还有模式：只读r，读写rw等。

如果模式为只读r，不会创建文件，会去读取一个已存在的文件，如果该文件不存在，则会出现异常。
如果模式rw。操作的文件不存在，会自动创建。如果存在则不会覆盖。
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

		//调整对象中的指针。
//		raf.seek(8*1);

		//跳过指定的字节数
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
		raf.write("周期".getBytes());
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
