package com.amo.lab2.utils;

import java.util.Random;

public class CountingSort {

    private final int[] arr;
    private long n;
    private int[] sortedArr;
    private long operationsCount;
    private long time;


    public CountingSort(int... arr) {
        this.arr = arr;
        this.n = arr.length;
        sort();
    }

    public CountingSort(int randomItemsAmount) {
        Random random = new Random();
        this.arr = new int[randomItemsAmount];
        for (int i = 0; i < randomItemsAmount; i++) {
            arr[i] = random.nextInt(2000);
        }
        this.n = arr.length;
        sort();
    }

    public void sort() {
        long startTime = System.nanoTime();
        sortedArr = new int[arr.length];
        operationsCount = 0;

        int max = findMax(arr);
        int[] countArray = new int[max + 1];

        for (int num : arr) {
            countArray[num]++;
            operationsCount += 3;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countArray[i] > 0) {
                sortedArr[index] = i;
                index++;
                countArray[i]--;
                operationsCount += 4;
            }
            operationsCount += 2;
        }
        long endTime = System.nanoTime();
        time = endTime - startTime;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int[] getArr() {
        return arr;
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public int[] getSortedArr() {
        return sortedArr;
    }

    public void setSortedArr(int[] sortedArr) {
        this.sortedArr = sortedArr;
    }

    public long getOperationsCount() {
        return operationsCount;
    }

    public void setOperationsCount(long operationsCount) {
        this.operationsCount = operationsCount;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
