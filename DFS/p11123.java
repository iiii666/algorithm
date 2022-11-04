package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11123 {
	static String[][] arr;
	static int result;
	static boolean[][] visited;
	static int row;
	static int col;
	
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < num; i++) {
			int sheep = 0;
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			arr = new String[row][col];
			visited = new boolean[row][col];
			for (int j = 0; j < row; j++) {
				StringBuffer sb = new StringBuffer(br.readLine());
				for (int k = 0; k < col; k++) {
					arr[j][k] = Character.toString(sb.charAt(k));

				}
			}
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (arr[j][k].equals("#") && visited[j][k] == false) {
						sheep++;
						visited[j][k] = true;
						dfs(j, k);
					}

				}
			}
			System.out.println(sheep);
		}

	}

	private static void dfs(int j, int k) {

		for (int temp = 0; temp < 4; temp++) {
			int x = j + dx[temp];
			int y = k + dy[temp];
			if (x < 0 || x >= row || y < 0 || y >= col || arr[x][y].equals(".") || visited[x][y] == true) {
				continue;
			} else {
				visited[x][y] = true;
				dfs(x, y);
			}
		}
	}

}
