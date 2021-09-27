package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Integer ::compare).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Integer ::compare).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(num -> num).average().getAsDouble();
//        double sum = arrayList.stream().reduce(0, (pre, cur) -> pre + cur);
//        return sum / arrayList.size();
    }

    public double getOrderedMedian() {
        int size = arrayList.size();
        return size % 2 == 1 ?  arrayList.get(size / 2 ) : (arrayList.get(size / 2 - 1) + arrayList.get(size / 2 ) ) / 2.0;
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
    }


    public int getIndexOfFirstEven() {
           int index = arrayList.stream().filter(x -> x % 2 == 0).findFirst().get();
           return arrayList.indexOf(index);
    }

    public boolean isEqual(List<Integer> arrayList) {

        return arrayList.containsAll(this.arrayList) && this.arrayList.containsAll(arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        for (int num : arrayList) {
            singleLink.addTailPointer(num);
        }
        int index = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            int left = (int) singleLink.getNode(index);
            int right = (int) singleLink.getNode(index + 1);
            return (left + right) / 2.0;
        } else {
            return (Double) singleLink.getNode(index + 1);
        }
    }


    public int getLastOdd() {
       List<Integer> Odd = arrayList.stream().filter(num -> num % 2 == 1).collect(Collectors.toList());
       return Odd.get(Odd.size() - 1);
    }

    public int getIndexOfLastOdd() {
        int lastOdd = getLastOdd();
        return arrayList.indexOf(lastOdd);
    }
}
