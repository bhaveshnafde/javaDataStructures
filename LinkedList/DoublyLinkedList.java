import java.util.*;
class GenericDoublyLinkedList<E>{

  private Node<E> head;
  private Node<E> tail;
  private int length;

  public GenericDoublyLinkedList(){
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public boolean isEmpty(){
    return head == null;
  }

  public int size(){
    return length;
  }

  public void insertFront(E data){
      Node<E> toInsert = new Node<E>(data);
      if(isEmpty()){
        tail = toInsert;
      }else{
        head.prev = toInsert;
      }
      toInsert.next = head;
      head = toInsert;

      length++;
  }

  public void insertBack(E data){
      Node<E> toInsert = new Node<E>(data);
      if(isEmpty()){
        head = toInsert;
      }else{
        tail.next = toInsert;
      }
      toInsert.prev = tail;
      tail = toInsert;
      length++;
  }

  public void printFromFront(){
    if(isEmpty()){
      System.out.println("List is Empty!");
      return;
    }
    Node<E> temp = head;
    System.out.print("\nnull<=>");
    while(temp != null){
      System.out.print(temp.data+"<=>");
      temp = temp.next;
    }
    System.out.print("null");
  }

  public void printFromBack(){
    Node<E> temp = tail;
    if(isEmpty()){
      System.out.println("List Is Empty!");
      return;
    }
    System.out.print("\nnull<=>");
    while(temp != null){
      System.out.print(temp.data+"<=>");
      temp = temp.prev;
    }
    System.out.print("null");
  }

  public void removeFromFront(){
    if(isEmpty()){
      throw new NoSuchElementException();
    }
    Node<E> temp = head;
    if(head == tail){
      tail = null;
    }else{
      head.next.prev = null;
    }
    head = head.next;
    temp.next = null;
    length--;
  }

  public void removeFromBack(){
    if(isEmpty()){
      throw new NoSuchElementException();
    }
    Node<E> temp = tail;
    if(head == tail){
      head = null;
    }else{
      tail.prev.next = null;
    }
    tail = tail.prev;
    temp.prev = null;
    length--;
  }

  public void removeFromPos(int index){
    if(isEmpty() || index >= length){
      throw new NoSuchElementException();
    }
    Node<E> temp = head;
    if(index == 0){
      removeFromFront();
      return;
    }else if(index == length-1){
      removeFromBack();
      return;
    }
    while(index-->0){

      temp = temp.next;
    }
    if(temp.next == null){
      temp.prev.next = null;
    }else{
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
    }
    temp = null;
    length--;
  }

  public void reverse(){
    Node<E> hold = null;
    Node<E> temp = head;
    Node<E> newHead = head;

    while(temp != null){



        while(temp != null){
          hold = temp.prev;
          temp.prev = temp.next;
          temp.next = hold;
          newHead = temp;
          temp = temp.prev;
        }

        head = newHead;

    }

  }

  private class Node<E>{
    private E data;
    private Node<E> next;
    private Node<E> prev;
    public Node(E data){
      this.data = data;
    }
  }
}
public class DoublyLinkedList{
  public static void main(String bhavesh[]){
    GenericDoublyLinkedList<Integer> dll = new GenericDoublyLinkedList<>();
    dll.insertFront(3);
    dll.insertFront(2);
    dll.insertFront(1);
    dll.insertBack(4);
    dll.insertBack(5);
    dll.printFromFront();
    dll.removeFromFront();
    dll.printFromBack();
    dll.removeFromPos(1);
    dll.printFromFront();
    System.out.println("\n"+dll.size());
    dll.reverse();
    dll.printFromFront();
  }
}
/*
null<=>1<=>2<=>3<=>4<=>5<=>null
null<=>5<=>4<=>3<=>2<=>null
null<=>2<=>4<=>5<=>null
3
null<=>5<=>4<=>2<=>null
*/
