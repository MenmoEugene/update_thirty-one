/*
�����ѧ����ÿ��ѧ����3�ſεĳɼ���
�Ӽ���������������(�������������ſγɼ�)��
����ĸ�ʽ���磺zhangsan,30,40,34������ܳɼ���
����ѧ������Ϣ�ͼ�������ָܷߵ�˳�����ڴ����ļ�"stud.txt"�С�

1������ѧ������
2������һ���ɲ���ѧ������Ĺ����ࡣ

˼�룺
1��ͨ����ȡ����¼��һ�����ݣ����������е���Ϣȡ����װ��ѧ������
2����Ϊѧ�������кܶ࣬��ô����Ҫ�洢��ʹ�õ����ϡ�
	��ΪҪ��ѧ�����ܷ��������Կ���ʹ��TreeSet.
3�������ϵ���Ϣд�뵽һ���ļ��С�

*/
import java.io.*;
import java.util.*;

class Student implements Comparable<Student>
{
	private String name;
	private int math,chinese,english;
	private int sum;

	Student(String name,int math,int chinese,int english)
	{
		this.name = name;
		this.math = math;
		this.chinese = chinese;
		this.english = english;
		sum = math + chinese + english;
	}

	public int compareTo(Student s)
	{
		int num = new Integer(this.sum).compareTo(new Integer(s.sum));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	public String getname()
	{
		return name;
	}
	public int getSum()
	{
		return sum;
	}
	public int hashCode()
	{
		return name.hashCode()+sum*78;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("���Ͳ�ƥ��");
		Student s = (Student)obj;

		return this.name.equals(s.name) && this.sum==s.sum;
	}
	public String toString()
	{
		return "student["+name+","+math+","+chinese+","+english+"]";
	}
}

class StudentInfoTool
{
	public static Set<Student> getStudents() throws IOException
	{
		return getStudents();
	}
	public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException
	{
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		String line = null;

		Set<Student> stus = null;
		if(cmp==null)
			stus = new TreeSet<Student>();
		else
			stus = new TreeSet<Student>(cmp);
		while ((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			
			String[] info = line.split(",");

			Student stu = new Student(info[0],Integer.parseInt(info[1]),
											Integer.parseInt(info[2]),
											Integer.parseInt(info[3]));

			stus.add(stu);
		}
		bufr.close();

		return stus;
	}

	public static void write2File(Set<Student> stus) throws IOException
	{
		BufferedWriter bufw = new BufferedWriter(new FileWriter("stuinfo.txt"));

		for(Student stu : stus)
		{
			bufw.write(stu.toString()+"\t");
			bufw.write(stu.getSum()+"");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}
class StudentInfoTest
{	
	public static void main(String[] args) throws IOException
	{
		Comparator<Student> cmp = Collections.reverseOrder();

		Set<Student> stus = StudentInfoTool.getStudents(cmp);

		StudentInfoTool.write2File(stus);
	}
}
