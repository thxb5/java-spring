package com.study.alg;

public class Search {
    public static void main(String[] ar) {
        int a[] = {10,3,1,4,2};
        int searchValue = 4;
        int findID = -1;
        for (int i=0; i<a.length; i++) {
            if (a[i] == searchValue) {
                findID = i;
                break;
            }
        }
        System.out.printf("검색 %d\n", findID);
    }
}
