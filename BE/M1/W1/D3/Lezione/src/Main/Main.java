package Main;
import D3.epicode.util.*;

public class Main {

	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 2, 3, 4, 5};
		MyArray myArr = new MyArray(arr);
		
		myArr.push(6);
		
		myArr.print();
		
		myArr.shift(0);
		
		myArr.print();
		
		myArr.pop();
		
		myArr.print();
		
		myArr.unshift();
		
		myArr.print();
		
	}

}
