import java.awt.List;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class HackerEarth {
		public void printHackerEarth(int n,String str)
		{
			ArrayList<Character> h2=new ArrayList<Character>();
			ArrayList<Character> a2=new ArrayList<Character>();
			ArrayList<Character> c=new ArrayList<Character>();
			ArrayList<Character> k=new ArrayList<Character>();
			ArrayList<Character> e2=new ArrayList<Character>();
			ArrayList<Character> r2=new ArrayList<Character>();
			ArrayList<Character> t=new ArrayList<Character>();
			ArrayList<Integer> check=new ArrayList<Integer>();
			for ( int i=0; i<n; i++)
			{
				char ch=str.charAt(i);
				if (ch=='h')
					h2.add(ch);
				else if (ch=='a')
					a2.add(ch);
				else if (ch=='c')
					c.add(ch);
				else if (ch=='k')
					k.add(ch);
				else if (ch=='e')
					e2.add(ch);
				else if (ch=='r')
					r2.add(ch);
				else if (ch=='t')
					t.add(ch);
			}
			int len1=h2.size()/2;
			check.add(len1);
			int len2=a2.size()/2;
			check.add(len2);
			int len3=e2.size()/2;
			check.add(len3);
			int len4=r2.size()/2;
			check.add(len4);
			int len5=c.size();
			check.add(len5);
			int len6=k.size();
			check.add(len6);
			int len7=t.size();
			check.add(len7);
			int min=len1;
			Iterator itr=(Iterator) check.iterator();
			
		}
}
