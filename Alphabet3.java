import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet3 {
	
	public static int[][] create(String str)
	{
		int [][]alp=new int[26][];
		int p=0;
		for ( char i=97;i<=122;i++)
		{
			int []he=new int[1000];
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
		return alp;

	}
	
	public static int distance(int a,int b)
	{
		int res;
		if (a>b)
			res=a-b;
		else
			res=b-a;
		return res;
	}


	public static int alpha(int alp[][])
	{
		int pos=1;
		int max=0;
		int mylen[]=new int[26];
		for (int x=0;x<26;x++)
		{
			int len=alp[x].length;
			mylen[x]=len-1;
			pos=pos*len;
			if (len>max)
			{
				max=len;
			}
			for (int y=0;y<len;y++)
			{
				//System.out.print(alp[x][y] +" ");
			}
			//System.out.print(" | ");
		}
		//System.out.println(pos +" "+ max);
		
		int []pre=new int[26];
		for (int i=0;i<25;i++)
		{
			for ( int k=0;k<alp[i].length;k++)
			{
				int mul=1;
				for (int j=i+1;j<26;j++)
				{
					int rs=alp[j].length;
					mul=mul*rs;
				}
				pre[i]=mul;
			}
			
		}
		pre[25]=1;
		int [][]sni=new int[pos][26];	
			for (int j1=0;j1<26;j1++)
			{
				//System.out.print(mylen[j1]+" ");
			}
			//System.out.println("---------");
		
		for (int i=0;i<pos;i++)
		{
			for (int j1=0;j1<26;j1++)
			{
				if (i==0)
				{
					sni[i][j1]=mylen[j1];
				}
				else
				{
					if (mylen[j1]==0)
						sni[i][j1]=mylen[j1];
					else
					{
						mylen[j1]-=1;
						sni[i][j1]=mylen[j1];
					}
				}
			}
		}
		int asw[]=new int[pos];
		int r1=0;
		for (int i=0;i<pos;i++)
		{
			int check=0;
			for (int j1=0;j1<25;j1++)
			{
				int sum=distance(alp[j1][sni[i][j1]],alp[j1+1][sni[i][j1+1]]);
				check+=sum;
			}
			asw[r1]=check;
			r1++;
		}
		int min=asw[0];
		for(int x=1;x<pos;x++)
		{
			if (min>asw[x])
				min=asw[x];
		}
		return min;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line=br.readLine();
		int n=Integer.parseInt(line);
		String []sto=new String[n];
		for (int j=0;j<n;j++)
		{
			String line1=br.readLine();
			sto[j]=line1;
		}
		int [][]alp=new int[26][];
		int []result=new int[n];
		for (int k=0;k<n;k++)
		{
			String str=sto[k];
			alp=create(str);
			result[k]=alpha(alp);
		}//end of first for
		for (int z=0;z<n;z++)
		{
			System.out.println(result[z]);
		}
	}
}
