package domain;

public class Person<T>
{
    private String name;
    private int age;
    private String diff1;
    private T content;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public String getDiff1() {
        return diff1;
    }

    public void setDiff1(final String diff1) {
        this.diff1 = diff1;
    }

    public T getContent() {
        return content;
    }

    public void setContent(final T content) {
        this.content = content;
    }
}
