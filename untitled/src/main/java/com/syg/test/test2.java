package com.syg.test;

import org.junit.Test;

/**
 * @author 靖鸿宣
 * @since 2021/2/1
 */
public class test2 {
 @Test
    public void test()
    {
        int i=153845;
        while(true)
        {
            i++;
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            int a=chars[0];
            for(int i1 = 0;i1<chars.length-1;i1++)
            {
                chars[i1]=chars[i1+1];
            }
            chars[chars.length-1]= (char) a;
            String s1 = String.valueOf(chars);
            if(s.charAt(0)=='6'&&Integer.parseInt(s1)==4*Integer.parseInt(s))
            {
                System.out.println(s);
                System.exit(0);
            }
        }

    }
}
