package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p4 {
	static Integer[] arr;
	static int M;
	static int N;
	static int result = Integer.MAX_VALUE;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		M = Integer.parseInt(br.readLine());
		dfs(0, 0);// 깊이(개수), sum
		System.out.println(result);
	}

	public static void dfs(int depth, int sum) {

		if (sum > M) {
			return;
		}
		if(depth>=result) {
			return;
		}
		if (sum == M) {
			if (result > depth) {
				result = depth;
				return;
			}

		} else {
			for (int i = 0; i < arr.length; i++) {
				dfs(depth + 1, sum + arr[i]);// 넣고

			}
		}

	}
}
