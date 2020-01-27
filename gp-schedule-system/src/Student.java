public class Student extends Person {
    
    private String why_teacher;
    private Teacher assignTeacher;
    private Teacher visiTeacher;
    private boolean verified = false;
    private int assignTeachID;

    public Student(int ID, String name, int assignTeachID)
    {
        super(name, ID);
        this.assignTeachID = assignTeachID;
        
        //need to search for ID and assign it to teacher
        //pre-check that ID existing (do this in file processing)
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
    
//    public void select_teacher(Teacher t)
//    {
//        if(visiTeacher==null && t.getStudentCount() < t.getCapacity()) //FIX
//        {
//            visiTeacher = t;
//            t.add_student(this);
//            //GUI - prompt to answer why visiting that teacher
//        }
//    }
    
    public void deselect_teacher(Teacher t)
    {
        if(visiTeacher.equals(t))
        {
            visiTeacher = null;
            why_teacher = null;
            t.remove_student(this);
        }
    }

    public Teacher getAssignTeacher() {
        return assignTeacher;
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