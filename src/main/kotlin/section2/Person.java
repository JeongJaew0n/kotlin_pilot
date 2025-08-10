package section2;

import org.jetbrains.annotations.Nullable;

public class Person {

    private final String name;
    private final int age;

    public Person(String name) {
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
