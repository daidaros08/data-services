package com.sdc.dataservice.resource.definition;

import javax.ws.rs.core.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.sdc.dataservice.model.Drinks;

public interface DrinksResourceDefinition {

    @Operation(summary = "Return the set of Drinks")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getAllDrinks(Integer offset, Integer limit, String sort, String order);

    @Operation(summary = "Return one Drink by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getDrinkById(String id);

    @Operation(summary = "Create a new Drink")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response createDrink(Drinks drinkSave);

    @Operation(summary = "Update a Drink by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response updateDrink (String id, Drinks drinkUpdate);

    @Operation(summary = "Delete a Drink by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response deleteDrink(String id);
}
