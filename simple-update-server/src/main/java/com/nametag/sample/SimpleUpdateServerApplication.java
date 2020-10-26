package com.nametag.sample;

import com.nametag.sample.resources.VersionedStaticFileResource;
import com.nametag.sample.resources.AssetUploadResource;
import com.nametag.sample.resources.AssetVersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

public class SimpleUpdateServerApplication extends Application<SimpleUpdateServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new SimpleUpdateServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "update-server";
    }

    @Override
    public void run(SimpleUpdateServerConfiguration configuration, Environment environment) {

        environment.jersey().register(new AssetVersionResource(configuration.getAdminSecret()));
        environment.jersey().register(new AssetUploadResource(configuration.getAdminSecret()));
        environment.jersey().register(new VersionedStaticFileResource());
        environment.jersey().register(MultiPartFeature.class);
    }
}
