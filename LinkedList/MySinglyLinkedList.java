public class MySinglyLinkedList<E>{
  private Node<E> head;
  private int length;

  public MySinglyLinkedList(){
    this.head = null;
    this.length = 0;
  }

  public void insertAtBeginning(E data){
    Node<E> toInsert = new Node<E>(data);
    toInsert.next = head;
    head = toInsert;
    length++;
  }

  public void insertAtEnd(E data){
    Node<E> toInsert = new Node<E>(data);
    Node<E> temp = head;
    if(head == null){
      head = toInsert;
    }else{
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = toInsert;
    }
    length++;
  }

  public void print(){
    Node<E> temp = head;
    while(temp != null){
      System.out.print(temp.data+"->");
      temp = temp.next;
    }System.out.println("null");
  }

  public void insertAtPosition(int n, E data){
    Node<E> toInsert = new Node<E>(data);
    Node<E> curr = head;
    if(n > length){
      return;
    }else if(n == 0){
        toInsert.next = curr;
        head = toInsert;
    }else{
      while(--n > 0) {
        curr = curr.next;
      }
      toInsert.next = curr.next;
      curr.next = toInsert;
    }
    length++;
  }

  public void removeFirst(){
    if(head == null)  return;
    head = head.next;
    length--;
  }

  public void removeLast(){
    if(head == null)  return;
    if(head.next == null) head = null;
    else{
      Node<E> temp = head;
      while(temp.next.next != null){
        temp = temp.next;
      }
      temp.next = null;
    }
    length--;
  }

  public void removeFromPosition(int n){
    Node<E> temp = head;
    if(head == null)  return;
    else if(n >= length)  return;
    else if(n == 0) head = head.next;
    else{
      while(--n > 0){
        temp = temp.next;
      }
      temp.next = temp.next.next;

    }
    length--;
  }

  private class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E data){
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String bhavesh[]){
    MySinglyLinkedList<Integer> sll;
    sll = new MySinglyLinkedList<Integer>();
    sll.insertAtEnd(1);
    sll.insertAtEnd(2);
    sll.insertAtEnd(3);
    sll.insertAtEnd(4);
    sll.print();
    sll.removeFromPosition(2);
    sll.print();
  }
}
