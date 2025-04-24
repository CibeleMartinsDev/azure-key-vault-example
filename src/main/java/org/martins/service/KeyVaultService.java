package org.martins.service;


import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class KeyVaultService {


    @ConfigProperty(name = "akv-example.secret-name")
    private String secretName;

    @Inject
    SecretClient secretClient;


    public String getSecret() throws Exception {
        try {
            return secretClient.getSecret(secretName).getName();
        }catch (Exception e ) {
            throw new Exception("Houve um problema ao acessar o secret no cofre de chaves, tente novamente em instantes.");
        }
    }
}
