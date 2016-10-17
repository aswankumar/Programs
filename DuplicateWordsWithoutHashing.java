package com.snigdha.task;

public class DuplicateWordsWithoutHashing
{
    public static void main(String[] args)
    {
        String test = "this sentence has duplicate words which are useful for this duplicate words program which is useful";
        String duplicate[]=duplicatemethod(test);
        for(String i:duplicate)
        {
            if (i!=null)
                System.out.println(i);
        }
    }
    
    public static String[] duplicatemethod(String input)
    {
        String words[]=input.split("\\s+");
        int len=words.length;
        String result[]=new String[len];
        int c=0;
        for(int i=0;i<len;i++)
        {
            int count=0;
            for(int j=i+1;j<len;j++)
            {
                if(words[i].equals(words[j]))
                {
                    count++;
                    words[j]="";                }
            }
            if(count>=1 && words[i]!="")
            {
                result[c]=words[i];
                c++;
                
            }
        }
        return result;
        
        
    }
}