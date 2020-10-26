package com.nametag.sample.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface VersionedStaticFileService {

    @GET
    @Path("/{assetId}")
    @Produces(MediaType.TEXT_HTML)
    Response serveAsset(@PathParam("assetId") String assetId);
}
