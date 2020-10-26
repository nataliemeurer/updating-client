package com.nametag.sample.api;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/version")
@Produces(MediaType.APPLICATION_JSON)
public interface AssetVersionService {

    @POST
    @Path("/{assetId}/{assetVersion}")
    Response setAssetVersion(@HeaderParam("Authorization") String bearer, @PathParam("assetId") String assetId, @PathParam("assetVersion") String assetVersion);

    @GET
    @Path("/{assetId}")
    Response getAssetVersion(@HeaderParam("Authorization") String bearer, @PathParam("assetId") String assetId);
}
