package com.nametag.sample.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;

@Path("/api/upload")
public interface AssetUploadService {

    @POST
    @Path("/{assetId}/{assetVersion}")
    @Produces(MediaType.APPLICATION_JSON)
    Response uploadAsset(@HeaderParam("Authorization") String bearer,
                         @PathParam("assetId") String assetId,
                         @PathParam("assetVersion") String assetVersion,
                         @FormDataParam("file") FileInputStream fileData,
                         @FormDataParam("file") FormDataContentDisposition fileMetadata);
}
