package org.patrickkabongo;

import org.patrickkabongo.model.Employee;
import org.patrickkabongo.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    public Response getEmployees() {

        return Response.status(Response.Status.OK)
                .entity(employeeService.getEmployees()).build();
    }

    @POST
    public Response addEmployee(Employee employee){

        return Response.status(Response.Status.CREATED)
                .entity(employeeService.addEmployee(employee)).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEmployee(@PathParam("id") Long id, Employee employee){

        return Response.status(Response.Status.CREATED)
                .entity(employeeService.updateEmployee(id, employee)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployee(@PathParam("id") Long id){

        return Response.status(Response.Status.OK)
                .entity(employeeService.deleteEmployee(id)).build();
    }
}