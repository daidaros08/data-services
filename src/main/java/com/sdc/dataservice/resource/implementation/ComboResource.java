package com.sdc.dataservice.resource.implementation;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
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
import com.sdc.dataservice.model.Combo;
import com.sdc.dataservice.repository.ComboRepository;
import com.sdc.dataservice.resource.definition.ComboResourceDefintion;
import com.sdc.dataservice.service.ComboService;

@RestController
@Path("/combo")
public class ComboResource extends BaseResource implements ComboResourceDefintion {

    @Autowired
    private ComboService comboService;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCombo(@QueryParam(OFFSET) @DefaultValue("0") Integer offset,
                                @QueryParam(LIMIT) @DefaultValue("100") Integer limit,
                                @QueryParam(SORT) String sort,
                                @QueryParam(ORDER) @DefaultValue("DESC") String order) {
        PaginatedResult<Combo> result = comboService.getAllCombos(offset, limit, sort, order);
        return Response.status(Response.Status.OK).
            entity(result)
            .build();
    }

    @GET
    @Override
    @Path("/{id}")
    public Response getComboById(@PathParam(ID) String id) {
        Combo combo = comboService.getById(id);
        return Response.status(Response.Status.OK)
            .entity(combo)
            .build();
    }

    @POST
    @Override
    public Response createCombo(Combo comboSave) {
        Combo combo = comboService.createCombo(comboSave);
        return Response.status(Response.Status.CREATED)
            .entity(combo)
            .build();
    }

    @PUT
    @Override
    @Path("/{id}")
    public Response updateCombo(@PathParam(ID) String id, Combo comboUpdate) {
        Combo combo = comboService.update(id, comboUpdate);
        return Response.status(Response.Status.ACCEPTED)
            .entity(combo)
            .build();
    }

    @DELETE
    @Override
    @Path("/{id}")
    public Response deleteCombo(@PathParam(ID) String id) {
        comboService.deleteAdmin(id);
        return Response.status(Response.Status.NO_CONTENT)
            .build();
    }
}
