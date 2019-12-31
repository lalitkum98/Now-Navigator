package com.glide.cs.now.navigator;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.glide.cs.api.rest.AbstractRESTResource;
import com.glide.cs.qlue.QlueApp;
import com.glide.rest.annotation.Description;
import com.glide.rest.annotation.Name;
import com.glide.rest.annotation.Version;
import com.glide.rest.domain.ServiceRequest;
import com.glide.rest.domain.ServiceResult;

@Name("Office Navigator Webhook")
@Path("/now/cs/navigator")
@Version(number = 1)
public class NowNavigatorWebhookResource extends AbstractRESTResource {
	private final NowNavigatorManager fNowNavigatorManager;

	public NowNavigatorWebhookResource(){
		fNowNavigatorManager = QlueApp.getComponent().getNowNavigatorManager();
	}

	@POST
	@Path("/path")
	@Description("Get Shortest Path")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ServiceResult processEvent(ServiceRequest request) {
		String payload = request.getRequestBodyAsString();
		return ok(fNowNavigatorManager.processRequest(payload));
	}


	@GET
	@Path("/locations")
	@Description("Get all listed locations")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ServiceResult getLocations(ServiceRequest request) {
		return ok(fNowNavigatorManager.processLookUp());
	}

	@GET
	@Path("/floor")
	@Description("Get floor layout")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ServiceResult getFloorLayout(ServiceRequest request) {
		return ok(fNowNavigatorManager.getFloorMatrix());
	}
}





