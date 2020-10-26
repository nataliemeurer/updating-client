package com.nametag.sample.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

public class EndpointUtils {

    public static final Logger log = LoggerFactory.getLogger(EndpointUtils.class);

    // cannot be instantiated
    private EndpointUtils() {}

    public static boolean isInvalidAuthHeader(String header, String secret) {
        return header == null || !header.endsWith(secret);
    }

    public static boolean assetExists(String assetId) {
        return Paths.get("assets", assetId).toFile().exists();
    }

    public static boolean assetAndVersionExist(String assetId, String assetVersion) {
        return Paths.get("assets", assetId, assetVersion).toFile().exists();
    }

    public static Optional<String> getAssetVersion(String assetId) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getVersionFile(assetId)))){
            return Optional.of(bufferedReader.readLine());
        } catch (IOException ex) {
            log.error("Unable to retrieve version status.", ex);
            return Optional.empty();
        }
    }

    public static File getVersionFile(String assetId) {
        return Paths.get("assets", assetId, "version.txt").toFile();
    }

    public static Response unauthorizedResponse() {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Unauthorized: The uploaded secret does not match the server secret.")
                .build();
    }

    public static Response badRequestResponse(String message) {
        return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
    }

    public static Response successResponse() {
        return Response.status(Response.Status.OK).build();
    }
}
