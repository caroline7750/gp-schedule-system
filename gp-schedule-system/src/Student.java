public class Student extends Person {
    
    private String why_teacher;
    private Teacher assignTeacher;
    private Teacher visiTeacher = null;
    private boolean verified = false;

    public Student(String name, int ID, Teacher teacher_assign)
    {
        super(name, ID);
        this.assignTeacher = teacher_assign;
    }
    
    public Student()
    {
        super();
    }

    public void setWhy_teacher(String why_teacher) 
    {
        this.why_teacher = why_teacher;
    }

    public String getWhy_teacher() 
    {
        return why_teacher;
    }
    
    public Teacher get_teacher()
    {
        return assignTeacher;
    }
    
    public void set_teacher(Teacher t)
    {
        assignTeacher = t;
    }
    
    public Teacher getVisiTeacher() {
        return visiTeacher;
    }

    public void setVisiTeacher(Teacher visiTeacher) {
        this.visiTeacher = visiTeacher;
    }
    
    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    
    public void select_teacher(Teacher t)
    {
        if(visiTeacher==null && t.getStudentCount() < t.getCapacity())
        {
            visiTeacher = t;
            t.add_student(this);
            //GUI - prompt to answer why visiting that teacher
        }
    }
    
    public void deselect_teacher(Teacher t)
    {
        if(visiTeacher.equals(t))
        {
            visiTeacher = null;
            why_teacher = null;
            t.remove_student(this);
        }
    }
}