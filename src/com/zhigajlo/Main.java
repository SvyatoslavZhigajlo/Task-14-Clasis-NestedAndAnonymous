package com.zhigajlo;

public class Main {

    public static void main(String[] args) {
        new Main().run();

    }

    private void run() {
        Student student1 = new Student();
        student1.setAge(23);
        student1.setName("Anton");
        Student student2 = new Student();
        student2.setName("Anton");
        student2.setAge(26);

        IComparator<Student> comparatorByName = Student.comparatorByName();
        int resultByName = comparatorByName.compare(student1, student2);
        if (resultByName == 0){
            System.out.println("При сравнении двух студентов по имени выявено, " +
                    "что студенты с одинаковым имененм");
        }else if (resultByName < 0){
            System.out.println("При сравнении двух студентов по имени выявено, " +
                    "что студент 1 идет в начале списка по алфавиту");
        }else {
            System.out.println("При сравнении двух студентов по имени выявено, " +
                    "что студент 2 идет в начале списка по алфавиту");
        }

        IComparator<Student> comparatorByAge = Student.comparatorByAge();
        int resultByAge = comparatorByAge.compare(student1, student2);
        if (resultByAge == 0){
            System.out.println("При сравнении двух студентов по возрасту " +
                    "определено, что студенты одногодки");
        }else if (resultByAge < 0){
            System.out.println("Студент 1 старше студента 2");
        }else {
            System.out.println("Студент 2 старше студента 1");
        }

        IComparator<Student> comparatorByNameAndAge = Student.comparatorByNameAndAge();
        int resultByAgeAndName = comparatorByNameAndAge.compare(student1, student2);
        System.out.println("Результат сравнения двух студентов по имени и возрасту - " + resultByAgeAndName);

        studentPrinter(student1);
//        studentStringConverter(student2);
    }

    private void studentPrinter(Student student) {

        IStudentPrinter studentPrinter = new IStudentPrinter() {
            @Override
            public void print(Student student) {
                studentStringConverter(student);
            }
        };
    }

    private void studentStringConverter(Student student2) {
        IStudentStringConverter studentStringConverter = new IStudentStringConverter() {
            @Override
            public String convert(Student student) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Name: ").append(student2.getName()).append("\n")
                        .append("Age: ").append(student2.getAge());
                return stringBuilder.toString();
            }
        };

    }

}
