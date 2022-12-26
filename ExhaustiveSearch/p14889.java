package ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p14889 {
	static int[][] arr;
	static boolean[] visited;
	static List<Integer> li = new ArrayList<>();
	static List<Integer> li2 = new ArrayList<>();
	static List<Integer> result = new ArrayList<>();

	static int i = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(N, 0,0);
		Collections.sort(result);
		
		System.out.println(result.get(0));
	}

	static void dfs(int N, int depth, int idx) {

		if (depth == N / 2) {

			score(N, visited);
			for(int i =0;i<N;i++) {
				System.out.print(visited[i]);
			}
			System.out.println();
			return;
		} else {
			for (int i =idx; i < N; i++) {//경우를 잘 따지고 순열이 아닌 조합일 땐 i = idx 로 하고 가지치기 수행
				// 해야 시간을 절약한다. 
				// 모든 경우를 따져야할 땐 0 이지만 , 0011,1100 이 경우가 같은 경우라고 판단되면 idx 추가 해서 가지치기

				if (!visited[i]) {
					visited[i] = true;
					dfs(N, depth + 1,i+1);
					visited[i] = false;
				}

			}

		}
	}

	static void score(int N, boolean[] visited) {
		int start=0;
		int link=0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i+1; j < N; j++) {
				if(visited[i] ==true && visited[j] ==true) {
					 start += arr[i][j] + arr[j][i];
				}else if(visited[i]==false && visited[j] ==false) {
					 link +=  arr[i][j] + arr[j][i];
				}
			}
		}
		
		int val = Math.abs(start-link);
		if(val ==0) {
			System.out.println(val);
			//System.exit(0);
		}
		result.add(val);
	}

}
