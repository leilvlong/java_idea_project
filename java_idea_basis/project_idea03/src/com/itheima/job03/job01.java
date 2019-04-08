package com.itheima.job03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class job01 {
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        /*ints.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer>2;
            }
        });*/
        ints.removeIf((num)->{
            return num>2;
        });
        System.out.println(ints);
    }
}
