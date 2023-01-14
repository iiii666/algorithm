package DFSorBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p6603 {
	/* 로또 s2 */
	static boolean[] visited;
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			List<Integer> li = new ArrayList<>();
			visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				li.add(Integer.parseInt(st.nextToken()));
			}
			dfs(li, 0);
			System.out.println();
		}
	}

	public static void dfs(List<Integer> li, int depth) {
		if (depth == 6) {
			if(isAsc(result)) {
				for (int j = 0; j < result.size(); j++) {
					if(j ==result.size()-1) {
						System.out.print(result.get(j));
					}else {
						System.out.print(result.get(j)+" ");
					}
				}
				System.out.println();
			}
			
			return;
		}
		for (int i = 0; i < li.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				result.add(li.get(i));
				dfs(li, depth + 1);
				result.remove(result.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static boolean isAsc(List<Integer> result) {
		for (int i = 0; i < result.size()-1; i++) {
			if(result.get(i)>=result.get(i+1)) {
				return false;
			}
		}
		return true;
	}
}
