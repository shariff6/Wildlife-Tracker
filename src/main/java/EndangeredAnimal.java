import java.util.List;
import org.sql2o.*;

public class EndangeredAnimal {
    private String name;
    private String age;
    private String health;
    private Boolean endangered;
    private int id;

    public EndangeredAnimal(String name, String age, String health, Boolean endangered) {
        this.name = name;
        this.age = age;
        this.health = health;
        this.endangered = endangered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Boolean getEndangered() {
        return endangered;
    }

    public void setEndangered(Boolean endangered) {
        this.endangered = endangered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static List<EndangeredAnimal> all() {
      String sql = "SELECT id, name FROM endangered_animals";
      try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(EndangeredAnimal.class);
      }
    }
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof EndangeredAnimal)) {
            return false;
        } else {
            EndangeredAnimal newAnimal = (EndangeredAnimal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) && this.getId() == newAnimal.getId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO endangered_animals(name, age, health) VALUES (:name, :age, :health)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM endangered_animals where id=:id";
            EndangeredAnimal endangeredAnimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
            return endangeredAnimal;
        }
    }
    public List<Sighting> getSightings() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where animalId=:id";
            return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Sighting.class);
        }
    }
    public void update(Boolean endangered) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "UPDATE endangered_animals SET endangered = :endangered  WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("endangered", endangered)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM endangered_animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

}
