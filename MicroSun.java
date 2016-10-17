import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MicroSun {
	public static String reverse(String str)
	{
		int l=str.length();
		String rev="";
		for ( int i=l-1; i>=0 ; i--)
		{
			char ch=str.charAt(i);
			rev=rev+ch;
		}
		return rev;
	}
    public static void main(String args[] ) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        if (T>=0 && T<=1000)
        {
        	int index=0;
    		int result[]=new int[T];
        	for ( int i=0; i<T; i++)
        	{
        		String k=br.readLine();
        		String[] arr=k.split("\\s+");
        		int x=Integer.valueOf(arr[0]);
        		int y=Integer.valueOf(arr[1]);
        		int count=0;
        		if ( x<=2359 && y<=2359 && x>=0 && y>=0)
        		{
            		for ( int j=x; j<=y ; j++)
	        		{
	        			String str=Integer.toString(j);
	        			int l=str.length();
	        			if (l<=4)
	        			{
		        			if (l==3)
		        			{
		        				str="0"+str;
		        			}
		        			if (l==2)
		        			{
		        				str="00"+str;
		        			}
		        			if (l==1)
		        			{
		        				str="000"+str;
		        			}
		        			int en=Integer.parseInt(str.substring(2));
		        			//System.out.println(en);
		        			if (en<=59)
		        			{
		        				//System.out.println(str);
			        			String rev=reverse(str);
			        			
			        			if (rev.equals(str))
			        			{
			        				//System.out.println(str);
			        				//System.out.println("__________________________________________________");
			        				count+=1;
			        			}
		        			}
	        			}
	        		}
            		result[index]=count;
            		index++;
        		}
        		else
        		{
        			result[index]=0;
        			index++;
        		}
        		
        	}
        	for (int l=0;l<result.length ;l++)
        	{
        		System.out.println(result[l]);
        	}
        }
    }
}
