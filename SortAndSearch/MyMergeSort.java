public class MyMergeSort{

	public static void main(String[] args){

	}	


	/**
	* TODO: Test
	*/
	private int[] mergeSort(int[] arr){
		//BC
		if(arr.length == 0 || arr.length == 1){
			return arr;
		}

		//split in half
		int middle = arr.length / 2;

		int[] left = new int[middle];
		for(int i = 0; i < middle; i++){
			left[i] = arr[i];
		}


		int[] right = new int[arr.length - middle];
		for(int i = middle; i < arr.length; i++){
			right[i - middle] = arr[i];
		}


		//sort halves
		left = mergeSort(left);
		right = mergeSort(right);

		//merge
		return merge(left, right);

	}


	private int[] merge(int[] left, int[] right){
		int[] result = new int[left.length + right.length];

		int l_index = 0;
		int r_index = 0;
		int res_index = 0;

		while(res_index < (left.length + right.length)){
			if(l_index > left.length){
				result[res_index] = right[r_index];
				res_index++;
				r_index++;
			}
			else if(r_index > right.length){
				result[res_index] = left[l_index];
				res_index++;
				l_index++;
			}
			else if(right[r_index] < left[l_index]){
				result[res_index] = right[r_index];
				res_index++;
				r_index++;
			}
			else{
				result[res_index] = left[l_index];
				res_index++;
				l_index++;
			}
		
		}

		return result;
	
	}

}
