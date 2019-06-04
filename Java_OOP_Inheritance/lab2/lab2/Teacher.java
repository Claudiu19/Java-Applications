package lab2;

import java.util.Arrays;
import java.util.Objects;

public class Teacher extends Person {

    protected Student[] preferences = new Student[4];
    protected Project project;

    public Teacher(String name, String email)
    {
        super(name,email);
    }

    public Project createProject(String nameProject, int cap)
    {
        Project p = new Project(nameProject,cap);
        this.project=p;
        return p;
    }

    public void setPreferences(Student[] students)
    {
        System.arraycopy(students,0,this.preferences,0,students.length);
    }

    public Student[] getPreferences()
    {
        return this.preferences;
    }

    public void setProject(Project p)
    {
        this.project=p;
    }

    public Project getProject()
    {
        return this.project;
    }

	@Override
	public String toString() {
		return "Teacher [preferences=" + Arrays.toString(preferences) + ", project=" + project + ", name=" + name
				+ ", email=" + email + "]";
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o==null) return false;
		if(getClass() != o.getClass())
			return false;
		Teacher t = (Teacher) o;
		return Objects.equals(name, t.name) && Objects.equals(preferences, t.preferences);
	}
}