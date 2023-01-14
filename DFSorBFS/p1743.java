package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1743 {
	/* 음식물 피하기 s1 */
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result = 0;
	static int realresult = 0;
	static int N;
	static int M;
	static boolean[][] visited;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		int i = 0;
		while (i < k) {
			i++;
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[r - 1][c - 1] = 1;
		}

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				if (!visited[row][col] && arr[row][col] == 1) {

					visited[row][col] = true;
					result++;
					dfs(row, col);
					if (realresult < result) {
						realresult = result;
						result = 0;
					} else {
						result = 0;
					}
				}
			}
		}
		System.out.println(realresult);
	}

	public static void dfs(int row, int col) {

		for (int temp = 0; temp < 4; temp++) {
			int x = row + dx[temp];
			int y = col + dy[temp];
			if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || arr[x][y] == 0) {
				continue;
			}
			visited[x][y] = true;
			result++;
			dfs(x, y);
		}
	}
}
