package Users;

import java.util.Scanner;

public abstract class Person {
    protected int id;
    private String name;
    private String email;
    private String password;

    public Person(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void showMenu(Scanner sc);

}
