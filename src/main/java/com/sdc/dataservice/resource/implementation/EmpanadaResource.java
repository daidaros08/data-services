package com.sdc.dataservice.resource.implementation;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.sdc.data.resource.BaseResource;
import com.sdc.data.service.pagination.PaginatedResult;
import com.sdc.dataservice.model.Empanada;
import com.sdc.dataservice.resource.definition.EmpanadaResourceDefinition;
import com.sdc.dataservice.service.EmpanadaService;

@RestController
@Path("/empanada")
public class EmpanadaResource extends BaseResource implements EmpanadaResourceDefinition {

    @Autowired
    private EmpanadaService empanadaService;

    @GET
    @Override
    public Response getAllEmpanadas(@QueryParam(OFFSET) Integer offset,
                                    @QueryParam(LIMIT) Integer limit,
                                    @QueryParam(SORT) String sort,
                                    @QueryParam(ORDER) String order) {
        PaginatedResult<Empanada> response = empanadaService.getAllEmpanadas(offset, limit, sort, order);
        return Response.status(Response.Status.OK)
            .entity(response)
            .build();
    }

    @GET
    @Path("/{id}")
    @Override
    public Response getEmpanadaById(@PathParam(ID) String id) {
        Empanada empanada = empanadaService.getById(id);
        return Response.status(Response.Status.OK)
            .entity(empanada)
            .build();
    }

    @POST
    @Override
    public Response createEmpanada(Empanada empanadaSave) {
        Empanada empanada = empanadaService.createEmpanada(empanadaSave);
        return Response.status(Response.Status.CREATED)
            .entity(empanada)
            .build();
    }

    @PUT
    @Path("/{id}")
    @Override
    public Response updateEmpanada(@PathParam(ID) String id, Empanada empanadaUpdate) {
        Empanada empanada = empanadaService.update(id, empanadaUpdate);
        return Response.status(Response.Status.ACCEPTED)
            .entity(empanada)
            .build();
    }

    @DELETE
    @Path("/{id}")
    @Override
    public Response deleteEmpanada(@PathParam(ID) String id) {
        empanadaService.deleteAdmin(id);
        return Response.status(Response.Status.NO_CONTENT)
            .build();
    }
}
