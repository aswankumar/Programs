import java.util.Random;
import java.util.Scanner;

public class TestDraught {
	public String first(int a[][],int playerId)
	{
		int c=0;
		String []res={"","","","","","","","","","","","","","","","","","","","",""};
		if (playerId==1)
		{
		for (int i=0;i<=7;i++)
		{
		for (int j=0 ; j<=7 ; j++)
		{
		if (a[i][j]==1)
		{
		int k=0;
		int l=0;
		String []sub={"",""};
		if (i<7 && j>0 )
		{
		if (a[i+1][j-1]==0)
		{
		res[c]=res[c]+i+" "+j+"\n"+1+"\n"+(i+1)+" "+(j-1);
		c++;
		}
		k=i;
		l=j;
		if (a[k+1][l-1]==2)
		{
		if ( k+1<7 && l-1>0 && a[k+2][l-2]==0)
		{
		sub[0]=sub[0]+(k+2)+" "+(l-2)+"\n";
		k=k+2;
		l=l-2;
		String []sub1=twoSides1(a,k,l,sub,0);
		String []forLen=sub1[0].split("\n");
		int len=forLen.length;
		res[c]=i+" "+j+"\n"+len+"\n"+sub1[0];
		c++;
		sub[0]=k+" "+l+"\n";
		String []sub2=twoSides(a,k,l,sub,0);
		if (sub1[0]!=sub2[0])
		{
		String []forLen2=sub2[0].split("\n");
		int len2=forLen2.length;
		res[c]=i+" "+j+"\n"+len2+"\n"+sub2[0];
		c++;
		sub[0]="";
		sub2[0]="";
		}
		sub1[0]="";
		if (sub1[1]!="")
		{
		String []forLen1=sub1[1].split("\n");
		int len1=forLen1.length;
		res[c]=i+" "+j+"\n"+len1+"\n"+sub1[1];
		c++;
		sub1[1]="";
		}
		if (sub2[1]!="")
		{
		String []forLen1=sub2[1].split("\n");
		int len1=forLen1.length;
		res[c]=i+" "+j+"\n"+len1+"\n"+sub2[1];
		c++;
		sub2[1]="";
		}
		}
		}
		}
		if ( i<7 && j<7)
		{
		if (a[i+1][j+1]==0)
		{
		res[c]=i+" "+j+"\n"+1+"\n"+(i+1)+" "+(j+1);
		c++;
		}
		int m=i;
		int n=j;
		if (a[m+1][n+1]==2)
		{
		if ( m+1!=7 && n+1!=7 && a[m+2][n+2]==0)
		{
		sub[0]=sub[0]+(m+2)+" "+(n+2)+"\n";
		m=m+2;
		n=n+2;
		String []sub1=twoSides(a,m,n,sub,0);
		String []forLen=sub1[0].split("\n");
		int len=forLen.length;
		res[c]=i+" "+j+"\n"+len+"\n"+sub1[0];
		c++;
		sub[0]=m+" "+n+"\n";
		String []sub2=twoSides1(a,m,n,sub,0);
		if (sub1[0]!=sub2[0])
		{
		String []forLen2=sub2[0].split("\n");
		int len2=forLen2.length;
		res[c]=i+" "+j+"\n"+len2+"\n"+sub2[0];
		c++;
		sub[0]="";
		sub2[0]="";
		}
		if (sub1[1]!="")
		{
		String []forLen1=sub1[1].split("\n");
		int len1=forLen1.length;
		res[c]=i+" "+j+"\n"+len1+"\n"+sub1[1];
		c++;
		}
		if (sub2[1]!="")
		{
		String []forLen1=sub2[1].split("\n");
		int len1=forLen1.length;
		res[c]=i+" "+j+"\n"+len1+"\n"+sub2[1];
		c++;
		}
		}
		}
		}
		}
		}//end of second for
		}//end of first for
		int max=0;
		int index=0;
		int index1=-1;
		int index2=-1;
		int index3=-1;
		int []p=new int[res.length];
		int z=0;
		int []p1=new int[res.length];
		int z1=0;
		int check=-1;
		int ex1=-1;
		int []p2=new int[res.length];
		int z2=0;
		int check1=-1;
		for (int i=0 ; i<res.length ; i++)
		{
		if (res[i]!="")
		{
		String []el=res[i].split("\n");
		int count=Integer.valueOf(el[1].substring(0));
		if (count>max)
		{
		max=count;
		index=i;
		}
		if ( count==1 )
		{
		int r=Integer.valueOf(el[0].substring(0, 1));
		int s=Integer.valueOf(el[0].substring(2));
		int r1=Integer.valueOf(el[2].substring(0, 1));
		int s1=Integer.valueOf(el[2].substring(2));
		if ( r1-r==2 && s1-s==2 )
		{
		if (s==0 && r1+1<=7)
		{
		if (a[r1+1][s1+1]!=2)
		index1=i;
		}
		else
		index1=i;
		}
		else if (r1-r==2 && s-s1==2)
		{
		if (s==7 && r1+1<=7)
		{
		if (a[r1+1][s1-1]!=2)
		index1=i;
		}
		else
		index1=i;
		}
		else
		{
		if (s-s1==1)
		{ 
		if (s<7 && r>0)
		{
		if (a[r1][s+1]==2 && a[r-1][s-1]!=1)
		{
		index2=i;
		}
		}
		if (s1==0)
		{
		index3=i;
		}
		if (r1+2<=7)
		{
		if (s1-2>=0)
		{
		if (a[r1+2][s1-2]==2 || a[r1+2][s1]==2)
		ex1=i;
		}
		}
		if ( r1+1<=7 && s1-1>=0 )
		{
		if ( a[r1+1][s1-1]!=2 && a[r1+1][s]!=2)
		{
		check=0;
		p1[z1]=i;
		z1++;
		}
		else if ( a[r1+1][s]==2 && a[r][s1-1]==1)
		{
		check1=0;
		p[z]=i;
		z++;
		}
		}
		p[z2]=i;
		z2++;
		}
		else
		{
		if (s>0 && r>0)
		{
		if (a[r1][s-1]==2 && a[r-1][s+1]!=1)
		{
		index2=i;
		}
		}
		if (s1==7)
		{
		index3=i;
		}
		if (r1+2<=7)
		{
		if (s1+2<=7)
		{
		if (a[r1+2][s1+2]==2 || a[r1+2][s1]==2)
		ex1=i;
		}
		}
		if ( r1+1<=7 && s1+1<=7 )
		{
		if ( a[r1+1][s1+1]!=2 && a[r1+1][s1-1]!=2)
		{
		check=0;
		p1[z1]=i;
		z1++;
		}
		else if ( a[r1+1][s]==2 && a[r][s1+1]==1)
		{
		check1=0;
		p[z]=i;
		z++;
		}
		}
		p[z2]=i;
		z2++;
		}
		}
		}
		}
		}
		if (max>=2)
		{
		return res[index];
		}
		else if (index1!=-1)
		{
		return res[index1];
		}
		else if (index2!=-1)
		{
		return res[index2];
		}
		else if ( index3!=-1)
		{
		return res[index3];
		}
		else if ( check!=-1)
		{
		Random rand = new Random();
		   int randomNum = rand.nextInt(z1)+0;
		   return res[p1[randomNum]];
		}
		else if (ex1!=-1)
		{
		return res[ex1];
		}
		else if (check1!=-1)
		{
		Random rand = new Random();
		   int randomNum = rand.nextInt(z)+0;
		   return res[p[randomNum]];
		}
		else
		{
		Random rand = new Random();
		   int randomNum = rand.nextInt(z2)+0;
		   return res[p2[randomNum]];
		}
		}
		if (playerId==2)
		{
			for (int i=7;i>=0;i--)
			{
				for (int j=0 ; j<=7 ; j++)
				{
				if (a[i][j]==2)
				{
				int k=0;
				int l=0;
				String []sub={"",""};
				if (i>0 && j>0 )
				{
				if (a[i-1][j-1]==0)
				{
				res[c]=res[c]+i+" "+j+"\n"+1+"\n"+(i-1)+" "+(j-1);
				c++;
				}
				k=i;
				l=j;
				if (a[k-1][l-1]==1)
				{
				if ( k-1>0 && l-1>0 && a[k-2][l-2]==0)
				{
				sub[0]=sub[0]+(k-2)+" "+(l-2)+"\n";
				k=k-2;
				l=l-2;
				String []sub1=forSecond(a,k,l,sub,0);
				String []forLen=sub1[0].split("\n");
				int len=forLen.length;
				res[c]=i+" "+j+"\n"+len+"\n"+sub1[0];
				c++;
				sub1[0]="";
				sub[0]=k+" "+l+"\n";
				String []sub2=forSecond1(a,k,l,sub,0);
				if (sub1[0]!=sub2[0])
				{
				String []forLen2=sub2[0].split("\n");
				int len2=forLen2.length;
				res[c]=i+" "+j+"\n"+len2+"\n"+sub2[0];
				c++;
				sub[0]="";
				sub2[0]="";
				}
				if (sub1[1]!="")
				{
				String []forLen1=sub1[1].split("\n");
				int len1=forLen1.length;
				res[c]=i+" "+j+"\n"+len1+"\n"+sub1[1];
				c++;
				sub1[1]="";
				}
				if (sub2[1]!="")
				{
				String []forLen1=sub2[1].split("\n");
				int len1=forLen1.length;
				res[c]=i+" "+j+"\n"+len1+"\n"+sub2[1];
				c++;
				sub2[1]="";
				}
				}
				}
				}
				if ( i>0 && j<7)
				{
				if (a[i-1][j+1]==0)
				{
				res[c]=i+" "+j+"\n"+1+"\n"+(i-1)+" "+(j+1);
				c++;
				}
				int m=i;
				int n=j;
				if (a[m-1][n+1]==1)
				{
				if ( m-1!=0 && n+1!=7 && a[m-2][n+2]==0)
				{
				sub[0]=sub[0]+(m-2)+" "+(n+2)+"\n";
				m=m-2;
				n=n+2;
				String []sub1=forSecond(a,m,n,sub,0);
				String []forLen=sub1[0].split("\n");
				int len=forLen.length;
				res[c]=i+" "+j+"\n"+len+"\n"+sub1[0];
				c++;
				sub[0]=m+" "+n+"\n";
				String []sub2=forSecond1(a,m,n,sub,0);
				if (sub1[0]!=sub2[0])
				{
				String []forLen2=sub2[0].split("\n");
				int len2=forLen2.length;
				res[c]=i+" "+j+"\n"+len2+"\n"+sub2[0];
				c++;
				sub[0]="";
				sub2[0]="";
				}
				if (sub1[1]!="")
				{
				String []forLen1=sub1[1].split("\n");
				int len1=forLen1.length;
				res[c]=i+" "+j+"\n"+len1+"\n"+sub1[1];
				c++;
				}
				if (sub2[1]!="")
				{
				String []forLen1=sub2[1].split("\n");
				int len1=forLen1.length;
				res[c]=i+" "+j+"\n"+len1+"\n"+sub2[1];
				c++;
				}
				}
				}
				}
				}
				}//end of second for
				}//end of first for
				int max=0;
				int index=0;
				int index1=-1;
				int index2=-1;
				int index3=-1;
				int []p=new int[res.length];
				int z=0;
				int []p1=new int[res.length];
				int z1=0;
				int check=-1;
				int ex1=-1;
				int []p2=new int[res.length];
				int z2=0;
				int check1=-1;
				for (int i=0 ; i<res.length ; i++)
				{
				if (res[i]!="")
				{
				String []el=res[i].split("\n");
				int count=Integer.valueOf(el[1].substring(0));
				if (count>max)
				{
				max=count;
				index=i;
				}
				if ( count==1 )
				{
				int r=Integer.valueOf(el[0].substring(0, 1));
				int s=Integer.valueOf(el[0].substring(2));
				int r1=Integer.valueOf(el[2].substring(0, 1));
				int s1=Integer.valueOf(el[2].substring(2));
				if ( r-r1==2 && s1-s==2 )
				{
				if (s==0 && r1-1>=0)
				{
				if (a[r1-1][s1+1]!=1)
				index1=i;
				}
				else
				index1=i;
				}
				else if (r-r1==2 && s-s1==2)
				{
				if (s==7 && r1-1>=0)
				{
				if (a[r1-1][s1-1]!=1)
				index1=i;
				}
				else
				index1=i;
				}
				else
				{
				if (s-s1==1)
				{ 
				if (s<7 && r>0)
				{
				if (a[r1][s+1]==1 && a[r+1][s-1]!=2)
				{
				index2=i;
				}
				}
				if (s1==0)
				{
				index3=i;
				}
				if (r1-2>=0)
				{
				if (s1-2>=0)
				{
				if (a[r1-2][s1-2]==1 || a[r1-2][s1]==1)
				ex1=i;
				}
				}
				if ( r1-1>=0 && s1-1>=0 )
				{
				if ( a[r1-1][s1-1]!=1 && a[r1-1][s]!=1)
				{
				check=0;
				p1[z1]=i;
				z1++;
				}
				else if ( a[r1-1][s]==1 && a[r][s1-1]==2)
				{
				check1=0;
				p[z]=i;
				z++;
				}
				}
				p[z2]=i;
				z2++;
				}
				else
				{
				if (s>0 && r<0)
				{
				if (a[r1][s-1]==1 && a[r+1][s+1]!=2)
				{
				index2=i;
				}
				}
				if (s1==7)
				{
				index3=i;
				}
				if (r1-2>=0)
				{
				if (s1+2<=7)
				{
				if (a[r1-2][s1+2]==1 || a[r1-2][s1]==1)
				ex1=i;
				}
				}
				if ( r1-1>=0 && s1+1<=7 )
				{
				if ( a[r1-1][s1+1]!=1 && a[r1-1][s1-1]!=1)
				{
				check=0;
				p1[z1]=i;
				z1++;
				}
				else if ( a[r1-1][s]==1 && a[r][s1+1]==2)
				{
				check1=0;
				p[z]=i;
				z++;
				}
				}
				p[z2]=i;
				z2++;
				}
				}
				}
				}
				}
				if (max>=2)
				{
				return res[index];
				}
				else if (index1!=-1)
				{
				return res[index1];
				}
				else if (index2!=-1)
				{
				return res[index2];
				}
				else if ( index3!=-1)
				{
				return res[index3];
				}
				else if ( check!=-1)
				{
				Random rand = new Random();
				   int randomNum = rand.nextInt(z1)+0;
				   return res[p1[randomNum]];
				}
				else if (ex1!=-1)
				{
				return res[ex1];
				}
				else if (check1!=-1)
				{
				Random rand = new Random();
				   int randomNum = rand.nextInt(z)+0;
				   return res[p[randomNum]];
				}
				else
				{
				Random rand = new Random();
				   int randomNum = rand.nextInt(z2)+0;
				   return res[p2[randomNum]];
				}
			}
		return res[0];
	}
	private String[] twoSides(int[][] a, int k, int l, String[] sub, int c) {
	if (k<7)
	{
	if (l>0)
	{
	if (a[k+1][l-1]==2)
	{
	if (k+1!=7 && l-1!=0 && a[k+2][l-2]==0)
	{
	sub[c]=sub[c]+(k+2)+" "+(l-2)+"\n";
	k=k+2;
	l=l-2;
	return twoSides(a,k,l,sub,c);
	}
	}
	}
	if (l<7)
	{
	if (a[k+1][l+1]==2)
	{
	if ( k+1!=7 && l+1!=7 && a[k+2][l+2]==0)
	{
	sub[c]=sub[c]+(k+2)+" "+(l+2)+"\n";
	k=k+2;
	l=l+2;
	return twoSides(a,k,l,sub,c);
	}
	}
	else
	return sub;
	}
	else
	return sub;
	}
	return sub;
	}
	private String[] twoSides1(int[][] a, int k, int l, String[] sub, int c) {
	if (k<7 && l>=0)
	{
	if (l<7)
	{
	if ( a[k+1][l+1]==2)
	{
	if (k+1!=7 && l+1!=7 && a[k+2][l+2]==0 )
	{
	sub[c]=sub[c]+(k+2)+" "+(l+2)+"\n";
	k=k+2;
	l=l+2;
	return twoSides1(a,k,l,sub,c);
	}
	}
	}
	if (l>0)
	{
	if ( a[k+1][l-1]==2 && l<=7)
	{
	if ( k+1!=7 && l-1!=0 &&  a[k+2][l-2]==0)
	{
	sub[c]=sub[c]+(k+2)+" "+(l-2)+"\n";
	k=k+2;
	l=l+2;
	return twoSides1(a,k,l,sub,c);
	}
	else
	return sub;
	}
	}
	else
	return sub;
	}
	return sub;
	}
	private String[] forSecond1(int[][] a, int k, int l, String[] sub, int c) {
	if (k>0)
	{
	if (l<7)
	{
	if ( a[k-1][l+1]==1)
	{
	if (k-1!=0 && l+1!=7 && a[k-2][l+2]==0 )
	{
	sub[c]=sub[c]+(k-2)+" "+(l+2)+"\n";
	k=k-2;
	l=l+2;
	return forSecond1(a,k,l,sub,c);
	}
	}
	}
	if (l>0)
	{
	if ( a[k-1][l-1]==1)
	{
	if ( k-1!=0 && l-1!=0 &&  a[k-2][l-2]==0)
	{
	sub[c]=sub[c]+(k-2)+" "+(l-2)+"\n";
	k=k-2;
	l=l+2;
	return forSecond1(a,k,l,sub,c);
	}
	else
	return sub;
	}
	}
	else
	return sub;
	}
	return sub;
	}
	private String[] forSecond(int[][] a, int k, int l, String[] sub, int c) {
	if (k>0)
	{
	if (l>0)
	{
	if (a[k-1][l-1]==1)
	{
	if (k-1!=7 && l-1!=0 && a[k-2][l-2]==0)
	{
	sub[c]=sub[c]+(k-2)+" "+(l-2)+"\n";
	k=k-2;
	l=l-2;
	return forSecond(a,k,l,sub,c);
	}
	}
	}
	if (l<7)
	{
	if (a[k-1][l+1]==1)
	{
	if ( k-1!=0 && l+1!=7 && a[k-2][l+2]==0)
	{
	sub[c]=sub[c]+(k-2)+" "+(l+2)+"\n";
	k=k-2;
	l=l+2;
	return forSecond(a,k,l,sub,c);
	}
	}
	else
	return sub;
	}
	else
	return sub;
	}
	return sub;
	}
	public static void main(String[] args)
	{
		int [][]a=new int[8][8];
		Scanner in=new Scanner(System.in);
		for (int i=0 ; i<=7 ; i++)
			{
				for (int j=0; j<=7 ; j++)
				{
				a[i][j]=in.nextInt();
				}
			}
		int playerId=in.nextInt();
		TestDraught d1=new TestDraught();
		System.out.println(d1.first(a,playerId));
		in.close();
	}

}