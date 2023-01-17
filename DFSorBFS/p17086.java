package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17086 {
	/*
	 * 아기상어 s2 유형 : 출발지가 여러개인 bfs
	 * 
	 */
	static int[][] arr;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int N;
	static int M;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;
	static int count = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {

					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		search();
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maxValue < arr[i][j]) {
					maxValue = arr[i][j];
				}
			}

		}
		System.out.println(maxValue - 1);
	}

	public static void search() {

		while (!q.isEmpty()) {
			int size = q.size();// size 빼주는거 중요함
			for (int i = 0; i < size; i++) {// 출발지 여러개
				int[] now = q.poll();
				for (int temp = 0; temp < 8; temp++) {

					int x = now[0] + dx[temp];
					int y = now[1] + dy[temp];
					if (x < 0 || x >= N || y < 0 || y >= M || visited[x][y] || arr[x][y] == 1) {
						continue;
					}
					visited[x][y] = true;
					arr[x][y] = count;

					q.add(new int[] { x, y });
				}
			}
			count++;
		}

	}

}
