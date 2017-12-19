package codes;

public class LinkedList {

	private static Node root, end;
	private int SIZE = 0;
	
	public LinkedList(){
		root = null;
		end = null;
	}
	
	public void display(){
		Node temp = root;
		for(int i = 0; i < SIZE; i++){
			System.out.printf("%3d", temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void push(int number){
		Node marker = new Node(number);
		end = marker;
		if(root == null){
			marker.setPrev(null);
			root = marker;
		}else{
			Node temp = root;
			while(temp.getNext() != null)
				temp = temp.getNext();
				temp.setNext(marker);
				marker.setPrev(temp);
		}
		SIZE++;
	}
	
	public void pop(){
		if(end != root){
			end = end.getPrev();
			end.getNext();
		}else{
			end = null;
			root = null;
		}
		if(SIZE > 0)
			SIZE--;
	}
	
	public Node find(int data){
		Node temp = root;
		for(int i = 0; i < SIZE; i++){
			if(temp.getData() == data)
				return temp;
			temp = temp.getNext();
		}
		return null;	
	}
	
	public void pop(int data){
		Node temp = find(data);
		if(temp != null){
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
			SIZE--;
		}
	}
	
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.push(0);
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		ll.push(5);
		ll.push(6);
		ll.push(7);
		ll.push(8);
		ll.push(9);
		ll.push(10);
		ll.pop();
		ll.pop(10);
		ll.pop(9);
		ll.pop(8);
		ll.display();
	}
}
