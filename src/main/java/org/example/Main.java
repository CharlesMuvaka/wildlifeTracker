package org.example;

import org.example.models.*;
import spark.Spark.*;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import static spark.Spark.*;

public class Main {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
       public static void main(String[] args) {

           port(getHerokuAssignedPort());
        staticFileLocation("/public");



        //Getting the index page
        get("/",(request,response)->{
            Map<String, Object> templateData = new HashMap<>();
            return new ModelAndView(templateData,"index.hbs");

        }, new HandlebarsTemplateEngine());

        //Getting rare species form
        get("/form",(request,response)->{
            Map<String, Object> templateData = new HashMap<>();
            return new ModelAndView(templateData,"form.hbs");

        }, new HandlebarsTemplateEngine());


           //Getting Normal species form
        get("/formNormal",(request,response)->{
               Map<String, Object> templateData = new HashMap<>();
               return new ModelAndView(templateData,"form2.hbs");

        }, new HandlebarsTemplateEngine());



           //Getting all animals
        get("/animal",(request,response)->{
            Map<String, Object> templateData = new HashMap<>();
            NormalAnimalDao normalAnimalDao  = new NormalAnimalDao();
            List<NormalAnimal> allAnimals = normalAnimalDao.allAnimals();

            templateData.put("animals", allAnimals);

            return new ModelAndView(templateData,"animal.hbs");

        }, new HandlebarsTemplateEngine());

        //getting rare species
           get("/rare",(request,response)->{
               Map<String, Object> templateData = new HashMap<>();
               RareAnimalDao rareAnimalDao = new RareAnimalDao();
               List<RareAnimal> rareAnimals = rareAnimalDao.rareAnimals();

               templateData.put("rareAnimals", rareAnimals);

               return new ModelAndView(templateData,"rarespecies.hbs");

           }, new HandlebarsTemplateEngine());


        //getting sighting data of normal animal
        post("/animalNormal", (request, response)->{
               Map<String, Object> templateData = new HashMap<>();
               String animalName = request.queryParams("sightAnimalName");
               String animalType = request.queryParams("sightAnimalType");
               String ranger = request.queryParams("rangerName");
               String location = request.queryParams("locationName");


               Sighting sight = new Sighting(animalName, animalType,location,ranger,"","");
               SightDao sightDao = new SightDao();
               sightDao.addSighting(sight);





               NormalAnimal normalAnimal = new NormalAnimal(animalName);
               NormalAnimalDao normalAnimalDao = new NormalAnimalDao();
               normalAnimalDao.addAnimal(normalAnimal);



            List<Sighting> allSights = sightDao.getAllSightings();

            templateData.put("allSights", allSights);
            System.out.println(allSights);
            return new ModelAndView(templateData,"sightings.hbs");

        },new HandlebarsTemplateEngine());


//        getting sighting data of normal animal
           post("/animal", (request, response)->{
               Map<String, Object> templateData = new HashMap<>();
               String animalName = request.queryParams("sightAnimalName");
               String animalType = request.queryParams("sightAnimalType");
               String ranger = request.queryParams("rangerName");
               String location = request.queryParams("locationName");
               String age = request.queryParams("sightAnimalAge");
               String health = request.queryParams("sightAnimalHealth");

               Sighting sight = new Sighting(animalName, animalType,location,ranger,age,health);
               SightDao sightDao = new SightDao();
               sightDao.addSighting(sight);





               RareAnimal normalAnimal = new RareAnimal(health,animalName,age);
               RareAnimalDao rareAnimalDao = new RareAnimalDao();
               rareAnimalDao.addAnimal(normalAnimal);



               List<Sighting> allSights = sightDao.getAllSightings();

               templateData.put("allSights", allSights);
               System.out.println(allSights);
               return new ModelAndView(templateData,"sightings.hbs");

           },new HandlebarsTemplateEngine());

        //getting all sightings
           get("/sighting",(request,response)->{
            Map<String, Object> templateData = new HashMap<>();
            SightDao sightDao = new SightDao();
            List<Sighting> allSights = sightDao.getAllSightings();

            templateData.put("allSights", allSights);
            System.out.println(allSights);
            return new ModelAndView(templateData,"sightings.hbs");



        }, new HandlebarsTemplateEngine());

           get("/recent",(request,response)->{
               Map<String, Object> templateData = new HashMap<>();
               SightDao sightDao = new SightDao();
               List<Sighting> allSights = sightDao.getAllSightingsReverse();

               templateData.put("allSights", allSights);
               System.out.println(allSights);
               return new ModelAndView(templateData,"recent.hbs");



           }, new HandlebarsTemplateEngine());

        //getting all locations
           get("/location",(request,response)->{
               Map<String, Object> templateData = new HashMap<>();
               LocationDao locationDao = new LocationDao();
               List<Location> allLocations = locationDao.getAllLocations();


               templateData.put("allLocs", allLocations);

               return new ModelAndView(templateData,"location.hbs");



           }, new HandlebarsTemplateEngine());



    }
}