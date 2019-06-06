import java.util.List;
import org.sql2o.*;

public class Animal {
    private String name;
    private Boolean endangered;
    private int id;

    public Animal(String name, Boolean endangered) {
        this.setName(name);
        this.setEndangered(endangered);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEndangered() {
        return endangered;
    }

    public void setEndangered(Boolean endangered) {
        this.endangered = endangered;
    }

    public static List<Animal> all() {
      String sql = "SELECT id, name FROM animals";
      try(Connection con = DB.sql2o.open()) {
        return con.createQuery(sql).executeAndFetch(Animal.class);
      }
    }
    @Override
    public boolean equals(Object otherAnimal) {
      if (!(otherAnimal instanceof Animal)) {
        return false;
      } else {
        Animal newAnimal = (Animal) otherAnimal;
        return this.getName().equals(newAnimal.getName()) && this.getId() == newAnimal.getId();
      }
    }

    public void save() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO animals(name, endangered) VALUES (:name, :endangered)";
        this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("endangered", this.endangered)
        .executeUpdate()
        .getKey();
      }
    }
    public static Animal find(int id) {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT * FROM animals where id=:id";
          Animal animal = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Animal.class);
          return animal;
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
            String sql = "UPDATE animals SET endangered = :endangered  WHERE id = :id";
            con.createQuery(sql)
            .addParameter("endangered", endangered)
            .addParameter("id", id)
            .executeUpdate();
          }
      }
    public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String sql = "DELETE FROM animals WHERE id = :id;";
        con.createQuery(sql)
          .addParameter("id", id)
          .executeUpdate();
        }
      }

}
