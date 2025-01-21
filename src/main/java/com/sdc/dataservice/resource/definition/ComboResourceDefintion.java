package com.sdc.dataservice.resource.definition;

import javax.ws.rs.core.Response;
import com.sdc.dataservice.model.Combo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ComboResourceDefintion {

    @Operation(summary = "Return the set of Combo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getAllCombo(Integer offset, Integer limit, String sort, String order);

    @Operation(summary = "Return one Combo by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request successful"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response getComboById(String id);

    @Operation(summary = "Create a new Combo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created"),
        @ApiResponse(responseCode= "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response createCombo(Combo comboSave);

    @Operation(summary = "Update a Combo by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully updated"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response updateCombo (String id, Combo combouUpdate);

    @Operation(summary = "Delete a Combo by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully deleted"),
        @ApiResponse(responseCode = "400", description = "Request with invalid information"),
        @ApiResponse(responseCode = "500", description = "Service error")
    })
    Response deleteCombo(String id);
}
