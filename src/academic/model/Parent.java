package academic.model;

/**
 * @author 12S22002 - Jeremy Mart Valentino Nainggolan
 * 
 */

public class Parent {
    private String id;
    private String name;

    public Parent(String _id, String _name) {
        id = _id;
        name = _name;
    }

    public Parent(String _id) {
        id = _id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getId() + "|" + getName();
    }
}
