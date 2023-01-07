package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//queue 가 null && (N, M) 이 아니면 result - 1
//(N, M) 이면 return;
public class p2178 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<int[]> q = new LinkedList<>();
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		visited[0][0] = true;
		bfs(0, 0);

	}

	static void bfs(int i, int j) {
		q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int temp[] = q.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			for (int search = 0; search < 4; search++) {
				int x = temp_x + dx[search];
				int y = temp_y + dy[search];
				if (x < 0 || y < 0 || x >= N || y >= M || arr[x][y] == 0 || visited[x][y] == true) {
					continue;
				}else {
					q.add(new int[] {x,y});
					q.poll();
				}
			}
			
		}
	}
}
