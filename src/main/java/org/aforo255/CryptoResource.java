package org.aforo255;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.aforo255.entity.Currency;
import org.aforo255.service.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/crypto")
public class CryptoResource {

	@Inject
	@RestClient
	CurrencyService service ; 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Currency> getCrypto (@QueryParam("id") String id)
	{				
		return service.getCurrency(id);		
	}
	
}
