public class Student extends Person {
    
    private String why_teacher;
    private Teacher assignTeacher = new Teacher();
    private Teacher visiTeacher = new Teacher();
    private boolean verified = false;
    private int assignTeachID;

    public Student(int ID, String name, int assignTeachID)
    {
        super(name, ID);
        this.assignTeachID = assignTeachID;
    }
    
    public Student()
    {
        super();
    }

    //set assignTeach based on ID
    
    public void setWhy_teacher(String why_teacher) 
    {
        this.why_teacher = why_teacher;
    }

    public String getWhy_teacher() 
    {
        return why_teacher;
    }
        
    public void set_teacher(Teacher t)
    {
        assignTeacher = t;
    }
    
    public Teacher getVisiTeacher() {
        return visiTeacher;
    }
    
    public String getVisiTeacherOption() {
        if (visiTeacher.getID() == -1)
        {
            return "No Teacher";
        }
        return visiTeacher.getID() + ": " + visiTeacher.getName();
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
    
//    public void select_teacher(Teacher t)
//    {
//        if(visiTeacher==null && t.getStudentCount() < t.getCapacity()) //FIX
//        {
//            visiTeacher = t;
//            t.add_student(this);
//            //GUI - prompt to answer why visiting that teacher
//        }
//    }
    
    public void deselect_teacher()
    {
        visiTeacher = new Teacher();
        why_teacher = "";
        setVerified(false);
    }

    public Teacher getAssignTeacher() {
        return assignTeacher;
    }
    
    public String getAssignTeacherOption() {
        if (assignTeacher.getID() == -1)
        {
            return "No Teacher";
        }
        return assignTeacher.getID() + ": " + assignTeacher.getName();
    }


    public void setAssignTeacher(Teacher assignTeacher) {
        this.assignTeacher = assignTeacher;
    }

    public int getAssignTeachID() {
        return assignTeachID;
    }

    public void setAssignTeachID(int assignTeachID) {
        this.assignTeachID = assignTeachID;
    }
}