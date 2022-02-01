package practice.demo.entities;
import java.io.*;

@Entity
public class Team {
    String id;
    String name;

    public List<Developers> getDevelopersList() {
        return developersList;
    }

    public void setDevelopersList(List<Developers> developersList) {
        this.developersList = developersList;
    }

    List<Developers> developersList;

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
}
