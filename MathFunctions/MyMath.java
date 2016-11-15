

public class MyMath{

	public static void main(String args[]){

		/* POWER */
		double base = 2.0;
		int pow = 4;
		double res = pow_log(base, pow);

		System.out.println("pow(" + base + "," + pow + ") = " + res);
	}

	/**
	* Returns base raised in pow. Time Complexity: O(n)
	*/
	public static double pow(double base, int pow){
		if(pow == 0){
			return 1;
		}

		return 2 * pow(base, pow - 1);
	}

	/**
	* Returns base raised in pow. Time Complexity: 
	*/
	public static double pow_log(double base, int pow){
		if(pow == 0){
			return 1;
		}
		//if(pow == 1){
		//	return base;
		//}

		double half = pow(base, pow/2);

		if(pow % 2 == 0){
			return half * half;
		}
		else{
			return half * half * base;
		}
		
	}

	//FIBONACCI
	

}
