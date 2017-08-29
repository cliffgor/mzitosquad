import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

// a route that renders the home page
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("heros", request.session().attribute("heros"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/Hero", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    ArrayList<Hero> heros = request.session().attribute("heros");
    if (heros == null) {
      heros = new ArrayList<Hero>();
      request.session().attribute("heros", heros);
    }

    String description = request.queryParams("description");
    Hero newHero = new Hero(description);
    heros.add(newHero);

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   ProcessBuilder process = new ProcessBuilder();
   Integer port;
   if (process.environment().get("PORT") != null) {
       port = Integer.parseInt(process.environment().get("PORT"));
   } else {
       port = 4567;
   }

  setPort(port);


  }
}