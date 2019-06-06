import java.util.List;
import org.sql2o.*;


public class Sighting {
  private int animalId;
  private int endangeredAnimalId;
  private String rangerName;
  private String location;
  private int id;

    public Sighting(int animalId, int endangeredAnimalId, String rangerName, String location) {
        this.animalId = animalId;
        this.endangeredAnimalId = endangeredAnimalId;
        this.rangerName = rangerName;
        this.location = location;
    }


    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getEndangeredAnimalId() {
        return endangeredAnimalId;
    }

    public void setEndangeredAnimalId(int endangeredAnimalId) {
        this.endangeredAnimalId = endangeredAnimalId;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        public static List<Sighting> all() {
          String sql = "SELECT id, firstName, stylistId FROM sightings";
          try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
          }
        }
        @Override
        public boolean equals(Object otherClient){
          if (!(otherClient instanceof Sighting)) {
            return false;
          } else {
            Sighting newClient = (Sighting) otherClient;
            return this.getRangerName().equals(newClient.getRangerName()) && this.getId() == newClient.getId();

          }
        }

        public void save() {
          try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings(animalId, endangeredAnimalId, rangerName, location) VALUES (:animalId, :endangeredAnimalId, :rangerName, :location)";
            this.id = (int) con.createQuery(sql, true)
              .addParameter("animalId", this.animalId)
              .addParameter("endangeredAnimalId", this.endangeredAnimalId)
              .addParameter("rangerName", this.rangerName)
              .addParameter("location", this.location)
              .executeUpdate()
              .getKey();
          }
        }
        public static Sighting find(int id) {
          try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sighting sighting = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Sighting.class);
            return sighting;
          }
        }

        public void update(int animalId, int endangeredAnimalId, String rangerName, String location) {
          try(Connection con = DB.sql2o.open()) {
          String sql = "UPDATE sightings SET animalId = :animalId, endangeredAnimalId = :endangeredAnimalId, rangerName = :rangerName, location = :location WHERE id = :id";
          con.createQuery(sql)
                  .addParameter("animalId", this.animalId)
                  .addParameter("endangeredAnimalId", this.endangeredAnimalId)
                  .addParameter("rangerName", this.rangerName)
                  .addParameter("location", this.location)
            .executeUpdate();
          }
        }

        public void delete() {
          try(Connection con = DB.sql2o.open()) {
          String sql = "DELETE FROM sightings WHERE id = :id;";
          con.createQuery(sql)
            .addParameter("id", id)
            .executeUpdate();
          }
        }

}
