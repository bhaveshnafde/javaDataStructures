import java.util.*;
class MySinglyLinkedList<E>{

  private MyNode<E> head;
  private int length;

  public MySinglyLinkedList(){
    this.head = null;
    this.length = 0;
  }

  public void add(E data){
    MyNode<E> toAdd = new MyNode<E>(data);
    if(isEmpty()){
      head = toAdd;
      length++;
      return;
    }
    MyNode<E> temp = head;
    while(temp.next != null){
      temp = temp.next;
    }
    temp.next = toAdd;
    length++;
  }

  public void print(){
    MyNode<E> temp = head;
    if(isEmpty()){
      System.out.println("List is Empty!");
      return;
    }
    while(temp != null){
      System.out.print(temp.data+" ");
      temp = temp.next;
    }
  }

  public E get(int index){
    if(isEmpty()){
      System.out.println("List is Empty!");
      return null;
    }else if(size()<index){
      System.out.println("index "+index+" is unreachable");
      return null;
    }
    MyNode<E> temp = head;
    while(index-->0){
      temp = temp.next;

    }
    return temp.data;
  }

  public void put(int index, E value){
    if(isEmpty()){
      System.out.println("List is Empty!");
      return ;
    }else if(size()<index){
      System.out.println("index "+index+" is unreachable");
      return;
    }
    MyNode<E> temp = head;
    while(index-->0){
      temp = temp.next;

    }
    temp.data = value;
  }

  public int size(){
    return length;
  }

  public boolean isEmpty(){
    return head == null;
  }

  public void clear(){
    if(isEmpty()){
      System.out.println("List is Empty!");
      return;
    }
    head = null;
    length = 0;
  }

  public void remove(int index){
    if(isEmpty()){
      System.out.println("List is Empty!");
      return;
    }else if(size()<index){
      System.out.println("index "+index+" is unreachable");
      return;
    }
    MyNode<E> temp = head;
    MyNode<E> toRemove;
    if(index == 0){
      head = head.next;
      length--;
      return;
    }
    while(index-->0){
      if(index == 0){
        toRemove = temp.next;
        temp.next = toRemove.next;
        length--;
        return;
      }else{
        temp = temp.next;
      }
    }
    length--;
  }

  private class MyNode<E>{
    private E data;
    private MyNode<E> next;
    public MyNode(E data){
      this.data = data;
      this.next = null;
    }
  }
}

public class SinglyLinkedList{
  public static void main(String bhavesh[]){
    Scanner sc = new Scanner(System.in);
    MySinglyLinkedList<Integer> msll = new MySinglyLinkedList<>();
    int choice = -1;
    System.out.println("1.> Add");
    System.out.println("2.> Get");
    System.out.println("3.> Print");
    System.out.println("4.> Put");
    System.out.println("5.> Remove");
    System.out.println("6.> clear");
    System.out.println("7.> RemoveAll");
    System.out.println("8.> Size");
    System.out.println("9.> EXIT");
    while(choice != 9){
      System.out.print("ENTER YOUR CHOICE : ");
      choice  = sc.nextInt();
      switch(choice){
        case 1 :  System.out.println("Enter Element to be added") ;
                  int ele = sc.nextInt();
                  msll.add(ele);
                  break;
        case 2 :  System.out.println("Enter index of Element to be fetched") ;
                  int idx = sc.nextInt();
                  System.out.println("Element at index "+idx+" is : "+msll.get(idx)) ;
                  break;
        case 3 :  msll.print();
                  System.out.println();
                  break;
        case 4 :  System.out.println("Enter index of Element to be inserted and element") ;
                  idx = sc.nextInt();
                  ele = sc.nextInt();
                  msll.put(idx,ele);
                  msll.print();
                  break;
        case 5 :  System.out.println("Enter index of Element to be removed") ;
                  idx = sc.nextInt();
                  msll.remove(idx);
                  msll.print();
                  break;
        case 6 :  msll.clear();
                  break;
        case 7 :  System.out.println("Enter index of Element to be fetched") ;

                  break;
        case 8 :  System.out.println("Size : "+msll.size()) ;

                  break;
        case 9 :  System.out.println("EXITING");
                  break;
        default : System.out.println("Wrong Choice! Enter Again") ;

      }
    }
  }
}
