package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready." + TLocalTest.SINGLETON.op()));
    }
  
}
