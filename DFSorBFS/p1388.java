package DFSorBFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p1388 {
	static String[][] room;
	static int N;
	static int M;
	static int count;
	static int count2;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new String[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Character.toString(sb.charAt(j));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				if(room[i][j].equals("-")){
					DFS(i, j, true);
				}
				else DFS(i, j, false);
				count++;
			}
		}
		
		System.out.println(count);
		
	}

	private static void DFS(int i, int j, boolean row) {
		visited[i][j] = true;
		if (row) {
			j++;
			if (j < M && room[i][j].equals("-")) {
				DFS(i,j,true);
				
			}
		} else {
			i++;
			if(i<N && room[i][j].equals("|")) {
				DFS(i,j, false);
			}
		}
	}
}
