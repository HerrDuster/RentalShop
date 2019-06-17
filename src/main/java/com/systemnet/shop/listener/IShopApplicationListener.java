package com.systemnet.shop.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.systemnet.shop.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.systemnet.shop.service.impl.ServiceManager;


@WebListener
public class IShopApplicationListener implements ServletContextListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(IShopApplicationListener.class);
	private ServiceManager serviceManager;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			serviceManager = ServiceManager.getInstance(sce.getServletContext());
			sce.getServletContext().setAttribute(Constants.CATEGORY_LIST, serviceManager.getProductService().listAllCategotires());
			sce.getServletContext().setAttribute(Constants.PRODUCER_LIST, serviceManager.getProductService().listAllProducer());
		} catch (RuntimeException e) {
			LOGGER.error("Web application 'shop' init failed: "+e.getMessage(), e);
			throw e;
		}
		LOGGER.info("Web application 'shop' initialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		serviceManager.close();
		LOGGER.info("Web application 'shop' destroyed");
	}
}
