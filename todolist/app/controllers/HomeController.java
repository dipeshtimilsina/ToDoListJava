package controllers;
import java.lang.Object;
import play.mvc.*;
import play.data.*;
import play.*;
import models.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok("Your Application is ready");
    }
    
    public static Result tasks() {
    	return ok(
    		    views.html.index.render(Task.all(), taskForm)
    		  );
      }
      
      public  Result newTask() {
    	  Form<Task> filledForm = taskForm.bindFromRequest();
    	  if(filledForm.hasErrors()) {
    	    return badRequest(
    	      views.html.index.render(Task.all(), filledForm)
    	    );
    	  } else {
    	    Task.create(filledForm.get());
    	    return redirect(routes.HomeController.tasks());  
    	  }
      }
      
      public  Result deleteTask(Long id) {
        return TODO;
      }
    
      static Form<Task> taskForm = Form.form(Task.class);
    

}
