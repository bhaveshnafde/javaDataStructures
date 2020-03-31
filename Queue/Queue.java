public class Queue<E>{
  private Node<E> front,rear;
  private int length;

  public void enqueue(E data){
    Node<E> to_insert = new Node<E>(data);
    if(front == null){
      front = to_insert;
      rear = to_insert;
    }else{
      rear.next = to_insert;
      rear = to_insert;
    }
    length++;
  }

  public E dequeue(){
    if(front == null)  return null;
    E to_return;
    if(front == rear){
      rear = null;
    }
    to_return = front.data;
    front = front.next;
    length--;
    return to_return;
  }

  public void print(){
    if(front == null) return;
    Node<E> temp = front;
    while(temp != rear){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }System.out.println(temp.data);
  }

  private class Node<E>{
    Node<E> next;
    E data;

    public Node(E data){
      this.data = data;
    }
  }

  public static void main(String bhavesh[]){
    Queue<Integer> que = new Queue<Integer>();
    que.enqueue(1);
    que.enqueue(2);
    que.enqueue(3);
    que.print();
    System.out.println(que.dequeue());
    System.out.println(que.dequeue());
    System.out.println(que.dequeue());
    System.out.println(que.dequeue());

  }
}
