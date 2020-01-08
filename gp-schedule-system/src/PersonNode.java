public class PersonNode
{
    public Person p;
    private PersonNode next = null;

        public PersonNode() {}

    public PersonNode(Person data)
    {
        this.p = data;
    }
    
    public Person getP()
    {
        return p;
    }
    
    public void setP(Person p)
    {
        this.p = p;
    }

    public PersonNode getNext() {
        return next;
    }

    public void setNext(PersonNode next) {
        this.next = next;
    }
}