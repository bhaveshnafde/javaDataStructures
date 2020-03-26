public class DoublyLinkedList<E>{

  private Node<E> head;
  private Node<E> tail;
  private int length;

  public MyDoublyLinkedList(){
    this.head = null;
    this.tail = null;
    length = 0;
  }

  public void insertFront(E data){
    Node<E> toInsert = new Node<E>(data);
    if(head == null){
      tail = toInsert;
      head = toInsert;
    }else{
      toInsert.next = head;
      head.prev = toInsert;
      head = toInsert;
    }
    length++;
  }

  public void insertBack(E data){
    Node<E> toInsert = new Node<E>(data);
    Node<E> temp = head;
    if(head == null){
      head = toInsert;
      tail = toInsert;
    }else{
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = toInsert;
      toInsert.prev = temp;
      tail = toInsert;
    }
    length++;
  }

  public void insertAtPosition(int n, E data){
    Node<E> toInsert = new Node<E>(data);
    Node<E> temp = head;
    if(n > length){
      return;
    }else if(n == 0){
      toInsert.next = head;
      head.prev = toInsert;
      head = toInsert;
    }else{
      while(--n > 0){
        temp = temp.next;
      }
      toInsert.next = temp.next;
      toInsert.prev = temp;
      if(temp.next != null){
        temp.next.prev = toInsert;
      }else{
        tail = toInsert;
      }
      temp.next = toInsert;
    }
    length++;
  }

  public void size(){
    System.out.println("\n"+length);
  }

  public void print(){
    Node<E> temp = head;
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
  }

  public void removeFront(){
    if(head == null)  return;
    if(head.next == null)  head = null;
    else{
      Node<E> hold = head.next;
      head.next.prev = null;
      head.next = null;
      head = hold;
    }
    length--;
  }

  public void removeFromPosition(int n){
    if(head == null)  return;
    Node<E> temp = head;
    int i = 0;
    while(i++ < n && temp.next != null){
      temp = temp.next;
    }
    if(i < n) return;
    if(temp.next != null){
      temp.next.prev = temp.prev;
    }else{
      tail = temp.prev;
    }
    if(temp.prev != null){
      temp.prev.next = temp.next;
    }else{
      head = head.next;
    }
    length--;
  }

  public void printFromBack(){
    Node<E> temp = tail;
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.prev;
    }
  }

  private class Node<E>{
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data){
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }

  public static void main(String bhavesh[]){
    MyDoublyLinkedList<Integer> dll = new MyDoublyLinkedList<Integer>();

    dll.insertBack(4);
    dll.removeFromPosition(0);
    dll.print();
    dll.size();
    dll.printFromBack();
  }
}
