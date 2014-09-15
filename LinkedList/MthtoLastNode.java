// Given a LinkedList ,Return the mth to last node element in the Linked List.


Node mthToLast(Node head,int k) {

  if(k==0)
    return null;
  
  Node current = head;
  
  for (int i =0;i<k;i++) {
    if(current.next!=null)
      current = current.next;
    else
      return null;
  }

  Node mthPointer = head;
  while(current.next){
    current = current.next;
    mthPointer = mthPointer.next;
  }

  return mthPointer;
}
