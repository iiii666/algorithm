package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4963 {
	static boolean[][] visited;
	static int[][] arr;
	static int dx[] = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int dy[] = { -1, 1, 0, 0, -1, 1, -1, 1 };// 8 방향 탐색
	static int island = 0;
	static int w;
	static int h;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) {
				break;
			}
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {// 섬 지도 생성
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {// 방문 배열 false 초기화
				for (int j = 0; j < w; j++) {
					visited[i][j] = false;
				}
			}
			for (int i = 0; i < h; i++) {// 하나씩 탐색
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1 && visited[i][j] == false) {// 탐색조건과, 방문 여부 체크 후 dfs
						visited[i][j] = true;
						island++;
						DFS(i, j);

					}

				}
			}
			System.out.println(island);
			island = 0;
		}

	}

	static void DFS(int row, int col) {

		for (int i = 0; i < 8; i++) {// 8방향 탐색
			int nx = row + dx[i];
			int ny = col + dy[i];
			if (nx < 0 || nx >= h || ny < 0 || ny >= w || arr[nx][ny] == 0 || visited[nx][ny] == true) {
				continue;// 8방향이 배열사이즈 안에 있는지 확인
			}
			visited[nx][ny] = true;
			DFS(nx, ny);
		}

		return;
	}
}
