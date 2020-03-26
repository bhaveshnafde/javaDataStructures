public class CircularDoublyLinkedList<E>{

  private Node<E> head;
  private int length;

  private class Node<E>{
    private E data;
    private Node<E> prev;
    private Node<E> next;

    public Node(E data){
      this.data = data;
    }
  }

  public void insertAtBeginning(E data){
    Node<E> toInsert = new Node<E>(data);
    if(head == null){
      toInsert.prev = toInsert;
      toInsert.next = toInsert;
      head = toInsert;
    }
    else{
      toInsert.next = head;
      toInsert.prev = head.prev;
      head.prev.next = toInsert;
      head.prev = toInsert;
      head = toInsert;
    }
    length++;
  }

  public void insertAtEnd(E data){
    Node<E> toInsert = new Node<E>(data);
    if(head == null){
      toInsert.next = toInsert;
      toInsert.prev = toInsert;
      head = toInsert;
    }else{
      toInsert.next = head;
      toInsert.prev = head.prev;
      head.prev.next = toInsert;
      head.prev = toInsert;
    }
    length++;
  }

  public void removeFront(){
    if(head == null) return;
    if(head.next == head)  head = null;
    else{
      head.prev.next = head.next;
      head.next.prev = head.prev;
      head = head.next;
    }
    length--;
  }

  public void removeLast(){
    if(head == null)  return;
    if(head.next == head)  head = null;
    else{
      Node<E> secondLast = head.prev.prev;
      secondLast.next = head;
      head.prev = secondLast;
    }
    length--;
  }

  public void print(){
    if(head == null)  return;
    Node<E> temp = head;
    while(temp.next != head){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
    System.out.println(temp.data);
  }

  public int size(){
    return length;
  }

  public static void main(String bhavesh[]){
    CircularDoublyLinkedList<Integer> cdll = new CircularDoublyLinkedList<Integer>();
    cdll.insertAtEnd(1);
    cdll.insertAtEnd(2);
    cdll.insertAtEnd(3);
    cdll.removeLast();
    cdll.print();
  }
}
