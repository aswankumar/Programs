import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Binary {
	/*static BitSet bs = new BitSet(26);   
	static void fill(int k, int n)
	{
	   if (k == n)
	   {
	      System.out.println(bs);
	      return;
	   }
	   bs.set(k, false);
	   fill(k+1, n);
	   bs.set(k, true);
	   fill(k+1, n);
	}*/

	public static void main(String[] args) throws IOException
	{
	    //fill(0, 26);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		int n=Integer.parseInt(line);
		for(int i=0 ; i<n ; i++){
			  System.out.println(Integer.toBinaryString(i));
		}
	}

}
