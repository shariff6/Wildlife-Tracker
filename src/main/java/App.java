import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        setPort(port);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            model.put("animals", Animal.all());
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals/new-animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animal", Animal.all());
            model.put("template", "templates/animal-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            Boolean endangered = Boolean.parseBoolean(request.queryParams("endangered"));
            Animal newAnimal = new Animal(name, endangered);
            newAnimal.save();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.params(":id")));
            model.put("animal", animal);
            model.put("template", "templates/animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.queryParams("animalId")));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            int endangeredAnimalId = Integer.parseInt(request.queryParams("endangeredAnimalId"));
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sighting newSighting = new Sighting(animalId, endangeredAnimalId, rangerName, location);
            newSighting.save();
            model.put("animal", animal);
            model.put("template", "templates/animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/animals/:animal_id/sightings/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting sighting = Sighting.find(Integer.parseInt(request.params("id")));
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            int endangeredAnimalId = Integer.parseInt(request.queryParams("endangeredAnimalId"));
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Animal animal = Animal.find(sighting.getAnimalId());
            sighting.update(animalId, endangeredAnimalId, rangerName, location);
            String url = String.format("/animals/%d/sightings/%d", animal.getId(), sighting.getId());
            model.put("template", "templates/sighting.vtl");
            response.redirect(url);
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/animals/:animal_id/sightings/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.params(":animal_id")));
            Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
            model.put("animal", animal);
            model.put("sighting", sighting);
            model.put("animals", Animal.all());
            model.put("template", "templates/sighting.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/animals/:animal_id/sightings/:id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting sighting = Sighting.find(Integer.parseInt(request.params("id")));
            Animal animal = Animal.find(sighting.getAnimalId());
            sighting.delete();
            model.put("animal", animal);
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        post("/animals/:animal_id/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.params(":animal_id")));
            animal.delete();
            model.put("animal", animal);
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("sightings", Sighting.all());
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        get("/sightings/new-sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("sightings", Sighting.all());
            model.put("template", "templates/new-sighting.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}
