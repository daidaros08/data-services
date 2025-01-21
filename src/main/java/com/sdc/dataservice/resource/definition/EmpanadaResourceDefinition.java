package com.sdc.dataservice.resource.definition;

import javax.ws.rs.core.Response;
import com.sdc.dataservice.model.Empanada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EmpanadaResourceDefinition {

    @Operation(summary = "Return the set of Empanadas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getAllEmpanadas(Integer offset, Integer limit, String sort, String order);

    @Operation(summary = "Return one Empanada by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getEmpanadaById(String id);

    @Operation(summary = "Create a new Empanada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response createEmpanada(Empanada empanadaSave);

    @Operation(summary = "Update a Empanada by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response updateEmpanada (String id, Empanada empanadaUpdate);

    @Operation(summary = "Delete a Empanada by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response deleteEmpanada(String id);
}
