package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
	/* 나이트의 이동 */
	static boolean[][] visited;
	static Queue<int[]> q;
	static int result;
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[][] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {// test Case반복
			int l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());// 입력
			visited = new boolean[l][l];
			result = 0;
			q = new LinkedList<>();
			distance = new int[l][l];
			distance[start_x][start_y] = 0;
			q.add(new int[] { start_x, start_y });
			visited[start_x][start_y] = true;
			bfs(l, end_x, end_y);
			System.out.println(result);
		}

	}

	public static void bfs(int size, int end_x, int end_y) {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 8; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (x < 0 || x >= size || y < 0 || y >= size || visited[x][y]) {
					continue;
				} else {
					distance[x][y] = distance[now[0]][now[1]] + 1;//
					if (x == end_x && y == end_y) {
						result = distance[x][y];
						return;
					}
					visited[x][y] = true;
					q.add(new int[] { x, y });
				}
			}

		}
	}
}
