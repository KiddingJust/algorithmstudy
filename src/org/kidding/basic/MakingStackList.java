package org.kidding.basic;

public class MakingStackList {

	//Array와 달리 필요한 메모리 공간만 할당받아 사용이 가능. 
	//링크 필드에 따른 추가 공간 필요

	private Node top;
	
	//무엇? 
	private class Node{
		
		//실제 저장될 데이터 
		private int data;
		//다음 데이터의 참조를 가리키는 참조자. 
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//생성자. stack이 비어있으므로 null
	public MakingStackList() {
		this.top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int data) {
		Node newData = new Node(data);
		
		if(top == null) {	//empty 상태면,
			top = newData;
			return;
		}
		
		newData.next = top;		//next라는 Node를 top로 지정. 
		top = newData;			//이후 새로운 data를 top으로 지정. 
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("empty!");
			return -1;
		}
		
		int poped = top.data;
		top = top.next;		//하나를 빼주면 그 다음 것을 top으로 설정해주어야 함.
		return poped;
	}
	
	public void print() {
		Node tmp = top;
		while(tmp != null) {
			System.out.println(tmp.data + " ");
			tmp = tmp.next; 	//순차적으로 하나씩 출력. 
		}
	}
	
}
