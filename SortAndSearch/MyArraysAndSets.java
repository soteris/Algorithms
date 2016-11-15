public class MyArraysAndSets{
	
	public static void main(String[] args){


	}

	/**
	* Check if pair that sums up to a number exists in a set
	*/
	private static boolean pairExists(Set<Integer> set, int sum){
		if(set == null || set.size() <= 1)
			return false;

		HashSet<Integer> hset = new HashSet<Integer>(set);
		int or_size = hset.size();

		//traverse set: for every number try to add sum - number. If we fail => true
		for(int num : hset){
			hset.add(sum - num);
			if(hset.size() == or_size){
				return true;
			}		
			else{
				set.remove(sum - num);
			}	
		}

		return false;
		
	}

	/**
	*
	* Find pair that sums up to a number in int aray
	*/
	private static boolean pairExists(int[] arr, int sum){
		if (arr == null || arr.length <= 1){
			return false;
		}

		//sort in nlogn
		Arrays.sort(arr);

		//linearly for every number search for the residue
		//get middle
		int low = 0;
		int high = arr.length - 1;

		for(low < high{
			if(arr[low] + arr[high] == sum){
				return true;
			}
			else if(arr[low] + arr[high] < sum){
				//underestimation: increase low
				low++;
			}
			else{
				//overestimation: decrease high
				high--;
			}
		}

		// if we reached this point => pair doesn't exist
		return false;

	}


	/**
	* Get intersection of elements using extra space
	*/
	private static int[] getIntersection(int[] arr1, int[] arr2){
		if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0){
			return null;
		}

		ArrayList<Integer> result = new ArrayList<Integer>();

		// put arr1 into hashmap
		HashMap<Integer, Integer> hmap1 = new HashMap<Integer, Integer>();

		for(int i = 0; i < arr1.length; i++){
			if(hmap1.containsKey(arr1[i])){
				int frequency = hmaps1.get(arr1[i]);
				hmaps1.put(arr1[i], ++frequency);
			}
			else{
				hmaps1.put(arr1[i], 1);
			}
		}

		//for every element in arr2, if present in hmap1, add it int result
		for(int el : arr2){
			if(hmaps1.containsKey(el)){
				result.add(el);
				int frequency = hmaps1.get(el);
				frequency--;

				if(frequency == 0){
					hmaps1.remove(el);
				}
				else{
					hmaps1.put(el, frequency);
				}
			}
		}

		//return result
		int[] res = new int[result.size()];
		int i = 0;
		for(int el : result){
			res[i] = el;
			i++;
		}

		return res;

	}

	/*
	** Write a function that left rotates arr[] of size n by d elements
	* Use extra space
	*/
	private static void rotateLeftES(int[] arr, int n, int d){

		if(arr == null || arr.length < d){
			return;
		}

		//store first d elements
		int[] tmp = new int[d];
		for(int i = 0; i < d; i++){
			tmp[i] = arr[i];
		}		

		//shift remaining n-d elements to the left
		for(int i = d; i < n; i++){
			arr[i-d] = arr[i];
		}

		//put stored items in the last d positions
		for(int i = 0; i < d; i++){
			arr[i+d+1] = tmp[i];
		}

		return;
	}

	private static int binarySearch(int[] arr, int start, int end, int key){
		//BC
		if(arr == null || start < end)
			return -1;

		//get middle index
		int middle = start + (end-start)/2;

		if(arr[middle] == key){
			return middle;
		}
		else if( key < arr[middle]){
			//go left
			return binarySearch(arr, start, middle-1, key);
		}
		else{
			//go right
			return binarySearch(arr, middle+1, end, key);
		}

	}

	/*
	** Search element in sorted and pivoted array
	*/
	private static int mountainSearch(int[] arr, int start, int end, int key){
		//bc
		if(arr == null){
			return -1;
		}

		//get middle
		int middle = start + (end - start) / 2;

		if(arr[middle] == key){
			return middle;
		}
		else if(arr[middle] < arr[start] && arr[middle] < arr[end]){
			//left is MS, right is BS
			if(key < arr[middle]){
				return mountainSearch(arr, start, middle -1, key);
			}
			else{
				return binarySearch(arr, middle + 1, end, key);
			}
			
		}
		else if(arr[middle] > arr[start] && arr[middle] > arr[end]){
			//left is BS, right is MS
			if(key < arr[middle]){
				return binarySearch(arr, start, middle -1, key);
			}
			else{
				return mountainSearch(arr, middle + 1, end, key);
			}
		}
		else{
			return -1;
		}
	
	}

	/**
	* Find int element in 2D MxN array. M: rows, N: columns
	* Elements are sorted in ascensing order per row and per column
	*/
	private static boolean findElementIn2D(int[][] arr, int M, int N, int key){

		int row = 0;
		int col = N = 1;

		while(row < M && col >= 0){

			if(arr[row][col] == key){
				return true;
			}
			else if(key < arr[row][col]){
				//decrese col
				col--;
			}
			else{
				//increase row
				row++;
			}
		}
	
		return false;
	}
}



































