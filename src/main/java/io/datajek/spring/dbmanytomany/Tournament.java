package io.datajek.spring.dbmanytomany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tournament_id")
    private List<Registration> registrations = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "tournament_categories",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    @JsonIgnoreProperties("tournaments")
    private List<Category> playingCategories = new ArrayList<>();

    public Tournament() {

    }

    public Tournament(String name, String location) {
        super();
        this.name = name;
        this.location = location;
    }

    public Tournament(String name, String location, List<Registration> registrations) {
        super();
        this.name = name;
        this.location = location;
        this.registrations = registrations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public List<Category> getPlayingCategories() {
        return playingCategories;
    }

    public void setPlayingCategories(List<Category> playingCategories) {
        this.playingCategories = playingCategories;
    }

    public void addRegistration(Registration reg) {
        registrations.add(reg);
    }

    public void removeRegistration(Registration reg) {
        if (registrations != null) {
            registrations.remove(reg);
        }
    }

    public void addCategory(Category category) {
        playingCategories.add(category);
    }

    public void removeCategory(Category category) {
        if (playingCategories != null) playingCategories.remove(category);
    }



    @Override
    public String toString() {
        return
                "Tournament [id=" + id + ", name=" + name + ", location"
                        + location + ", registrations=" + registrations + "]";
    }
}
