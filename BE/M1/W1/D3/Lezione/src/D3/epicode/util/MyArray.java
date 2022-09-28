package D3.epicode.util;

import java.util.Arrays;

public class MyArray {

	public int[] arr;
	int length;

	public MyArray(int[] array) { // costruttore
		this.arr = array;
	}

	public void print() {
		System.out.println(Arrays.toString(this.arr));
	}
	
	//

	public void push(int value) {

		int[] tempArr = new int[this.arr.length + 1];

		for (int i = 0; i < tempArr.length; i++) {

			if (i == tempArr.length - 1) {
				tempArr[i] = value;
				break;
			}

			tempArr[i] = this.arr[i];

		}

		this.arr = tempArr;
	}
	
	//

	public void shift(int value) {

		int[] tempArr = new int[this.arr.length + 1];
		
		tempArr[0] = value;
		
		for (int i = 1; i < tempArr.length; i++) {

			tempArr[i] = this.arr[i - 1];

		}

		this.arr = tempArr;
	}
	
	public int pop() {
		int last = this.arr[this.arr.length -1];
		
		int[] tempArr = new int[this.arr.length - 1];
		
		for(int i = 0; i< tempArr.length; i++) {
			tempArr[i] = this.arr[i];
		}
		this.arr = tempArr;
		return last;
		
	}
	
	
	public int unshift() {
		int first = this.arr[0];
		
		int[] tempArr = new int[this.arr.length - 1];
		
		for(int i = 0; i< tempArr.length; i++) {
			tempArr[i] = this.arr[i + 1];
		}
		this.arr = tempArr;
		return first;
		
	}
}
