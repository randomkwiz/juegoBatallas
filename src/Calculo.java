
public class Calculo {

	public static boolean isPrimo(int n) {
		boolean primo = true;
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            primo = false;
	    }
	    return primo;
	}
	 
}
