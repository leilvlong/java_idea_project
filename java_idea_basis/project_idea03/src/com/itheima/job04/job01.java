package com.itheima.job04;

import java.util.Objects;

public class job01 {
    public static void main(String[] args) {
        Tets t1 = new Tets();
        Tets t2 = new Tets();
        t1.num=10;
        t2.num=20;
        t1=t2;
        t1.num = 30;
        System.out.println(t1.num + "  " + t2.num);
        System.out.println(t1.getClass());
    }
}


class Tets{
    int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tets tets = (Tets) o;
        return num == tets.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }


}