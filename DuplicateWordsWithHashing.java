package com.snigdha.task;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DuplicateWordsWithHashing
{
    public static void main(String[] args)
{
    String test = "this sentence has duplicate words which are useful for this duplicate words program which is useful";
    Set<String> duplicates = duplicateWords(test);
    System.out.println("input : " + test);
    System.out.println("output : " + duplicates); }
    
    public static Set<String> duplicateWords(String input)
    {
        if(input == null || input.isEmpty())
        
        {
            
            return Collections.emptySet(); 
            
        } 
        
        Set<String> duplicates = new HashSet<>(); 
        
        String[] words = input.split("\\s+");
        
        Set<String> set = new HashSet<>();
        
        for(String word : words)
        
        { 
            if(!set.add(word)){ duplicates.add(word);
            
                
            }
            }
            return duplicates; 
        
    } }