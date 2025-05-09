package oslomet.fullstackcrud.models;

public class Person {
    private int id;
    private String name;
    private int year;
    private String description;

    public Person(int id, String name, int year, String description) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.description = description;
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getYear() {return year;}
    public void setYear(int year){this.year = year;}

    public String getDescription() {return description;}
    public void setDescription(String description){this.description = description;}
}

