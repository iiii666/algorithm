package DFSorBFS;

public class target_number {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = { 1, 1, 1, 1, 1 };

		System.out.println(s.solution(arr, 3));

	}

}

class Solution {
	int answer;
	int target;
	int[] numbers;
	void dfs(int index, int sum) {
		// 1. 탈출조건
		if (index == numbers.length) {
			if (sum == target) {
				answer++;
				return;	
			}
		} 
		// 2. 수행동작
		dfs(index + 1, sum + numbers[index]);
		dfs(index + 1, sum - numbers[index]);
	}
	public int solution(int[] numbers, int target) {
		answer = 0;
		this.target = target;
		this.numbers = numbers;

		dfs(0, 0);

		return answer;
	}

	

}