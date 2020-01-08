public class Student extends Person {
    
    private String why_teacher;
    private int s_ID;
    private Teacher assignTeacher;
    private Teacher visiTeacher = null;
    private boolean verified = false;

    private Student(int s_ID, Teacher teacher_assign)
    {
        this.s_ID = s_ID;
        this.assignTeacher = teacher_assign;
    }
    
    private Student()
    {
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
    
    public int getS_ID() {
        return s_ID;
    }

    public void setS_ID(int s_ID) {
        this.s_ID = s_ID;
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