public class MyString{

	public static void main(String[] args){

		String in = "an";
		String rev = reverseString(in);
		System.out.println("in = " + in + ", Out = " + rev);

	}

	/**
	* Reverse string in place. Time COmplexity: O(n); Space Complexity: O(1)
	*/
	private static String reverseString(String string){
		//base cases
		if(string == null)
			return null;
		if(string.length() == 1){
			return string;
		}
		

		//convert to char array
		StringBuilder sb_string = new StringBuilder(string);

		//while start < end: swap
		int start = 0;
		int end = sb_string.length() - 1;

		while(start < end){
			char tmp = sb_string.charAt(start);
			sb_string.setCharAt(start, sb_string.charAt(end));
			sb_string.setCharAt(end, tmp);
			
			start++;
			end --;
		}
		
		//return string
		return sb_string.toString();
	}

	
	
}
