package org.eclipse.om2m.dstheory.controller;
 
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.resource.RequestPrimitive;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.dstheory.util.ObixUtil;
import org.eclipse.om2m.interworking.service.InterworkingService;
 
public class Controller implements InterworkingService{
 
	@Override
	public ResponsePrimitive doExecute(RequestPrimitive request) {
		String[] parts = request.getTo().split("/");
		String appId = parts[3];
		ResponsePrimitive response = new ResponsePrimitive(request);
 
		if(request.getQueryStrings().containsKey("op")){
			String valueOp = request.getQueryStrings().get("op").get(0);
 
			switch(valueOp){
			case "get":
				if(appId.equals("test")){
					response.setContent(ObixUtil.getSensorDataRep(1));
					response.setResponseStatusCode(ResponseStatusCode.OK);
				} else if (appId.equals("test1")){
					response.setContent(ObixUtil.getActuatorDataRep(true));
					response.setResponseStatusCode(ResponseStatusCode.OK);
				} else {
					response.setResponseStatusCode(ResponseStatusCode.BAD_REQUEST);
				}
				return response;
			case "true": case "false":
				if(appId.equals("test")){
					
					response.setResponseStatusCode(ResponseStatusCode.OK);
				} else {
					response.setResponseStatusCode(ResponseStatusCode.BAD_REQUEST);
				}
				return response;
			default:
				response.setResponseStatusCode(ResponseStatusCode.BAD_REQUEST);
			}
		} else {
			response.setResponseStatusCode(ResponseStatusCode.BAD_REQUEST);
		}
		return response;
	}
 
	@Override
	public String getAPOCPath() {
		return Monitor.applicationNAME;
	}
 
}