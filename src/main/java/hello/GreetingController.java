package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.*;
import solver.*;
import solver.graphical_method.GraphicalMethod;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/test")
    public Solution test() throws Exception {
    	 Model m=new Model(Model.MAXIMIZE);
         m.addVariable("X1", Variable.CONTINUOUS, 4);
         m.addVariable("X2", Variable.CONTINUOUS, 6);
         m.addConstraint(new double[]{-1,1}, Constraint.LESS_OR_EQUAL, 11, "");
         m.addConstraint(new double[]{1,1}, Constraint.LESS_OR_EQUAL, 27, "");
         m.addConstraint(new double[]{2,5}, Constraint.LESS_OR_EQUAL, 90, "");
         Solver s=new GraphicalMethod();
         return s.solve(m);
    	
    	
    }
}
