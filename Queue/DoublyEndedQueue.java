public class DoublyEndedQueue<E>{
  private Node<E> head;
  private Node<E> rear;
  private int length;

  private class Node<E>{
    E data;
    Node<E> next;
    Node<E> prev;
    public Node(E data){
      this.data = data;
    }
  }

  public void addFront(E data){
    Node<E> to_insert = new Node<E>(data);
    if(head == null){
      head = to_insert;
      rear = to_insert;
    }else{
      head.prev = to_insert;
      to_insert.next = head;
      head = to_insert;
    }
    length++;
  }

  public void addBack(E data){
    Node<E> to_insert = new Node<E>(data);
    if(rear == null){
      head = to_insert;
      rear = to_insert;
    }else{
      rear.next = to_insert;
      to_insert.prev = rear;
      rear = to_insert;
    }
    length++;
  }

  public E removeFront(){
    if(head == null){
      System.out.println("underflow");
      return null;
    }
    E to_return;
    to_return = head.data;
    if(head == rear){
      head = null;
      rear = null;
    }else{
      head = head.next;
      head.prev = null;
    }
    length--;
    return to_return;
  }

  public E removeBack(){
    if(rear == null){
      System.out.println("underflow");
      return null;
    }
    E to_return;
    to_return = rear.data;
    if(head == rear){
      head = null;
      rear = null;
    }else{
      rear = rear.prev;
      rear.next = null;
    }
    length--;
    return to_return;
  }

  public void traverse(){
    Node<E> temp = head;
    while(temp!=null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    DoublyEndedQueue<Integer> deque = new DoublyEndedQueue<Integer>();
    deque.addFront(2);
    deque.addBack(3);
    deque.addFront(1);
    deque.addBack(4);

    deque.traverse();
    System.out.println(deque.removeFront());
    System.out.println(deque.removeBack());
    deque.traverse();
  }
}
