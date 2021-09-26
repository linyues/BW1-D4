package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                result.add(i);

            }
        } else {
            for (int i = left; i >= right; i--) {
                result.add(i);
            }
        }

        return result;

    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (left < right) {
            for (int i = left; i <= right; i++) {
                if (i % 2 == 0) {
                    result.add(i);
                }


            }
        } else {
            for (int i = left; i >= right; i--) {
                if(i % 2 == 0){
                    result.add(i);
                }

            }
        }

        return result;

    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(elem -> elem % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];

    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> sec = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray).boxed().filter(elem -> sec.contains(elem)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> sec = Arrays.stream(secondArray).collect(Collectors.toList());
        List<Integer> fir = Arrays.stream(firstArray).collect(Collectors.toList());
        fir.addAll(sec);
        return fir.stream().distinct().collect(Collectors.toList());

    }

}
