package org.kidding.programmers.stackandqueue;

public class StockPrice42584 {

	//[5, 8, 6, 2, 4, 1] -> [3, 1, 1, 2, 1, 0]
	static int[] prices = {1, 2, 3, 2, 3};
	
	public static void main(String[] args) {
		
		//예제가 없네 ㅎ.. 
		int[] answers = new int[prices.length];
		for(int i=0; i<prices.length-1; i++) {
			answers[i] = 1;
			boolean isMin = true;
			for(int j=i+1; j<prices.length; j++) {
				if(prices[i]<=prices[j]) {
					answers[i]++;
					continue;
				}else {
					isMin = false;
					break;
				}
			}
			
			if(isMin) {
				answers[i]--;
			}
		}
		
		answers[prices.length-1] = 0;
		
		
		for(int i=0; i<answers.length; i++) {
			System.out.println(answers[i]);
		}
		
		
	}
	
}

/*
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}
*/
