# Simple Updating Client

This repository contains a basic dropwizard service that supports three primary functions:
1. Uploading .html files to the server with a declared version and asset identifier.
2. Setting and getting the accessible version of deployed assets.
3. Serving the static asset for the active version.

In its simple state, the service only uses the local file system for storing asset files in the fformat: assets/{assetId}/{assetVersion}/{assetVersion}.html.

Versions are stored in a simple version.txt file in the assetId folder.

## Running the Server

The simplest way to run the service is with IntelliJ. Simply run `./gradlew idea` from the repository root and then `open *.ipr` (assuming you have intelliJ installed).

The service is runnable from `com.nametag.sample.SimpleUpdateServerApplication` with a run configuration specifying the following program arguments: `server src/main/resources/configuration.yml`.

## Using the Service

### Upload a new .html asset

`curl -X POST http://localhost:8080/api/upload/{assetId}/{version} -H "Authorization: Bearer soopersekrit" -F file=path/to/file.html`

### Set and get versions for assets

Set Version

`curl -X POST http://localhost:8080/api/version/updating-client/{version} -H "Authorization: Bearer soopersekrit"`

Get Version

`curl http://localhost:8080/api/version/updating-client`

### Load the Active Asset in the browser
Navigate to: http://localhost:8080/updating-client (the last param is the asset id)

Note that the server can support a variety of different html pages if uploaded under distinct assetIds.