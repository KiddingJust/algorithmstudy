package org.kidding.basic;

public class MakingStackArray {

	//간단하게 구현 가능하지만 스택의 크기가 불확실 할때에는 확장시 확장연산이 오래걸린다.
	private int[] stack;
	//top 인덱스를 지시하는 변수. 초기값은 -1로 하여 빈 스택을 나타냄. 
	private int top;	
	
	public MakingStackArray(int size) {
		top = -1;
		stack = new int[size];
	}
	
	public boolean isFull() {
		if(top == stack.length-1) {
			return true;
		}
		return false;
		
		//혹은 return (top == stack.length-1);
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			System.out.println("Empty");
			return true;
		}
		return false;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("Full!");
			return;
		}
		stack[++top] = data;	//top을 증가시킨 후 넣어준다. 
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Empty!");
			return -1;
		}
		int poped = stack[top--];	//뺀 후 top을 감소시킨다. 
		return poped;
	}
	
}
