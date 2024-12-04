package model.bean;

public class StudentBEAN {
    private String id;
    private String name;
    private int age;
    public String university;

    public StudentBEAN(String id, String name, int age, String university){
        this.id = id;
        this.name = name;
        this.age = age;
        this.university = university;
    }
    public StudentBEAN() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    public boolean isValidId() {
        return id != null && !id.trim().isEmpty();
    }

    public boolean isValidName() {
        return name != null && !name.trim().isEmpty();
    }

    public boolean isValidAge() {
        return age > 0;
    }

    public boolean isValidUniversity() {
        return university != null && !university.trim().isEmpty();
    }
}

