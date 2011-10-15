package info.isann.slim3.sample.controller.sample;

import info.isann.slim3.sample.service.sample.SampleService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private SampleService service = new SampleService();
    
    @Override
    public Navigation run() throws Exception {
        String message = service.getMessage();
        requestScope("message", message);
        return forward("index.vm");
    }
}
