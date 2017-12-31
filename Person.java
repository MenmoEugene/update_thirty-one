import java.io.*;
class Person implements Serializable
{
	public static final long serialVersionUID = 42L;

	 String name;
	/* transient */ int age;
	 static String country = "canada";
	 Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	 }
	 public String toString()
	{
		return name+":"+age+":"+country;
	 }
}
