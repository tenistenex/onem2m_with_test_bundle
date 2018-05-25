package org.eclipse.om2m.dstheory;

import org.eclipse.om2m.core.service.CseService;
import org.eclipse.om2m.dstheory.controller.Controller;
import org.eclipse.om2m.dstheory.controller.LifeCycleManager;
import org.eclipse.om2m.dstheory.controller.Monitor;
import org.eclipse.om2m.interworking.service.InterworkingService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
 
public class Activator implements BundleActivator {
 
	private static BundleContext context;
 
	private Monitor monitor;
	
	private static Log logger = LogFactory.getLog(Activator.class);
 
	static BundleContext getContext() {
		return context;
	}
 
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("***************Starting D-S Theory*************************");
		new ServiceTracker<Object, Object>(bundleContext, CseService.class.getName(), null){
 
			@Override
			public Object addingService(ServiceReference<Object> reference) {
				final CseService cse = (CseService) this.context.getService(reference);
				if(cse != null){
					RequestSender.CSE = cse;
					new Thread(){
						public void run() {
							LifeCycleManager.start();
							if (monitor == null){
								monitor = new Monitor(cse);
								monitor.start();								
							}
						};
					}.start();
				}
				return cse;	
			}
 
			public void removedService(org.osgi.framework.ServiceReference<Object> reference, Object service) {
				if(monitor != null){
					monitor.stop();
					monitor = null;
				}		
			};
 
		}.open();
		
		logger.info("Register D-S Theory service..");
		bundleContext.registerService(InterworkingService.class.getName(), new Controller(), null);
		logger.info("Register D-S Theory service is registered.");
	}
 
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Stopping Sample Ipe");
		if(monitor != null){
			monitor.stop();
			monitor = null;
		}
	}
 
}