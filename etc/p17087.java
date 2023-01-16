package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p17087 {
	/* 숨바꼭질 6 s2
	 * 유클리드 호제법
	 * */
	static List<Integer> minus; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			li.add(Integer.parseInt(st.nextToken()));
		}

		 minus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			minus.add(Math.abs(S-li.get(i)));
			
		}
		int gcd = minus.get(0);
		for(int i =1;i<minus.size();i++) {
			gcd = GCD(gcd,minus.get(i));
		}
		System.out.println(gcd);
		
	}
	public static int GCD(int n1, int n2) {
		if(n2 == 0) {
			return n1;
		}
		else return GCD(n2, n1%n2);
	}
}
