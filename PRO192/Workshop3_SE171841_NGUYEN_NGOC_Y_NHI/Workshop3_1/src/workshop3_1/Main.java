
package workshop3_1;

public class Main {
     static Supporter supporter = new Supporter();
   
    public static void main(String[] args) {
        Person person = null;
        supporter.printOptions();
        int choice = supporter.getNumberWithLimit(1, 3, "choice");
        switch (choice) {
            case 1:
                person = new Person();
                break;
            case 2:
                person = (Student) new Student();
                break;
            case 3:
                person = (Staff) new Staff();
                break;
        }
        person.input();
        supporter.printTest(person);
        int chooseTest = supporter.getNumberWithLimit(1, 2, "choice");
        switch (chooseTest) {
            case 1:
                person.input();
                System.out.println(person.toString());
                break;
            case 2:
                System.out.println(person.toString());
                break;
        }
    }
    
}
