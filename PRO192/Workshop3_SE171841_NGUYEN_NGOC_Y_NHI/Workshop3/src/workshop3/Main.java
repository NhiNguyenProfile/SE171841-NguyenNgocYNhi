package workshop3;

public class Main {

    static Supporter supporter = new Supporter();

    public static void main(String[] args) {
        Circle object = null;
        supporter.printOptions();
        int choice = supporter.getNumberWithLimit(1, 2, "choice");
        switch (choice) {
            case 1:
                object = new Circle();
                break;
            case 2:
                object = (Cylinder) new Cylinder();
                break;
        }
        object.input();
        supporter.printTest(object);
        int chooseTest = supporter.getNumberWithLimit(1, (object instanceof Cylinder)?4:3, "choice");
        switch (chooseTest) {
            case 1:
                object.input();
                System.out.println(object.toString());
                break;
            case 2:
                System.out.println(object.toString());
                break;
            case 3:
                System.out.println("Area: " + object.getArea());
                break;
            case 4: 
                System.out.println("Volume: " + ((Cylinder)object).getVolume());
                break;
        }
    }

}
