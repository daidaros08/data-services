package com.sdc.dataservice.resource.implementation;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.sdc.data.resource.BaseResource;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Fries;
import com.sdc.dataservice.resource.definition.FriesResourceDefinition;
import com.sdc.dataservice.service.FriesService;

@RestController
@Path("/fries")
public class FriesResource extends BaseResource implements FriesResourceDefinition {

    @Autowired
    private FriesService friesService;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFries(@QueryParam(OFFSET) Integer offset,
                                 @QueryParam(LIMIT) Integer limit,
                                 @QueryParam(SORT) String sort,
                                 @QueryParam(ORDER) String order) {
        PaginatedResult<Fries> response = friesService.getAllFries(offset, limit, sort, order);
        return Response.status(Response.Status.OK)
            .entity(response)
            .build();
    }

    @GET
    @Override
    @Path("/{id}")
    public Response getFriesById(@PathParam(ID) String id) {
        Fries fries = friesService.getById(id);
        return Response.status(Response.Status.OK)
            .entity(fries)
            .build();
    }

    @POST
    @Override
    public Response createFries(Fries friesSave) {
        Fries fries = friesService.createFries(friesSave);
        return Response.status(Response.Status.CREATED)
            .entity(fries)
            .build();
    }

    @PUT
    @Override
    @Path("/{id}")
    public Response updateFries(@PathParam(ID) String id, Fries friesUpdate) {
        Fries fries = friesService.update(id, friesUpdate);
        return Response.status(Response.Status.ACCEPTED)
            .entity(fries)
            .build();
    }

    @DELETE
    @Override
    @Path("/{id}")
    public Response deleteFries(@PathParam(ID) String id) {
        friesService.deleteAdmin(id);
        return Response.status(Response.Status.NO_CONTENT)
            .build();
    }
}
