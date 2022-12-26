package DFSorBFS;
import java.util.*;
public class p42839 {
	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.println(s.solution("011"));
		System.out.println(s.solution("17"));
		
	}
	static class Solution {
	    static HashSet<Integer> set = new HashSet<Integer>();
	    
	    static boolean[] visited;
	    public int solution(String numbers) {
	        int answer = 0;
	        String[] arr = numbers.split("");
	        String temp = "";
	        visited = new boolean[arr.length];
	        dfs(arr, 0, temp);
	        answer = set.size();
	        return answer;
	    }
	    static void dfs(String[] arr, int depth, String temp){
	        if(depth == arr.length){
	            int number = Integer.parseInt(temp);
	            if(isPrime(number)){
	                set.add(number);
	                return;
	            }else{
	                return;
	            }
	        }else{
	            for(int i =0;i<arr.length;i++){
	                if(!visited[i]){
	                    visited[i] = true;
	                    dfs(arr, depth+1, temp + arr[i]);
	                    visited[i] = false;
	                }
	            }
	        }
	        if(!temp.equals("")){
	            int number = Integer.parseInt(temp);
	         if(isPrime(number)){
	                set.add(number);
	            }
	        }
	        
	    }
	    static boolean isPrime(int num){
	        
	        for(int i =2;i<num;i++){
	            if(num % i ==0){
	                return false;
	            }
	        }
	        if(num!= 1 && num!=0 ){
	            return true;    
	        }
	        return false;
	        
	    }
	}
}
