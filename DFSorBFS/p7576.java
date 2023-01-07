package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p7576 {
	/* 토마토 */
	static int[][] arr;
	static int M;
	static int N;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	static List<int[]> li = new ArrayList<>();
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result = 0;
	static List<int[]> Position = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());

				arr[i][j] = temp;
			}
		}
		bfs();
		for(int i =0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					result =-1;
					break;
				}
				
			}
		}
		System.out.println(result);
	}

	public static void bfs() {
		int flag = 0;
		while (!q.isEmpty() || flag == 0) {

			if (flag == 0) {//처음 bfs 들어갈때
			
				Position = tomato(arr);
				
				for (int i = 0; i < Position.size(); i++) {
					
					q.add(Position.get(i));
				}
			}
			flag++;
			int size = q.size();
			List<int[]> tmtPosition = new ArrayList<>();
			for (int i = 0; i < size; i++) {// 출발지가 여러개
				int[] temp = q.poll();// 한군데씩
				for (int search = 0; search < 4; search++) {
					int x = temp[0] + dx[search];
					int y = temp[1] + dy[search];

					if (x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == -1 || arr[x][y] == 1
							|| visited[x][y] == true) {
						continue;

					} else {
						arr[x][y] = 1;	
						visited[x][y] = true;
						tmtPosition.add(new int[] { x, y });
					}
				}
			}
//			Position = tomato(arr);
			for (int j = 0; j < tmtPosition.size(); j++) {
				q.add(tmtPosition.get(j));
			}
			
			if (q.isEmpty()) {
				
			} else {
				result++;
			}

		}

		return;
	}

	public static List<int[]> tomato(int[][] arr) {//어디에 전염가능한 토마토가 있는지
		List<int[]> tmtPosition = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					tmtPosition.add(new int[] { i, j });
				}
			}
		}
		return tmtPosition;
	}
}
