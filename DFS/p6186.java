package DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6186 {
	static int result;
	static String[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int row;
	static int col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		arr = new String[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Character.toString(sb.charAt(j));
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j].equals("#") && visited[i][j] == false) {
					result++;
					visited[i][j] = true;
					DFS(i, j);
				}
			}
		}
		System.out.println(result);
	}

	private static void DFS(int i, int j) {

		for (int temp = 0; temp < 4; temp++) {
			int x = i + dx[temp];
			int y = j + dy[temp];

			if (x < 0 || x >= row || y < 0 || y >= col || arr[x][y].equals(".") || visited[x][y] == true) {
				continue;
			} else {
				visited[x][y] = true;
				DFS(x, y);
			}
		}

	}
}
