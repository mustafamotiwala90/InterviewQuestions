package Solved;

import java.util.Arrays;

public class NQueens {
	/**
	 * N Queens problems
	 */
	
	static int[] board=null;
	static int counter = 0;
	
	
	public static void main(String[] args) {
		Nqueens(8);
	}
	
	public static void Nqueens(int N){
		board = new int[N];
		
		//init
		for(int i=0;i<N;i++)
				board[i]=-1;
		
		backTracking(0,N);
	}
	
	public static void backTracking(int rowNo,int N){
		if(rowNo == N){
			System.out.println(++counter  + " Solution : " + Arrays.toString(board));
			return;  
		}
		
		for (int i = 0; i < N; i++) {
			if (check(rowNo, i, N)) {
				board[rowNo] = i;
				backTracking(rowNo + 1, N);
				//return; //uncomment this to just have one solution;
			}
		}
		return;
	}
	
	
	public static boolean check(int rowNo, int i, int n){
		for (int j = 0; j < rowNo; j++) {
			if (board[j] == i || Math.abs(board[j] - i) == Math.abs(rowNo - j))
				return false;
		}
		return true;
	}
}
