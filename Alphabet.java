import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet {
	public static int distance(int a,int b)
	{
		int res;
		if (a>b)
			res=a-b;
		else
			res=b-a;
		return res;
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Please enter the number of albums :");
		String line=br.readLine();
		int n=Integer.parseInt(line);
		String []sto=new String[n];
		for (int j=0;j<n;j++)
		{
			String line1=br.readLine();
			sto[j]=line1;
		}
		for (int i=0;i<n;i++)
		{
			System.out.println(sto[i]);
		}
		int [][]alp=new int[26][];
		int p=0;
		int []result=new int[10];
		int r=0;
		for (int k=0;k<n;k++)
		{
			String str=sto[k];
			for ( char i=97;i<=122;i++)
			{
				int []he=new int[10];
				int p1=0;
				for ( int l=0;l<str.length();l++)
				{
					char ch=str.charAt(l);
					if (ch==i)
					{
						he[p1]=l;
						p1++;
					}
				}
				int c=0;
				for (int y=1; y<1000 ; y++)
				{
					if (he[y]!=0)
						c+=1;
					else
						break;
				}
				alp[p]=new int[c+1];
				for (int x=0; x<c+1 ; x++)
				{
					alp[p][x]=he[x];
				}
				p++;
			}
		}//end of first for
		int pos=1;
		int max=0;
		for (int x=0;x<26;x++)
		{
			int len=alp[x].length;
			pos=pos*len;
			if (len>max)
			{
				max=len;
			}
			for (int y=0;y<len;y++)
			{
				System.out.println(alp[x][y]);
			}
			System.out.println("***************************");
		}
		System.out.println(pos +" "+ max);
		for (int i=0;i<pos;i++)
		{
			int []res1=new int[26];
			int q=0;
			for (int j=0;j<26;j++)
			{
				int len1=alp[j].length;
				if (len1-1>=i)
				{
					res1[q]=alp[j][i];
					q++;
				}
				else
				{
					res1[q]=alp[j][0];
					q++;
				}
			}
			int check=0;
			result=new int[pos];
			for(int x1=0;x1<25;x1++)
			{
				int sum=distance(res1[x1],res1[x1+1]);
				check+=sum;
			}
			result[r]=check;
			r++;
		}
		for ( int y=0;y<result.length;y++)
		{
			System.out.println(result[y]);
		}

	}
}
