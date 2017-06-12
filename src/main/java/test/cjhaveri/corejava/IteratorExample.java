package test.cjhaveri.corejava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chetanjhaveri on 6/12/17.
 */
public class IteratorExample implements Iterable<IteratorExample.Name> {

    List<Name> names;

    int minimumAge;

    public IteratorExample(int minimumAge) {

        names = new ArrayList<>();
        names.add(new Name("Pedro", "Martinez", "40"));
        names.add(new Name("David", "Justice", "51"));
        names.add(new Name("Nomar", "Garcia", "55"));

        this.minimumAge = minimumAge;

    }

    @Override
    public Iterator<Name> iterator() {
        return new AgeIterator(minimumAge);
    }


    public static void main(String[] args) {
        IteratorExample example = new IteratorExample(60);

        Iterator<Name> iterator = example.iterator();
        while (iterator.hasNext()) {
            Name next = iterator.next();
            System.out.println(next.toString());
        }
    }

    /**
     * This is a wierd iterator
     * it only iterates over players that are over age the supplied MIN_AGE
     */
    class AgeIterator implements Iterator<Name> {


        /**
         * Iterator's current spot
         */
        int current;

        /**
         * minimum age otherwise iterate over
         */
        int MIN_AGE;

        public AgeIterator(int MIN_AGE) {
            this.current = 0;
            this.MIN_AGE = MIN_AGE;
        }

        @Override
        public boolean hasNext() {
            boolean found = false;
            
            for (int i=current; !found && i < names.size(); i++) {
                current++;
                if (Integer.parseInt(names.get(i).getAge()) > MIN_AGE) {
                    found = true;

                }
            }
            return found;
        }

        @Override
        public Name next() {
            return names.get(current -1);
        }
    }


    /**
     * Basic struct to store some properties
     */
    class Name {
        String fName;
        String lName;
        String age;

        public Name(String fName, String lName, String age) {
            this.fName = fName;
            this.lName = lName;
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "fName='" + fName + '\'' +
                    ", lName='" + lName + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}
