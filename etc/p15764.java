package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p15764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] lineup = new int[N+1];
		int[] position = new int[N+1];
		boolean[] check = new boolean[N+1];
		List<Integer> hieracy = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			hieracy.add(Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int cownum = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			lineup[index] = cownum;
			position[cownum] = index;
			check[cownum] = true;
		}
		
		if(hieracy.contains(1)) {
			for(int i =1;i<lineup.length;i++) {
				if(hieracy.isEmpty()) {
					break;
				}if(lineup[i]==0) {
					int temp = hieracy.get(0);
					if(!check[temp]) {
						lineup[i] = temp;
						check[temp]=true;
						hieracy.remove(0);
					}else {
						hieracy.remove(0);
						i= position[temp];
					}
				}
			}
		}else {
			for(int i = N;i>0;i--) {
				if(hieracy.isEmpty()) {
					break;
				}
				if(lineup[i]==0) {
					int temp = hieracy.get(hieracy.size() -1);
					if(!check[temp]) {
						lineup[i] =temp;
						check[temp] =true;
						hieracy.remove(hieracy.size()-1);			
						}else {
							hieracy.remove(hieracy.size()-1);
							i=position[temp];
						}
				}
			}
		}
		 if(check[1]) {
	         for(int i=1; i<lineup.length; i++) {
	            if(lineup[i] == 1) {
	               System.out.println(i);
	               break;
	            }
	         }
	      }else {
	         for(int i=1; i<lineup.length; i++) {
	            if(lineup[i] == 0) {
	               System.out.println(i);
	               break;
	            }
	         }
	      }

	}
}
