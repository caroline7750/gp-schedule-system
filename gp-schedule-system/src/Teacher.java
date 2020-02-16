import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Teacher extends Person{
    
    private int capacity = 10; //default capacity
    private PersonLinkedList visiStudents = new PersonLinkedList(); 
    private int vStudentCount = visiStudents.size();
    private PersonLinkedList assignStudents = new PersonLinkedList();
    private boolean assignedAbleMove = true;
    
    public Teacher(int t_ID, String name)
    {
        super(name, t_ID);
    }
    
    public Teacher()
    {
        super();
    }
    
    public boolean isFull()
    {
        if (vStudentCount >= capacity)
        {
            return true;
        }
        return false;
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
        if (!isFull() && student.getVisiTeacher().getID() != this.getID())
        {
            student.setVisiTeacher(this);
            this.visiStudents.add((Person) student);
            setvStudentCount();
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
        }
        return student;
    }
    
    public String[] getAssignedStudentsLocations()
    {
        String[] locations = new String[assignStudents.size()];
        for (int i = 0; i < assignStudents.size(); i++)
        {
            try
            {
                String loc = ((Student)(assignStudents.get(i))).getVisiTeacher().getID() + "";
                if (loc.equals("-1"))
                {
                    locations[i] = "Not Moving";
                }
                else
                {
                    locations[i] = ((Student)(assignStudents.get(i))).getVisiTeacher().getID() + ": " + ((Student)(assignStudents.get(i))).getVisiTeacher().getName();
                }
            }
            catch (NullPointerException e) //catches for if deselected
            {
                locations[i] = "Not Moving";
            }
        }
        return locations;
    }
    
    public String[] getAssignedStudentsVerifications()
    {
        String[] verify = new String[assignStudents.size()];
        for (int i = 0; i < assignStudents.size(); i++)
        {
            try
            {
                String loc = ((Student)(assignStudents.get(i))).getVisiTeacher().getID() + "";
                if (loc.equals("-1"))            {
                    verify[i] = "n/a";
                }
                else if (((Student)(assignStudents.get(i))).isVerified())
                {
                    verify[i] = "Yes";
                }
                else
                {
                    verify[i] = "No";
                }
            }
            catch (NullPointerException e) //catches when deselected
            {
                verify[i] = "n/a"; 
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
                student.setVisiTeacher(new Teacher());
                setvStudentCount();
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

    public void setvStudentCount() {
        this.vStudentCount = visiStudents.size();
    }

    public boolean isAssignedAbleMove() {
        return assignedAbleMove;
    }

    public void setAssignedAbleMove(boolean assignedAbleMove) {
        this.assignedAbleMove = assignedAbleMove;
    }
}
