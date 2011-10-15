package info.isann.slim3.sample.controller.json.solr;

import info.isann.slim3.sample.controller.json.JsonController;

import java.util.HashMap;
import java.util.Map;


public class Get_queueController extends JsonController {

//    public static RegisterService service = new RegisterService();

    @Override
    protected Map<String, Object> handle() throws Exception {
//        List<SolrRequestQueue> entityList = service.getRequestQueue();
        Map<String, Object> json = new HashMap<String, Object>();
//        json.put("queue", entityList);
        return json;
    }
}
