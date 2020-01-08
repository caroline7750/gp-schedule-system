public class Schedule {
    
    PersonLinkedList teachers; //contains teachers' IDs
    PersonLinkedList students; //contains students' IDs
    
    public Schedule(PersonLinkedList teachers, PersonLinkedList students)
    {
        this.teachers = teachers;
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
                return s.getVisiTeacher().getT_ID();
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
    
    private String get_teacher_list()
    {
        String l = "";
        for (int i = 0; i<teachers.getSize(); i++)
        {
            Teacher t = (Teacher) teachers.get(i);
            l += t.getName() + t.getT_ID();
        }
        return l;
    }
    
    private String get_master_list()
    {
        String l = "";
        for (int i = 0; i<teachers.getSize(); i++)
        {
            Teacher t = (Teacher) teachers.get(i);
            l += t.getName() + t.getT_ID();
            l += "Students: ";
            for (int j = 0; j<t.getAssignStudents().getSize(); j++)
            {
                Student s = (Student) students.get(j);
                l += s.getName() + s.getS_ID();
            }
            l = t.getName() + t.getT_ID();
        }
        return l;
    }
    
    private void move_student(Student s, Teacher t)
    {
        s.set_teacher(t);
    }
    
}
