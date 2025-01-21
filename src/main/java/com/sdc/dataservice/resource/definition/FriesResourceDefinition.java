package com.sdc.dataservice.resource.definition;

import javax.ws.rs.core.Response;

import com.sdc.dataservice.model.Fries;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface FriesResourceDefinition {

    @Operation(summary = "Return the set of Fries")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getAllFries(Integer offset, Integer limit, String sort, String order);

    @Operation(summary = "Return one Frie by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getFriesById(String id);

    @Operation(summary = "Create a new Frie")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response createFries(Fries friesSave);

    @Operation(summary = "Update a Frie by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response updateFries(String id, Fries friesUpdate);

    @Operation(summary = "Delete a Frie by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response deleteFries(String id);
}
