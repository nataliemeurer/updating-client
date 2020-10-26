package com.nametag.sample.resources;

import com.nametag.sample.util.EndpointUtils;
import com.nametag.sample.api.AssetUploadService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Paths;

public class AssetUploadResource implements AssetUploadService {
    
    private static final Logger log = LoggerFactory.getLogger(AssetUploadService.class);
    
    private final String uploadSecret;

    public AssetUploadResource(final String uploadSecret) {
        this.uploadSecret = uploadSecret;
    }

    @Override
    public Response uploadAsset(String bearer,
                                String assetId,
                                String assetVersion,
                                FileInputStream fileData,
                                FormDataContentDisposition fileMetadata) { ;
        if (EndpointUtils.isInvalidAuthHeader(bearer, uploadSecret)) {
            return EndpointUtils.unauthorizedResponse();
        }
        if (!validParams(assetId, assetVersion, fileMetadata)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        processInputStream(assetId, assetVersion, fileData);
        return EndpointUtils.successResponse();
    }

    private boolean validParams(String assetId, String assetVersion, FormDataContentDisposition fileMetadata) {
        return true;
    }

    private void processInputStream(String assetId, String assetVersion, FileInputStream fileData) {
        File targetFile = Paths.get("assets", assetId, assetVersion, assetVersion + ".html").toFile();
        createPathIfNonExistent(targetFile);
        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            fileData.transferTo(outStream);
        } catch (FileNotFoundException ex) {
            // should not be hit because we create the necessary files above.
            log.error("File not found.", ex);
        } catch (IOException ex) {
            log.error("Unable to copy the uploaded file to target location.", ex);
        }
    }

    private void createPathIfNonExistent(File targetFile) {
        try{
            targetFile.getParentFile().mkdirs();
            targetFile.createNewFile();
        } catch (IOException ex) {
            log.error("Failed to create new files.");
        }
    }
}
