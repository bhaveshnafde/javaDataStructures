public class QueueUsingArray{

  private int front;
  private int rear;
  private int size;
  int arr[];
  private int capacity;

  public QueueUsingArray(int capacity){
    this.capacity = capacity;
    arr = new int[capacity];
    front = 0;
    size = 0;
    rear = capacity - 1;
  }

  public boolean isFull(){
    return size == capacity;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public void enqueue(int item){
    if(isFull()){
      System.out.println("Queue Overflow");
      return;
    }
    rear = (rear + 1) % capacity;// if rear reaches to size then this restes it to 0
    arr[rear] = item;
    size++;
  }

  public int dequeue(){
    if(isEmpty()){
      System.out.println("Queue underflow");
      return 0;
    }
    int temp = arr[front];
    front = (front + 1) % capacity;
    size--;
    return temp;
  }

  public int front(){
    if(isEmpty()){
      System.out.println("Queue underflow");
      return 0;
    }
    return arr[front];
  }

  public int rear(){
    if(isEmpty()){
      System.out.println("Queue underflow");
      return 0;
    }
    return arr[rear];
  }

  public static void main(String bhavesh[]){
    QueueUsingArray que = new QueueUsingArray(5);
    que.enqueue(1);
    System.out.println(que.dequeue());

    que.enqueue(2);
    System.out.println(que.dequeue());

    que.enqueue(3);
    System.out.println(que.dequeue());

    que.enqueue(4);
    System.out.println(que.dequeue());

    que.enqueue(5);
    System.out.println(que.dequeue());
    que.enqueue(5);

    que.enqueue(5);

    que.enqueue(5);

    que.enqueue(5);

    que.enqueue(5);
    System.out.println(que.isFull());

  }

}
