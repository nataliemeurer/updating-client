package com.nametag.sample.resources;

import com.nametag.sample.api.VersionedStaticFileService;
import com.nametag.sample.util.EndpointUtils;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class VersionedStaticFileResource implements VersionedStaticFileService {

    @Override
    public Response serveAsset(String assetId) {
        if (EndpointUtils.assetExists(assetId)) {
            return EndpointUtils.getAssetVersion(assetId).map(
                    version -> {
                        try (BufferedReader reader = new BufferedReader(
                                new FileReader(
                                        Paths.get("assets", assetId, version, version + ".html").toFile()
                                )
                        )) {
                            return Response.ok().entity(reader.lines().collect(Collectors.joining())).build();
                        } catch (IOException ex) {
                            return Response.serverError().build();
                        }
                    }
            ).orElse(EndpointUtils.badRequestResponse("No existing asset with id: " + assetId));
        } else {
            return EndpointUtils.badRequestResponse("No existing asset with id: " + assetId);
        }
    }
}
