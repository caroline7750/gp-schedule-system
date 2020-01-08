public class PersonLinkedList
{
  private PersonNode first = null;
  private PersonNode last = null;
  private int size = 0;
  public PersonLinkedList() { }

  public void add(Person data) // adding to the beginning
  {
    PersonNode newNode = new PersonNode(data);
    //linked the new Node's next reference to the current first Node
    newNode.setNext(first);
   
    first = newNode;
    last = newNode;
    size++;
    if(size == 1)
    {
      last = first;
    }
  }
  
  public void add(int index, Person data)
  {
    PersonNode n = new PersonNode(data);

    //check for specific scenario
    if(index<0) // out of bounds
    {
      return;
    }
    if(index>size)
    {
      return;
    }
    else if(index>0 && index<size)
    {
      int i = 0;
     
      for(PersonNode prev = first; prev!=null; prev = prev.getNext())
      {
        if(i==index-1)
        {
          n.setNext(prev.getNext());
          prev.setNext(n);
          size++;
        }
        i++;
      }
    }
    else if(index == size)
    {
      last.setNext(n); //link current last node's reference point to the new node
      last = n; //update last reference to point to new node
      size++; //increase size
    }
  }
 
  public void append(Person data)
  {
    add(size,data);
  }
  public int size()
  {
    return size;
  }
  public void clear() // clears the entire LL
  {
    first = null;
    last = first;
    size = 0;
  }
  public Person get(int index)
  {
    //see if index>size-1
    if(index >= size || index <0)
    {
      return null;
    }
    int i = 0;
    for(PersonNode curr= first; curr!= null; curr=curr.getNext()) //iterate through linked list
    {
      if(i == index) //stop at the index-th node + return
      {
        return curr.getP();
      }
      i++;

    }
    return null;
  }
  
  public Person find(int key)
  {
    //returns node with data matching key
    for(PersonNode c = first; c!=null; c=c.getNext()) // no counting necessary
    {
      if(c.getP().getID() == key)
      {
        return c.getP();
      }
    }
    return null;

  }
  public void set(int index, Person newData)
  {
    //modify the index-th node to have new data
    int i = 0;
    for(PersonNode c = first; c!=null; c=c.getNext())
    {
      if(index >= size || index <0)
      {
        break;
      }
      if(index == i)
      {
        c.setP(newData);
        break;
      }
      i++;
    }
  }
  public void remove(int index)
  {
    //bounds check
    Person store;
    if(index == 0)
    {
      store = first.getP();
      first = first.getNext();
      size--;
    }
    int i = 0;
   
    for(PersonNode c = first; c!=null; c=c.getNext())
    {
      if(index-1 == i)
      {
        store = c.getNext().getP();
        c.setNext(c.getNext().getNext());
        size --;
      }
      i++;
		}
  }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
