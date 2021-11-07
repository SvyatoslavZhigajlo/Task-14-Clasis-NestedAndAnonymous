package com.zhigajlo;


public class Student {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static ComparatorByName comparatorByName() {
        return new ComparatorByName();
    }

    public static ComparatorByAge comparatorByAge() {
        return new ComparatorByAge();
    }

    public static ComparatorByAgeByName comparatorByNameAndAge() {
        return new ComparatorByAgeByName();
    }


    public static class ComparatorByName implements IComparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.name.compareTo(student2.name);
        }
    }

    public static class ComparatorByAge implements IComparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            return student1.age.compareTo(student2.age);
        }
    }

    public static class ComparatorByAgeByName implements IComparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            int result = student1.name.compareTo(student2.name);
            if (result == 0) {
                result = student1.age.compareTo(student2.age);
            }
            return result;
        }
    }


}
