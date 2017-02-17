package com.hibernateExample;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Path("/api")
public class MyResource {
 
    @GET
    @Path("/signature")
    @Produces("application/json")
    public List<Form> getForm() {
    	System.out.println("in my resource");
        FormDAO dao = new FormDAO();
        List<Form> form = dao.getForm();
        return form;
    }
 
    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addForm(Form form) {
        FormDAO dao = new FormDAO();
        dao.addForm(form);
        return Response.ok().build();
    }
   
}
