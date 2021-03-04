package day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinDemo {
	public static void main(String[] args) {
		MyStringArray strArr = new MyStringArray();
//		int count = 0;
//		for(String s : strArr.arr) {
//			if(s.equals("Foo")) {
//				count++;
//			}
//		}
//		System.out.println("Number of Foos are: " + count);
		
		// Breaks the task into smaller subtasks and executes a computation
		ForkJoinPool fjPool = ForkJoinPool.commonPool();
		
		Task task1 = new Task(0, 3, strArr.arr, "Foo");
		Task task2 = new Task(3, 6, strArr.arr, "Foo");
		Task task3 = new Task(6, 8, strArr.arr, "Foo");
		Task task4 = new Task(8, 10, strArr.arr, "Foo");
		
		int result1 = fjPool.invoke(task1);
		int result2 = fjPool.invoke(task2);
		int result3 = fjPool.invoke(task3);
		int result4 = fjPool.invoke(task4);
		
		int finalResult = result1 + result2 + result3 + result4;
		
		System.out.println("Number of Foo's are: " + finalResult);
	}
}

class Task extends RecursiveTask<Integer> {
	int startPosition, endPosition;
	String array[], searchElement;
	public Task(int startPosition, int endPosition, String array[], String searchElement) {
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.array = array;
		this.searchElement = searchElement;
	}
	// Method to count number of occurrences of search element
	@Override
	protected Integer compute() {
		int count = 0;
		for(int i = startPosition; i < endPosition; i++) {
			if(array[i].equalsIgnoreCase(searchElement)) {
				count++;
			}
		}
		return count;
	}
}

class MyStringArray {
	String arr[] = {
			"Foo",
			"Bar",
			"Baz",
			"Foo",
			"Bat",
			"Quid",
			"Foo",
			"Foo",
			"Quuz",
			"Qux"
	};
}
