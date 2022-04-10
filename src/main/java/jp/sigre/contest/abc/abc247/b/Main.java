package jp.sigre.contest.abc.abc247.b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            persons[i] = new Person(sc.next(), sc.next());
        }

        for (int i = 0; i < persons.length; i++) {
            Person person = persons[i];
            boolean seiNg = true;
            boolean meiNg = true;
            for (int j = 0; j < persons.length; j++) {
                if (i == j) continue;
                Person person2 = persons[j];
                if (person2.match(person.sei)) {
                    seiNg = false;
                    break;
                }
            }
            for (int j = 0; j < persons.length; j++) {
                if (i == j) continue;
                Person person2 = persons[j];
                if (person2.match(person.mei)) {
                    meiNg = false;
                    break;
                }
            }

            if (!seiNg && !meiNg) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }


    private static class Person {
        String sei;
        String mei;

        Person(String sei, String mei) {
            this.sei = sei;
            this.mei = mei;
        }

        public boolean match(String str) {
            return str.equals(sei) || str.equals(mei);
        }

    }

    private static int[] getMultipleNumbers(Scanner sc, int count) {
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        return nums;
    }
}
