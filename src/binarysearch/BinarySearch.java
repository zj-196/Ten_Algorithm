package binarysearch;

public class BinarySearch {

	static int num = 0;
	
	public static void main(String[] args) {
		int[] arr = {1,3,8,10,11,67,100}; 
		int i = binarySearch(arr,1);
		if(i>=0) {
			System.out.println("查找次数为："+num+"次");
			System.out.println("已找到，索引为："+i);
		}else {
			System.out.println("查找次数为："+num+"次");
			System.out.println("未找到");
		}
	}
	
	private static int binarySearch(int[] arr,int targetNum) {
		int left = 0;
		int right = arr.length-1;
		int mid;
		while(left<=right) {
			num++;
			mid = (left+right)/2;
			if(arr[mid]==targetNum) {
				return mid;
			}else if(arr[mid]<targetNum) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
