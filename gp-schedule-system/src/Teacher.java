import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    
    private int capacity;
    private PersonLinkedList visiStudents;
    //private final int studentCount = visiStudents.getSize(); BROKEN
    private PersonLinkedList assignStudents;
    
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
    
    public void add_student(Student s)
    {
        visiStudents.add(s);
        s.setVisiTeacher(this);
    }
    
    public void remove_student(Student s)
    {
        for (int i = 0; i < visiStudents.getSize(); i++)
        {
            if (visiStudents.get(i).equals(s))
            {
                visiStudents.remove(i);
                s.setVisiTeacher(null);
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
}
