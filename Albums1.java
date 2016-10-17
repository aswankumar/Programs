import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Albums1
{

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Please enter the number of albums :");
		String line=br.readLine();
		int n=Integer.parseInt(line);
		if ( n>0 && n<=100000)
		{
		//System.out.println("Please enter the price of the albums in single row :");
		String s=br.readLine();
		String s1[]=s.split(" ");
			//System.out.println("Please enter the number of queries :");
			String line1=br.readLine();
			int n1=Integer.parseInt(line1);
			//System.out.println(n1);
			if (n1>0 && n1<=1000000)
			{
				int result[]=new int[n1];
				int index=0;
				String sec2[][]=new String[n1][];
				//System.out.println("Please enter all the queries :");
				for ( int i=0 ; i<n1 ; i++)
				{
					String sec=br.readLine();
					sec2[i]=sec.split(" ");
				}
				for ( int j=0; j<n1 ; j++)
				{
					int k=Integer.parseInt(sec2[j][2]);
					int start=Integer.parseInt(sec2[j][0]);
					int end=Integer.parseInt(sec2[j][1]);
					int count=0;
					if (start<=end && end<=n && start<=n && start>0 && end>0 && k>0 && k<=10000)
					{
						for ( int m=start-1; m<end ; m++)
						{
							int pr=Integer.valueOf(s1[m]);
							if (pr%k==0)
							{
								//System.out.println(m +" "+ pr);
								count+=1;
							}
						}
					}
					result[index]=count;
					index++;
				}
				for (int x=0;x<n1;x++)
				{
					System.out.println(result[x]);
				}
			}
		}
	}
	
}
