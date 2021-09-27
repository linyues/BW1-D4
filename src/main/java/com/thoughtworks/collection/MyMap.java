package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        //将集合A中得元素映射成集合B中的元素
        return array.stream().map(elem -> elem * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        //数字映射为字母
        return array.stream().map(num ->letters[num-1]).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(num -> num < 27 ? letters[num - 1] : letters[(num - 1)/26 - 1] + letters[(num - 1) % 26]).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
