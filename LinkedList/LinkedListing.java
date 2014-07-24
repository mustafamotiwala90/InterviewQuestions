package solved;

public class LinkedListing {

	private Node first;

	public LinkedListing() {
		first = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(int d1) {
		Node link = new Node(d1);
		link.next = first;
		first = link;
	}

	public void insert(int d1) {
		Node link = new Node(d1);
		link.next = null;

		if (first == null) {
			first = link;
			return;
		}

		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = link;
	}

	public Node pop() {
		Node temp = first;
		first = first.next;
		return temp;
	}

	public void printList() {
		Node currentLink = first;
		while (currentLink != null) {
			System.out.print(currentLink.data + "\t");
			currentLink = currentLink.next;
		}
		System.out.println();
	}

	public void reverse() {
		Node temp = null;
		while (first != null) {
			Node t = pop();
			t.next = temp;
			temp = t;
		}
		first = temp;

	}

	public static void main(String[] args) {
		LinkedListing list = new LinkedListing();

		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);

		list.printList();
		list.reverse();
		list.printList();
	}
}
