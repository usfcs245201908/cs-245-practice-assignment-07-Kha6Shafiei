public class LinkedList<T> implements List<T>{
	private Node head;
	private int size;
	
	public LinkedList(){
		head=null;
		size=0;
	}
	public class Node<T>{
		private T data;
		private Node next;

		public Node(T item){
			data=item;
			next=null;
		}
	}

	public void add(T item){
		if(head==null){
			head=new Node(item);
			++size;
		}
		else{
			Node prev=head;
			while(prev.next!=null)
				prev = prev.next;
			Node current = new Node(item);
			prev.next = current;
			++size;
		}
	}

	public void add(int pos, T item){
		if(pos>size||pos<0)
			System.out.println("The position is out of bounds in the list");
		if(pos==0){
			Node current = new Node(item);
			current.next = head;
			head = current;
			++size;
		}
		else{
			Node current = new Node(item);
			Node prev=head;
			for(int i=0; i<pos-1; i++)
				prev=prev.next;
			current.next=prev.next;
			prev.next=current;
			++size;
		}
	}

	public T get(int pos){
		if(pos<0||pos>size)
			System.out.println("The position is out of bounds in the list");
		Node prev=head;
		for(int i=0; i<pos; i++)
			prev=prev.next;
		return (T)prev.data;
	}

	public int size(){
		return size;
	}

	public T remove(int pos){
		if(pos<0||pos>size)
			System.out.println("The position is out of bounds in the list");
		if(pos==0){
			Node rem = head;
			head = head.next;
			--size;
			return (T)rem.data;
		}

		else{
			Node prev=head;
			for(int i=0; i<pos-1; i++)
				prev=prev.next;
			Node rem = prev.next;
			prev.next=rem.next;
			--size;
			return (T)rem.data;
		}
	}
}