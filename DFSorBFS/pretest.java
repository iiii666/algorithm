package DFSorBFS;
import java.io.*;
import java.util.*;
import java.lang.*;
public class pretest {
	static boolean[][] visited;
	static List<Integer> li;
	static int count=0;
	static int result=0;
	static int[] dx ={0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int lines;
	static int[][] area;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
				StringTokenizer st ;
				visited = new boolean[lines][lines];
				li = new ArrayList<>();
        for(int i=0; i<lines; i++){
						st = new StringTokenizer(br.readLine());
						for(int j=0;j<lines;j++){
							area[i][j] = Integer.parseInt(st.nextToken());
						}
        }
		for(int i =0;i<lines;i++){
			for(int j =0;j<lines;j++){
				if((area[i][j] == 1) && (visited[i][j] ==false)){
					visited[i][j] =true;
					result++;
					dfs(i,j);
					li.add(count);
					count =0;
				}
			}
		}
		System.out.println(result);
		Collections.sort(li);
		for(int i =0;i<li.size();i++){
			System.out.print(li.get(i));
			System.out.print(" ");
		}
		
	}
	static void dfs(int i,int j){
		count++;
		for(int temp=0;temp<4;temp++){
			int x = i +dx[temp];
			int y = j +dy[temp];
			if(x<0||x>=lines||y<0||y>=lines||area[x][y]==0||visited[x][y]==true){
				continue;
			}else{
				visited[x][y] =true;
				dfs(x,y);
			}
		}
	}
}