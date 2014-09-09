public class Queue {
  public int qSize;
  public int maxSize;
  public int rear;
  public int front;
  private char[] queue;
  
  public Queue(int size) {
    qSize=0;
    maxSize = size;
    rear=0;
    front=0;
    queue = new char[size];
  }

  public boolean emptyQueue() {
    return (qSize==0);
  }
  
  public boolean isQueueFull() {
    return (qSize==maxSize);
  }
  
  public void insert(char c) {
    if(!isQueueFull()) {
      qSize++;
      rear = (rear + 1) % maxSize;
      queue[rear] = c;
    
    } else {
      System.out.println("Overflow error");
    }
  }

  public char delete() {
    if(!isEmptyQueue()) {
      qSize--;
      front = (front + 1) % maxSize;
      return queue[front];
      
    } else { 
      System.out.println("Underflow error");
    }
  }



}
