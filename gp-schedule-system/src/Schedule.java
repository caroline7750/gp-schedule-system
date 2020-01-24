import java.util.ArrayList;

public class Schedule {
    
    PersonLinkedList teachers; //contains teachers' IDs
    PersonLinkedList students; //contains students' IDs
     
    public Schedule(PersonLinkedList teachers, PersonLinkedList students)
    {
        this.teachers = teachers;
        this.students = students;
    }
    
    public Schedule()
    {
        
    }
    
    public String[] getStudentsForCombo()
    {
        String[] studentIDs = new String[students.getSize()];
        for (int i = 0; i < students.getSize(); i++)
        {
            studentIDs[i] = students.get(i).getID() + "";
        }   
        return studentIDs;
    }
    
    //setters and getters
    
    public PersonLinkedList getTeachers() {
        return teachers;
    }

    public void setTeachers(PersonLinkedList teachers) {
        this.teachers = teachers;
    }

    public PersonLinkedList getStudents() {
        return students;
    }

    public void setStudents(PersonLinkedList students) {
        this.students = students;
    }
    public int find_student(int studentID)
    //return teacher ID of student's location
    {
        for (int i = 0; i<students.getSize(); i++)
        {
            Student s = (Student) students.get(i);
            if (s.getVisiTeacher() != null)
            {
                return s.getVisiTeacher().getID();
            }
            else
            {
                return s.get_teacher().getID();
            }
        }
        return -1; 
    }
    
    private void freeze_teachers()
    {
        for (int i = 0; i<teachers.getSize(); i++)
        {
            Teacher t = (Teacher) teachers.get(i);
            t.setCapacity(0);
        }
    }
    
    public String get_teacher_list()
    {
        String l = "";
        for (int i = 0; i<teachers.getSize(); i++)
        {
            Teacher t = (Teacher) teachers.get(i);
            l += t.getName() + t.getID();
        }
        return l;
    }
    
    public String print_master_list()
    {
        String l = "";
        for (int i = 0; i<teachers.getSize(); i++)
        {
            Teacher t = (Teacher) teachers.get(i);
            l += t.getName() + t.getID();
            l += "Students: ";
            for (int j = 0; j<t.getAssignStudents().getSize(); j++)
            {
                Student s = (Student) students.get(j);
                l += s.getName() + s.getID();
            }
            l = t.getName() + t.getID();
        }
        return l;
    }
        
    public void move_student(Student s, Teacher t)
    {
        s.set_teacher(t);
    }
    
}
