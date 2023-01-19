package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2468 {
	/* 안전 영역 s1 
	 * bfs 랑 bfs 비슷한 느낌으로 구역이 몇개인지
	 * */
	static int[][] arr;
	static int result = 1;
	static Queue<int[]> q;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int maxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if (maxHeight < temp)
					maxHeight = temp;// 최대 높이구하기
			}
		}
		int safeZoneMax = 1;// 최대 안전구역 (다안잠길 때 1이기때문에 고려)

		for (int i = 1; i < maxHeight; i++) {// 강수량 별 bfs
			q = new LinkedList<>();
			visited = new boolean[N][N];
			int safeZone = 0;// 강수량 별 안전 구역
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (arr[j][k] > i && !visited[j][k]) {// 강수량 보다 높은 위치 이고, 방문 안한곳
						safeZone++;
						q.add(new int[] { j, k });
						visited[j][k] = true;					
						bfs(i);
						
					}
				}
			}

			if (safeZoneMax < safeZone) {
				safeZoneMax = safeZone;
			}
		}
		System.out.println(safeZoneMax);
	}

	public static void bfs(int rain) {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || arr[x][y] <= rain) {
					continue;
				}
				visited[x][y] = true;
				q.add(new int[] {x,y});
				
				
			}
		}
	}
}
