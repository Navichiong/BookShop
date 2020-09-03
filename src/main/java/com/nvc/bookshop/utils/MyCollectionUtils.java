package com.nvc.bookshop.utils;

import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

public class MyCollectionUtils {

    private MyCollectionUtils() {

    }
    public static List<Integer> toIntegerList(List<String> stringList) {

        List<Integer> list = new LinkedList<>();

        if (!CollectionUtils.isEmpty(stringList)) {
            for (String s : stringList) {
                int i = Integer.parseInt(s);
                list.add(i);
            }
        }
        return list;
    }
}
