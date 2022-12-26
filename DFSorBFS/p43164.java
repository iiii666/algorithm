package DFSorBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p43164 {
	public static void main(String[] args) {
		Solution s = new Solution();
		// new int[][]{ new int[]{"ICN", "JFK"}, new int[]{"HND", "IAD"}, new int[]{"JFK", "HND"} }
//		[ ["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"] ]
//		String[][] tickets= new String[][]{ new String[]{"ICN", "JFK"}, new String[]{"HND", "IAD"}, new String[]{"JFK", "HND"} };
//		
		String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
		
		System.out.println(Arrays.toString(s.solution(tickets)));
	}
	static class Solution {
	    boolean[] visited;
	    ArrayList<String> allRoute; 
	    
	    public String[] solution(String[][] tickets) {
	        String[] answer = {};
	        int cnt = 0;
	        visited = new boolean[tickets.length];
	        allRoute = new ArrayList<>();
	        
	        dfs("ICN", "ICN", tickets, cnt);
	        
	        Collections.sort(allRoute);
	        answer = allRoute.get(0).split(" ");
	        
	        return answer;
	    }
	    
	    public void dfs(String start, String route, String[][] tickets, int cnt){
	        System.out.println(route);
	    	if(cnt == tickets.length){
	        	
	            allRoute.add(route);
	            return;
	        }
	
	        for(int i=0; i<tickets.length; i++){
	            if(start.equals(tickets[i][0]) && !visited[i]){
	                visited[i] = true;
	                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);
	                visited[i] = false;
	            }
	        }
	    }
	    
	}
}
