package lab2;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {

	protected Project[] preferences=new Project[3];
	
	public Student(String name, String email)
	{
		super(name,email);
		//System.arraycopy(preferences, 0, this.preferences, 0, preferences.length);
	}
	
	public void setPreferences(Project[] preferences)
	{
		System.arraycopy(preferences, 0, this.preferences, 0, preferences.length);
	}
	
	public Project[] getPreferences()
	{
		return this.preferences;
	}
	
	public static void main(String[] args) {
		Project p1 = new Project("P1",2);
		Project p2 = new Project("P2",1);
		Project p3 = new Project("P3",1);
		Student s1 = new Student("S1","S1@yahoo.com");
		Project[] set = {p1,p2,p3};
		s1.setPreferences(set);
		System.out.println(s1.getPreferences()[0].name);
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o==null) return false;
		if(getClass() != o.getClass())
			return false;
		Student s = (Student) o;
		return Objects.equals(name, s.name) && Objects.equals(preferences, s.preferences);
	}

	@Override
	public String toString() {
		return "Student [preferences=" + Arrays.toString(preferences) + ", name=" + name + ", email=" + email + "]";
	}
	
}
