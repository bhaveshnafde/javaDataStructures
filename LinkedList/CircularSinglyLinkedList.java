public class CircularSinglyLinkedList<E>{

  private Node<E> last;
  private int length;

  public CircularSinglyLinkedList(){
    this.last = null;
    this.length = 0;
  }

  private class Node<E>{

    private E data;
    private Node<E> next;

    public Node(E data){
      this.data = data;
      this.next = null;
    }
  }

  public boolean isEmpty(){
    return last == null;
  }

  public int size(){
    return length;
  }

  public void insertAtBeginning(E data){
    Node<E> toInsert = new Node<E>(data);
    if(last == null){
      last = toInsert;
    }else{
      toInsert.next = last.next;
    }
    last.next = toInsert;
    length++;
  }

  public void insertAtEnd(E data){
    Node<E> toInsert = new Node<E>(data);
    if(last == null){
      toInsert.next = toInsert;
    }else{
      toInsert.next = last.next;
      last.next = toInsert;
    }
    last = toInsert;
    length++;
  }

  public void removeFirst(){
    if(last == null)  return;
    if(last.next ==  last)  last = null;
    else{
      last.next = last.next.next;
    }
    length--;
  }

  public void removeLast(){
    if(last == null)  return;
    if(last.next == last){
      last = null;
    }else{
      Node<E> temp = last.next;
      while(temp.next != last){
        temp = temp.next;
      }
      temp.next = last.next;
      last = temp;
    }
    length--;
  }

  public void traverse(){
    if(last == null)  return;
    Node<E> first = last.next;
    while(first != last){
      System.out.print(first.data+" ");
      first = first.next;
    }
    System.out.println(first.data);
  }

  public static void main(String bhavesh[]){
    CircularSinglyLinkedList<Integer> csll = new CircularSinglyLinkedList<Integer>();
    // csll.insertAtBeginning(4);
    // csll.insertAtBeginning(3);
    csll.insertAtBeginning(2);
    csll.insertAtBeginning(1);
    csll.insertAtEnd(5);
    csll.removeLast();
    csll.traverse();
  }
}
