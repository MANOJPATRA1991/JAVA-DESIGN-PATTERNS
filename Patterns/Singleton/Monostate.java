package Patterns.Singleton;

// Monostate is rarely used because it in no way gives
// any information that the class is actually behaving
// as a singleton.

// By keeping the fields static, means they are shared between
// any instance of a Student

// It is a dangerous approach
class Student {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Student.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Student.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class DemoMonostate {
    public static void main(String[] args) {
        Student ceo = new Student();
        ceo.setName("Mike");
        ceo.setAge(27);

        Student ceo2 = new Student();
        System.out.println(ceo2);
    }
}