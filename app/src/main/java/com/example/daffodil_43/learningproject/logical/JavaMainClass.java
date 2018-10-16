package com.example.daffodil_43.learningproject.logical;

import org.w3c.dom.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaMainClass {


    public static void main(String args[])
    {
//        drawFloydTriangle(10);
        findOccurrenceOfChars("helloohh");
    }



    private static void drawFloydTriangle(int n)
    {
        int x=1;
        for (int i=0;x<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print((x++)+" ");
            }
            System.out.println();
        }

    }


    private static void findOccurrenceOfChars(String string)
    {
        HashMap<Character,Integer> charIntMap=new HashMap<>();
        for (int i=0;i<string.length();i++)
        {
            Character c=string.charAt(i);
            if(charIntMap.containsKey(c))
            {
                charIntMap.put(c,charIntMap.get(c)+1);
            }
            else
                charIntMap.put(c,1);
        }

        for (Map.Entry<Character,Integer> entry:charIntMap.entrySet())
        {
            System.out.println("Char "+entry.getKey()+" occurrence "+entry.getValue());
        }
    }





}
