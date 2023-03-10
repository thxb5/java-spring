package com.study.algorithm;

public class Test {
    public static void main(String[] args) {
        int a[] = {1,3,10,2,8};
        int sum = 0;
        for(int i=0; i<a.length; i++) {
            sum += a[i];
        }
        double average = (double)sum / a.length;

        System.out.println(average);
    }
}
