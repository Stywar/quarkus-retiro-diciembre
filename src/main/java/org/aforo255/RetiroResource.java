package org.aforo255;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.aforo255.entity.Transaction;
import org.aforo255.service.ITransactionService;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;
@Path("/retiro")
public class RetiroResource {

	
	public static Logger LOGGER = Logger.getLogger(RetiroResource.class.getSimpleName());
	
	@Inject
	ITransactionService service ; 
	
	@Inject
	@Channel("transactions")
	Emitter<Transaction> emitter ;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response saveTransaction (Transaction transaction) {
		
		 LOGGER.info("executed saveTransaction");
			
			Transaction trx = transaction; 
			Map<String , Object> response =  new HashMap<>();
			trx=service.save(trx);	
		    emitter.send(trx);		
			response.put("mensaje", "Transacción realizada !!");
			response.put("Transaccion", trx);
			LOGGER.info("find saveTransaction");
			return Response.status(Status.CREATED).entity(response).build();
	}
	
	
}
