package com.nametag.sample.resources;

import com.nametag.sample.util.EndpointUtils;
import com.nametag.sample.api.AssetVersionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

import java.io.*;
import java.nio.file.Paths;

import static com.nametag.sample.util.EndpointUtils.assetAndVersionExist;

public class AssetVersionResource implements AssetVersionService {

    private static final Logger log = LoggerFactory.getLogger(AssetVersionResource.class);

    private final String uploadSecret;

    public AssetVersionResource(final String uploadSecret) {
        this.uploadSecret = uploadSecret;
    }

    @Override
    public Response setAssetVersion(String bearer, String assetId, String assetVersion) {
        if (EndpointUtils.isInvalidAuthHeader(bearer, uploadSecret)) {
            return EndpointUtils.unauthorizedResponse();
        }
        if (!assetAndVersionExist(assetId, assetVersion)) {
            return EndpointUtils.badRequestResponse("Asset or version does not exist. Please upload an asset first.");
        }
        try {
            File fi = EndpointUtils.getVersionFile(assetId);
            fi.createNewFile();
            try (FileWriter out = new FileWriter(fi)) {
                out.write(assetVersion);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return EndpointUtils.successResponse();
        } catch (IOException ex) {
            log.error("Unable to create file.");
            return Response.serverError().build();
        }
    }

    @Override
    public Response getAssetVersion(String bearer, String assetId) {
        if (EndpointUtils.isInvalidAuthHeader(bearer, uploadSecret)) {
            return EndpointUtils.unauthorizedResponse();
        }
        if (!EndpointUtils.assetExists(assetId)) {
            return EndpointUtils.badRequestResponse("Asset or version does not exist. Please upload an asset first.");
        }
        return EndpointUtils.getAssetVersion(assetId).map(version ->
                Response.ok().entity(version).build()
        ).orElse(Response.serverError().build());
    }
}
