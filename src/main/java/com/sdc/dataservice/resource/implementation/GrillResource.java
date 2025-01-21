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
import com.sdc.dataservice.model.Grill;
import com.sdc.dataservice.resource.definition.GrillResourceDefinition;
import com.sdc.dataservice.service.GrillService;

@RestController
@Path("/grill")
public class GrillResource extends BaseResource implements GrillResourceDefinition {

    @Autowired
    private GrillService grillService;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGrills(@QueryParam(OFFSET) Integer offset,
                                @QueryParam(LIMIT) Integer limit,
                                @QueryParam(SORT) String sort,
                                @QueryParam(ORDER) String order) {
        PaginatedResult<Grill> response = grillService.getAllGrills(offset, limit, sort, order);
        return Response.status(Response.Status.OK)
            .entity(response)
            .build();
    }

    @GET
    @Override
    @Path("/{id}")
    public Response getGrillsById(@PathParam(ID) String id) {
        Grill grill = grillService.getById(id);
        return Response.status(Response.Status.OK)
            .entity(grill)
            .build();
    }

    @POST
    @Override
    public Response createGrills(Grill grillSave) {
        Grill grill = grillService.createGrill(grillSave);
        return Response.status(Response.Status.CREATED)
            .entity(grill)
            .build();
    }

    @PUT
    @Override
    @Path("/{id}")
    public Response updateGrills(@PathParam(ID) String id, Grill grillUpdate) {
        Grill grill = grillService.update(id, grillUpdate);
        return Response.status(Response.Status.ACCEPTED)
            .entity(grill)
            .build();
    }

    @DELETE
    @Override
    @Path("/{id}")
    public Response deleteGrills(@PathParam(ID) String id) {
        grillService.deleteAdmin(id);
        return Response.status(Response.Status.NO_CONTENT)
            .build();
    }
}
