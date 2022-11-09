package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {
	static int[][] arr;
	static boolean[][] visited;
	static int result;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int col;
	static int row;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 0; test < testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			int baechu = Integer.parseInt(st.nextToken());
			result = 0;
			arr = new int[row][col];
			visited = new boolean[row][col];
			for (int i = 0; i < baechu; i++) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				int index2 = Integer.parseInt(st.nextToken());
				arr[index2][index] = 1;
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (arr[i][j] == 1 && visited[i][j] == false) {
						result++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
			System.out.println(result);
		}

	}

	static void dfs(int i, int j) {
		for (int temp = 0; temp < 4; temp++) {
			int x = i + dx[temp];
			int y = j + dy[temp];

			if (x < 0 || x >= row || y < 0 || y >= col || arr[x][y] == 0 || visited[x][y] == true) {
				continue;
			} else {
				visited[x][y] = true;
				dfs(x, y);
			}
		}
	}
}
