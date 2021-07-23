package org.kidding.javatest;

//생성자: new 연산자 통해 객체를 생성할 때 반드시 호출이 되고 
//      제일 먼저 실행되는 일종의 method. 
//매개변수 받아서 new로 생성하기 위해 생성자 쓰는 경우 많음. 아래가 훨씬 간편. 
//https://onsil-thegreenhouse.github.io/programming/java/2017/10/31/java_tutorial_1-2/
//좀 더 공부해보기 
public class Constructor {
	public static void main(String[] args) {
		
		Student student = new Student();
		student.name = "gaik";
		student.age = 30;
		System.out.println(student.name + ": " + student.age);
		
		student.getAge();
		System.out.println(student.name + ": " + student.age);
		
		student.name = "goun";
		System.out.println(student.name + ": " + student.age);
		
		StudentCons studentCons = new StudentCons("가익", 40);
		System.out.println(studentCons.name + ": " + studentCons.age);
	}
}

class Student {
	String name;
	int age;
	
	public void getAge() {
		age += 10;
	}	
}

class StudentCons {
	 
	String name;
	int age;

	//생성자. 
	StudentCons(String name, int age){
		this.name = name;
		this.age = age;
	}
}