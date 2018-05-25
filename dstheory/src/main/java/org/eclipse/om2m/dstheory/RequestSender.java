package org.eclipse.om2m.dstheory;
 
import java.math.BigInteger;







import org.eclipse.om2m.commons.constants.Constants;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.Operation;
import org.eclipse.om2m.commons.constants.ResourceType;
import org.eclipse.om2m.commons.resource.AE;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.RequestPrimitive;
import org.eclipse.om2m.commons.resource.Resource;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.core.service.CseService;
 
public class RequestSender {
 
	public static CseService CSE;
	
	
	/**
	 * Private constructor to avoid creation of this object
	 */
	
	private RequestSender(){}
 
	public static ResponsePrimitive createResource(String targetId, Resource resource, int resourceType){
		RequestPrimitive request = new RequestPrimitive();
		request.setFrom(Constants.ADMIN_REQUESTING_ENTITY);
		request.setTo(targetId);
		System.out.println(request.getTo());
		request.setResourceType(BigInteger.valueOf(resourceType));
		request.setRequestContentType(MimeMediaType.OBJ);
		request.setReturnContentType(MimeMediaType.OBJ);
		request.setContent(resource);
		request.setOperation(Operation.CREATE);
		return CSE.doRequest(request);
	}
 
	public static ResponsePrimitive createAE(AE resource){
		return createResource("/" + Constants.CSE_ID, resource, ResourceType.AE);
	}
	
	public static ResponsePrimitive createINAE(AE resource){
		return createResource("/" + Constants.REMOTE_CSE_ID, resource, ResourceType.AE);
	}
 
	public static ResponsePrimitive createContainer(String targetId, Container resource){
		return createResource(targetId, resource, ResourceType.CONTAINER);
	}
 
	public static ResponsePrimitive createContentInstance(String targetId, ContentInstance resource){
		return createResource(targetId, resource, ResourceType.CONTENT_INSTANCE);
	}
	
	public static ResponsePrimitive getRequest(String targetId){
		RequestPrimitive request = new RequestPrimitive();
		request.setFrom(Constants.ADMIN_REQUESTING_ENTITY);
		request.setTo(targetId);
		request.setReturnContentType(MimeMediaType.OBJ);
		request.setOperation(Operation.RETRIEVE);
		request.setRequestContentType(MimeMediaType.OBJ);
		return CSE.doRequest(request);
	}
 
}