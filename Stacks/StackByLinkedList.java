public class StackByLinkedList<E>{
  private Node<E> head;
  private int length;
  private int max_size;

  public StackByLinkedList(int max_size){
    this.max_size = max_size;
  }

  public boolean push(E data){
    if(length >= max_size)  return false;
    Node<E> to_push = new Node<E>(data);
    if(head == null)  head = to_push;
    else{
      Node<E> temp = head;
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = to_push;
    }
    length++;
    return true;
  }

  public E pop(){
    if(length <= 0)   return null;
    E to_return;
    if(head.next == null){
      to_return = head.data;
      head = null;
    }
    else{
      Node<E> temp = head;
      while(temp.next.next != null){
        temp = temp.next;
      }
      to_return = temp.next.data;
      temp.next = null;
    }
    length--;
    return to_return;
  }

  public void print(){
    if(head == null)  return;
    Node<E> temp = head;
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
  }

  public E peek(){
    if(head == null)  return null;
    Node<E> temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    return temp.data;
  }

  private class Node<E>{
    private E data;
    private Node<E> next;
    public Node(E data){
      this.data = data;
    }
  }
  public static void main(String bhavesh[]){
    StackByLinkedList<Integer> st = new StackByLinkedList<Integer>(5);
    st.push(1);

    st.print();
    System.out.println(st.push(5));
    st.print();
    System.out.println(st.pop());
    System.out.println(st.pop());
    System.out.println(st.pop());
    st.print();
    System.out.println(st.peek());
  }
}
