package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2667 {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int count = 0;
	static int people;
	static int N;
	static List<Integer> li;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		li = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			StringBuffer sb = new StringBuffer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Character.getNumericValue(sb.charAt(j));
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && visited[i][j] == false) {
					count++;
					visited[i][j] = true;
					people = 1;
					dfs(i, j);
					li.add(people);
				}

			}

		}
		Collections.sort(li);
		System.out.println(count);
		
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}

	static void dfs(int i, int j) {

		for (int temp = 0; temp < 4; temp++) {
			int x = i + dx[temp];
			int y = j + dy[temp];
			if (x < 0 || x >= N || y < 0 || y >= N || arr[x][y] == 0 || visited[x][y] == true) {
				continue;
			} else {
				visited[x][y] = true;
				people++;
				dfs(x, y);
			}
		}

	}
}
