package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p14503 {
	/* 로봇 청소기 g5
	 * bfs 인데 전체적으로 bfs하는게아니라 동작이 정해져있어서 전체 탐색이 안되는 유형
	 * 
	 * 조건이 너무 복잡해서 코드가 너무 김
	 * */
	static int[][] arr;
	static boolean[][] walls;
	static Queue<int[]> q = new LinkedList<>();
	static int result = 1;
	static boolean[][] clean;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		walls = new boolean[N][M]; // 벽
		clean = new boolean[N][M]; // 청소 여부
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i][j] = temp;
				if (temp == 1) {// 벽 설정
					walls[i][j] = true;
					clean[i][j] = true;
				}
			}
		}

		q.add(new int[] { r, c });
		clean[r][c] = true;
		bfs(r, c, d);
		System.out.println(result);
	}

	public static void bfs(int r, int c, int d) {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = 0;
				int y = 0;
				if (d == 0) {
					x = now[0] + dx[0];
					y = now[1] + dy[0];

					if (x < 0 || x >= N || y < 0 || y >= M || clean[x][y]) {
						d = 3;
						if (i == 3) {
							int backx = now[0];
							int backy = now[1]+ 1;
							if ((backx >= 0 && backy < M) && walls[backx][backy]) {
								return;
							}else if((backx >= 0 && backy < M) && !walls[backx][backy]) {
								q.add(new int[] {backx,backy});
							}
						}
						continue;
					}
					q.add(new int[] { x, y });
					d = 3;
					clean[x][y] = true;
					result++;
					break;
				}
				if (d == 1) {
					x = now[0] + dx[1];
					y = now[1] + dy[1];

					if (x < 0 || x >= N || y < 0 || y >= M || clean[x][y]) {
						d = 0;
						if (i == 3) {
							int backx = now[0]+1 ;
							int backy = now[1];
							if ((backx >= 0 && backy < M) && walls[backx][backy]) {
								return;
							}else if((backx >= 0 && backy < M) && !walls[backx][backy]) {
								q.add(new int[] {backx,backy});
							}
						}
						continue;
					}
					q.add(new int[] { x, y });
					d = 0;
					clean[x][y] = true;
					result++;
					break;
				}
				if (d == 2) {
					x = now[0] + dx[2];
					y = now[1] + dy[2];

					if (x < 0 || x >= N || y < 0 || y >= M || clean[x][y]) {
						d = 1;
						if (i == 3) {
							int backx = now[0];
							int backy = now[1]-1 ;
							if ((backx >= 0 && backy < M) && walls[backx][backy]) {
								
								return;
							}else if((backx >= 0 && backy < M) && !walls[backx][backy]) {
								q.add(new int[] {backx,backy});
							}
						}
						continue;
					}
					q.add(new int[] { x, y });
					clean[x][y] = true;
					d = 1;
					result++;
					break;
				}
				if (d == 3) {
					x = now[0] + dx[3];
					y = now[1] + dy[3];

					if (x < 0 || x >= N || y < 0 || y >= M || clean[x][y]) {
						d = 2;
						if (i == 3) {
							int backx = now[0]-1 ;
							int backy = now[1];
							if ((backx >= 0 && backy < M) && walls[backx][backy]) {
								return;
							}else if((backx >= 0 && backy < M) && !walls[backx][backy]) {
								q.add(new int[] {backx,backy});
							}
						}
						continue;
					}
					q.add(new int[] { x, y });
					clean[x][y] = true;
					d = 2;
					result++;
					break;
				}

			}
		}
	}
}
