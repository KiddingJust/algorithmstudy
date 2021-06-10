package org.kidding.programmers.hash;

public class PhoneBook42577_nothash {

	
	static String[] phone_book = {"12","123","1235","567","88"};
	
	public static boolean main(String[] args) {
		
		for(int i=0; i<phone_book.length; i++) {
			for(int j=i+1; j<phone_book.length; j++) {
				if(phone_book[i].startsWith(phone_book[j])) {return false;}
				if(phone_book[j].startsWith(phone_book[i])) {return false;}
			}
		}
		
		return true;
	}
	
}
