package test.cjhaveri.corejava.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by chetanjhaveri on 6/12/17.
 */
public class HelloWorld {


    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(42));
        people.add(new Person(24));

        Function<Person, String> function = person -> "His age is " + person.getAge();
        Predicate<Person> predicate = person -> person.getAge() > 30;

        for (Person p: people) {
            if (predicate.test(p)) {
                System.out.println(function.apply(p));
            }
        }




    }


    


    static class Person {

        int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
