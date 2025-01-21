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
import com.sdc.dataservice.model.Drinks;
import com.sdc.dataservice.resource.definition.DrinksResourceDefinition;
import com.sdc.dataservice.service.DrinksService;


@RestController
@Path("/drinks")
public class DrinkResource extends BaseResource implements DrinksResourceDefinition {

    @Autowired
    private DrinksService drinksService;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDrinks(@QueryParam(OFFSET) Integer offset,
                                 @QueryParam(LIMIT) Integer limit,
                                 @QueryParam(SORT) String sort,
                                 @QueryParam(ORDER) String order) {
        PaginatedResult<Drinks> response = drinksService.getAllDrinks(offset, limit, sort, order);
        return Response.status(Response.Status.OK)
            .entity(response)
            .build();
    }

    @GET
    @Override
    @Path("/{id}")
    public Response getDrinkById(@PathParam(ID) String id) {
        Drinks drinks = drinksService.getById(id);
        return Response.status(Response.Status.OK)
            .entity(drinks)
            .build();
    }

    @POST
    @Override
    public Response createDrink(Drinks drinkSave) {
        Drinks drinks = drinksService.createDrink(drinkSave);
        return Response.status(Response.Status.CREATED)
            .entity(drinks)
            .build();
    }

    @PUT
    @Override
    @Path("/{id}")
    public Response updateDrink(@PathParam(ID) String id, Drinks drinkUpdate) {
        Drinks drinks = drinksService.update(id, drinkUpdate);
        return Response.status(Response.Status.ACCEPTED)
            .entity(drinks)
            .build();
    }

    @DELETE
    @Override
    @Path("/{id}")
    public Response deleteDrink(@PathParam(ID) String id) {
        drinksService.deleteAdmin(id);
        return Response.status(Response.Status.NO_CONTENT)
            .build();
    }
}
