package org.kidding.basic;

import java.util.Collections;
import java.util.PriorityQueue;

//일반적인 큐는 먼저 들어간 값이 가장 먼저 나옴.
//우선순위 큐는 우선순위를 부여하여 빼내는 것 -> 원리: https://hannom.tistory.com/36
//https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
//배열 X -> 우선순위 중간인 것이 삽입될 때, 우선순위가 낮은 것들을 한칸씩 밀어야 하기 때문 + 모든 값을 비교해야함. 
//연결리스트 X -> 모든 값을 비교해야하므로. 
//힙의 경우 삭제와 삽입 과정에서 부모와 자식 간의 비교만 하면 됨.
//->즉 이진트리 높이가 하나 증가할 때마다 저장 가능한 자료의 수는 2배 증가하고 비교연산 횟수는 1회 증가함. log2n의 복잡도.  
public class PriorityQueueEx {
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		PriorityQueue<Integer> priorityQueueDesc = new PriorityQueue<>(Collections.reverseOrder());
		
		//일반 Queue와 마찬가지로, offer, poll, peek 등 사용. 
		priorityQueue.offer(1);
		priorityQueue.offer(10);
		priorityQueue.offer(100);
		
		PriorityQueue<Edge> testEdge = new PriorityQueue<>();
		testEdge.offer(new Edge(1, 10));
		testEdge.offer(new Edge(2, 100));
		testEdge.offer(new Edge(3, 50));
		testEdge.offer(new Edge(4, 5));
		testEdge.offer(new Edge(5, 75));
		
		while(!testEdge.isEmpty()) {
			Edge edge = testEdge.poll();
			System.out.println("destination: " + edge.destination + ", weight: " + edge.weight);
		}
		
	}
}

//Custom Class
//Comparable Interface 상속한 Class 생성 후 compareTo 메서드를 통해  우선순위 구현
class Edge implements Comparable<Edge>{

	public int destination;
	public int weight; 
	
	public Edge(int destination, int weight) {
		this.destination = destination;
		this.weight = weight;
	}
	
//	public int getDestination() {
//		return this.destination;
//	}
//	public int getWeight() {
//		return this.weight;
//	}
	
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}
