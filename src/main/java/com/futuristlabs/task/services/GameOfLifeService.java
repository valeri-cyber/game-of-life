package com.futuristlabs.task.services;

import org.springframework.stereotype.Service;

@Service
public class GameOfLifeService {
	
	public int[][] getLife(int[][] arr, int gen){
		for (int g=1; g<=gen; g++) {
			int[][] tempArr = new int[arr.length][arr[0].length];
			for (int i=0; i<tempArr.length; i++) {
				for (int j=0; j<tempArr[i].length; j++) {
					if (arr[i].length == j) break; //in case this row of arr[] is shorter than tempArr[]'s row
					int countLife = countLife(arr, i, j);
					if (arr[i][j] == 0 && countLife == 3) {
						tempArr[i][j] = 1; continue;
					} else if (arr[i][j] == 0 && countLife != 3){
						tempArr[i][j] = 0; continue;
					}
					
					if (arr[i][j] == 1) {
						switch (countLife) {
						case 1: tempArr[i][j] = 0; break;
						case 2:
						case 3: tempArr[i][j] = 1; break;
						case 4:
						case 5:
						case 6:
						case 7:
						case 8: tempArr[i][j] = 0; break;
						default: tempArr[i][j] = 0; break;
						}
					}
				}
				
			}
			
			arr = tempArr;
		}
		return arr;
	}
	
	private int countLife(int[][] arr, int row, int col) {
		int count = 0;
		
		if (row == 0 && col == 0) {
			if (arr[0][1] == 1) count++;
			if (arr[1][1] == 1) count++;
			if (arr[1][0] == 1) count++;
			return count;
		}
		
		if (row == arr.length-1 && col == arr[row].length-1) {
			if (arr[row-1][col-1] == 1) count++;
			if (arr[row-1][col] == 1) count++;
			if (arr[row][col-1] == 1) count++;
			return count;
		}
		
		if (row == arr.length-1 && col == 0) {
			if (arr[row-1][col] == 1) count++;
			if (arr[row-1][col+1] == 1) count++;
			if (arr[row][col+1] == 1) count++;
			return count;
		}
		
		if (row == 0 && col == arr[row].length-1) {
			if (arr[row][col-1] == 1) count++;
			if (arr[row+1][col-1] == 1) count++;
			if (arr[row+1][col] == 1) count++;
			return count;
		}
		
		if (row == 0) {
			if (arr[0][col-1] == 1) count++;
			if (arr[1][col-1] == 1) count++;
			if (arr[1][col] == 1) count++;
			if (arr[1][col+1] == 1) count++;
			if (arr[0][col+1] == 1) count++;
			return count;
		}
		
		if (row == arr.length-1) {
			if (arr[row][col-1] == 1) count++;
			if (arr[row-1][col-1] == 1) count++;
			if (arr[row-1][col] == 1) count++;
			if (arr[row-1][col+1] == 1) count++;
			if (arr[row][col+1] == 1) count++;
			return count;
		}
		
		if (col == 0) {
			if (arr[row-1][0] == 1) count++;
			if (arr[row-1][1] == 1) count++;
			if (arr[row][1] == 1) count++;
			if (arr[row+1][1] == 1) count++;
			if (arr[row+1][0] == 1) count++;
			return count;
		}
		
		if (col == arr[row].length-1) {
			if (arr[row-1][col-1] == 1) count++;
			if (arr[row-1][col] == 1) count++;
			if (arr[row][col-1] == 1) count++;
			if (arr[row+1][col-1] == 1) count++;
			if (arr[row+1][col] == 1) count++;
			return count;
		}
		
		if (arr[row-1][col-1] == 1) count++;
		if (arr[row-1][col] == 1) count++;
		if (arr[row-1][col+1] == 1) count++;
		if (arr[row][col-1] == 1) count++;
		if (arr[row][col+1] == 1) count++;
		if (arr[row+1][col-1] == 1) count++;
		if (arr[row+1][col] == 1) count++;
		if (arr[row+1][col+1] == 1) count++;
		return count;
	}

}
