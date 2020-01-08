public class Teacher extends Person{
    
    private int capacity;
    private int t_ID;
    private PersonLinkedList visiStudents;
    private final int studentCount = visiStudents.getSize();
    private PersonLinkedList assignStudents;
    
    private Teacher(int t_ID, int capacity)
    {
        this.t_ID = t_ID;
        this.capacity = capacity;
    }
    
    private Teacher()
    {
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
    
    public int getStudentCount() 
    {
        return studentCount;
    }

    public PersonLinkedList getVisiStudents() {
        return visiStudents;
    }

    public void setVisiStudents(PersonLinkedList visiStudents) {
        this.visiStudents = visiStudents;
    }

    public PersonLinkedList getAssignStudents() {
        return assignStudents;
    }

    public void setAssignStudents(PersonLinkedList assignStudents) {
        this.assignStudents = assignStudents;
    }

    public int getT_ID() {
        return t_ID;
    }

    public void setT_ID(int t_ID) {
        this.t_ID = t_ID;
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
        if (s.getVisiTeacher().getID() == t_ID)
        {
            s.setVerified(true);
        }
    }
    
    public void import_students()
    {
        //use CSV import func & file reader
    }

}
