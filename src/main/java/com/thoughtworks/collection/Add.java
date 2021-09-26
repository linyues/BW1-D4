package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder ; i++) {
            if(i % 2 ==0){
                sum += i;
            }

        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if(leftBorder > rightBorder){
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int sum = 0;
        for (int i = leftBorder; i <= rightBorder ; i++) {
            if(i % 2 == 1){
                sum += i;
            }

        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum =0;
        for (int element : arrayList) {
            sum += element*3+2;
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int val = arrayList.get(i);
            if(val % 2 == 1){
                arrayList.set(i,val * 3 + 2);
            }
        }
        return  arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
//        int sum =0;
//        for (int element : arrayList) {
//            if(element % 2 ==1)
//            sum += element*3+5;
//        }
//        return sum;
        return arrayList.stream().filter(element ->element % 2 == 1).mapToInt(element ->element*3+5).sum();

    }

    public double getMedianOfEven(List<Integer> arrayList) {
       return arrayList.stream().filter(elem ->elem % 2==0).mapToInt(elem ->elem).sum()/2.0;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(m -> m % 2 == 0).mapToInt(x -> x).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        return arrayList.stream().filter(elem -> elem % 2 == 0).anyMatch(elem -> elem.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(elem -> elem % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> list =arrayList.stream().filter(elem -> elem % 2 == 0).sorted().collect(Collectors.toList());
        list.addAll(arrayList.stream().filter(elem -> elem % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        return list;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> list =new ArrayList<>();
        for (int i = 0; i <arrayList.size()-1 ; i++) {
            list.add((arrayList.get(i)+arrayList.get(i+1))*3);
        }
        return list;
    }
}
