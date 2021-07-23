package org.kidding.javatest;

/*
Java Data Type 
ㄴ Primitive Type
    ㄴ Boolean Type(boolean)
    ㄴ Numeric Type
        ㄴ Integral Type
            ㄴ Integer Type(short, int, long)
            ㄴ Floating Point Type(float, double)
        ㄴ Character Type(char)
ㄴ Reference Type
    ㄴ Class Type
    ㄴ Interface Type
    ㄴ Array Type
    ㄴ Enum Type
    ㄴ etc.
 */
public class DataType {

	//int: ~2,147,483,647(2^31-1) 즉, 21억까지 
	//long: ~9,223,372,036,854,775,807(2^63-1) ㅎ..
	//Big Integer는 일반적인 오퍼레이터 연산자 불가능. 
	//float와 double은.. 걍 double 쓰자.. 
	
	public static void main(String[] args) {
		long a = 300;
		long b = 400;
		
		int c = 2147483646;
		int d = 400000003;
		
		System.out.println(a+b);
		System.out.println(c+d);
	}
}
