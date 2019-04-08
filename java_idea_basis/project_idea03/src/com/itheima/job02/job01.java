package com.itheima.job02;

import java.lang.reflect.Array;
import java.util.*;

public class job01 {
    public static void main(String[] args) {
        // 统计集合中每个元素出现的次数
        /*Collection<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("a");
        strList.add("b");
        strList.add("b");
        strList.add("b");
        strList.add("c");
        System.out.println(strCount(strList));*/

        // 数组转集合
        /*int[] ints = {1,2,3,4,5};
        System.out.println(intArray(ints));*/

        // 求最大年龄
        //sortStudent();

        // 编写一个泛型方法，实现任意引用类型数组指定位置元素交换
        /*String[] strings = {"1","2","3","4"};
        Character[] chars = {'1','2','3','4'};
        Integer[] ints = {1,2,3,4};
        elementExchange(strings,3,"5");
        elementExchange(chars,3,'5');
        elementExchange(ints,3,5);*/

        // 编写一个泛型方法，实现任意引用类型数组指翻转
        /*String[] strings = {"1","2","3","4","5"};
        System.out.println(Arrays.toString(arrayFlip(strings)));*/


    }

    // 统计集合中每个元素出现的次数
    public static ArrayList<String> strCount(Collection<String> strList){
        ArrayList<String> iter = new ArrayList<>();
        for (String str:strList) {
            int count = 0;
            for (String s : strList) {
                if(str.equals(s)){
                    count++;
                }
            }
            iter.add(str+"出现次数: "+count);
        }
        iter = new ArrayList<String>(new HashSet<String>(iter));
        Collections.sort(iter);
        return iter;
    }

    // 数组转集合
    public static ArrayList<Integer> intArray(int[] nums){
        ArrayList intList = new ArrayList<>();
        for (int num : nums) {
            intList.add(num);
        }
        return intList;
    }

    // 求Student 最大年龄 修改姓名
    public static void sortStudent(){
        Student stu1 = new Student("一",11,"男");
        Student stu2 = new Student("二",1,"男");
        Student stu3 = new Student("三",12,"男");
        Student stu4 = new Student("四",2,"男");
        ArrayList<Student> students = new ArrayList<>();
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);

        for (int x = 0,y=0; x < students.size(); x++) {
            if(students.get(x).getAge()>students.get(y).getAge()){
                y = x;
            }
            if(x == students.size()-1){
                System.out.println("年龄最大的学生: " + students.get(y).getName());
                students.get(y).setName("小猪佩奇");
            }
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // 编写一个泛型方法，实现任意引用类型数组指定位置元素交换
    public static <E> void elementExchange(E[] array, int location, E element){
        if(location<array.length){
            array[location]=element;
        }else{
            System.out.println("超出索引范围");
        }
        System.out.println(Arrays.toString(array));
    }

    // 编写一个泛型方法，实现任意引用类型数组指翻转
    public static <E> E[] arrayFlip(E[] array){
        for(int x=0, y=array.length-1; x<y; x++,y--){
            E temp = array[x];
            array[x]=array[y];
            array[y]=temp;
        }
        return array;
    }



}


class Student{
    private String name;
    private int age;
    private String gender;

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}