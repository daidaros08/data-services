package com.sdc.dataservice.resource.definition;

import javax.ws.rs.core.Response;

import com.sdc.dataservice.model.Grill;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface GrillResourceDefinition {

    @Operation(summary = "Return the set of Grills")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getAllGrills(Integer offset, Integer limit, String sort, String order);

    @Operation(summary = "Return one Grill by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getGrillsById(String id);

    @Operation(summary = "Create a new Grill")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response createGrills(Grill grillSave);

    @Operation(summary = "Update a Grill by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response updateGrills(String id, Grill grillUpdate);

    @Operation(summary = "Delete a Grill by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response deleteGrills(String id);
}
