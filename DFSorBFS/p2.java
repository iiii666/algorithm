package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.sound.midi.SysexMessage;

public class p2 {
	static int N;
	static int C;
	static int[] arr;
	static int maxWeight = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, 0);
		System.out.println(maxWeight);
	}

	public static void dfs(int depth, int sum) {
		if (C < sum) {
			return;
		}
		if (depth == N) {
			if (maxWeight < sum) {
				maxWeight = sum;
			}
		} else {
			dfs(depth + 1, sum + arr[depth]);
			dfs(depth + 1, sum);
		}

	}

}
