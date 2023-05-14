
package workshop3_1;

import static workshop3_1.Main.supporter;

public class Person {
    private String name;
    private String address;

    public Person() {
    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + '}';
    }
    
    public void input() {
        name = supporter.getStringWithContent("name");
        setAddress(supporter.getStringWithContent("address"));
    }
}
