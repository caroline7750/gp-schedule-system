import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    
    private int capacity;
    private PersonLinkedList visiStudents = new PersonLinkedList(); 
    private int vStudentCount = 0;
    private PersonLinkedList assignStudents = new PersonLinkedList();
    
    public Teacher(String name, int t_ID)
    {
        super(name, t_ID);
        capacity = 10; //default capacity
    }
    
    public Teacher()
    {
        super();
        capacity = 10;
    }

    public int getCapacity() 
    {
        return capacity;
    }
    
    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }
    
    public PersonLinkedList getVisiStudents() {
        return visiStudents;
    }

    public void setVisiStudents(PersonLinkedList visiStudents) {
        this.visiStudents = visiStudents;
    }

//    public int getStudentCount() 
//    {
//        return studentCount;
//    }

    public PersonLinkedList getAssignStudents() {
        return assignStudents;
    }

    public void setAssignStudents(PersonLinkedList assignStudents) {
        this.assignStudents = assignStudents;
    }
    
    public boolean add_student(Student student)
    {
        if (vStudentCount < capacity - 1)
        {
            student.setVisiTeacher(this);
            this.visiStudents.add((Person) student);
            vStudentCount++;
            return true;
        }
        return false;
    }
    
    public String[] getVisiStudentsForList()
    {
        String[] student = new String[visiStudents.size()];
        for (int i = 0; i < visiStudents.size(); i++)
        {
            student[i] = visiStudents.get(i).getID() + ": " + visiStudents.get(i).getName();
        }
        return student;
    }
    
    public String[] getAssignedStudentsForList()
    {
        String[] student = new String[assignStudents.size()];
        for (int i = 0; i < assignStudents.size(); i++)
        {
            student[i] = assignStudents.get(i).getID() + ": " + assignStudents.get(i).getName();
            System.out.println(student[i]);
        }
        return student;
    }
    
    public String[] getAssignedStudentsLocations()
    {
        String[] locations = new String[assignStudents.size()];
        for (int i = 0; i < assignStudents.size(); i++)
        {
            if (((Student)(assignStudents.get(i))).getVisiTeacher() == null)
            {
                locations[i] = "Not Moving";
            }
            else
            {
                locations[i] = ((Student)(assignStudents.get(i))).getVisiTeacher().getID() + ": " + ((Student)(assignStudents.get(i))).getVisiTeacher().getName();
            }
        }
        return locations;
    }
    
    public String[] getAssignedStudentsVerifications()
    {
        String[] verify = new String[assignStudents.size()];
        for (int i = 0; i < assignStudents.size(); i++)
        {
            if (((Student)(assignStudents.get(i))).getVisiTeacher() == null)
            {
                verify[i] = "n/a";
            }
            if (((Student)(assignStudents.get(i))).isVerified())
            {
                verify[i] = "Yes";
            }
            else
            {
                verify[i] = "No";
            }       
        }
        return verify;
    }
    
   
    public String[] getReasonsForList()
    {
        String[] reasons = new String[visiStudents.size()];
        for (int i = 0; i < visiStudents.size(); i++)
        {
            reasons[i] = ((Student)(visiStudents.get(i))).getWhy_teacher() + "";
        }
        return reasons;
    }
    
    public void remove_student(Student student)
    {
        for (int i = 0; i < visiStudents.getSize(); i++)
        {
            if (visiStudents.get(i).equals(student))
            {
                visiStudents.remove(i);
                student.setVisiTeacher(null);
                return;
            }
        }
    }
    
    public void verify_student(Student s)
    {
        if (s.getVisiTeacher().getID() == this.getID())
        {
            s.setVerified(true);
        }
    }
    
    public void import_students(String file_name, PersonLinkedList assignStudents)
    {
        //call CSVLineByLine
    }

    public int getvStudentCount() {
        return vStudentCount;
    }

    public void setvStudentCount(int vStudentCount) {
        this.vStudentCount = vStudentCount;
    }
}
