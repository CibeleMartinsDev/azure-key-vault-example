package org.martins.rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.martins.service.KeyVaultService;

@Path("/api/v1/key-vault")
@Produces(MediaType.APPLICATION_JSON)
public class KeyVaultResource {

    @Inject
    KeyVaultService keyVaultService;

    @GET
    public Response getSecret() throws Exception {
        return Response.ok(keyVaultService.getSecret()).build();
    }
}
