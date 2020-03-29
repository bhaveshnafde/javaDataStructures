public class StackByArray{

  private final int max_size;
  private int arr[];
  private int top;

  public StackByArray(int max_size){
    this.max_size = max_size;
    this.arr = new int[max_size];
    this.top = -1;
  }

  public boolean push(int data){
    if(top >= max_size - 1)  return false;
    arr[++top] = data;
    return true;
  }

  public void print(){
    if(top < 0) return;
    for (int i = top; i >= 0 ; i--) {
      System.out.println(arr[i]);
    }
  }

  public int pop(){
    if(top<0) return 0;
    return arr[top--];
  }

  public int peek(){
    if(top < 0) return 0;
    return arr[top];
  }

  public int size(){
    return this.top+1;
  }

  public boolean isEmpty(){
    return top == -1;
  }

  public static void main(String bhavesh[]){
    StackByArray st = new StackByArray(5);
    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);
    st.push(5);
    st.print();
    System.out.println(st.pop());
    System.out.println(st.pop());
    st.print();
    System.out.println(st.size());
    System.out.println(st.isEmpty());

  }

}
