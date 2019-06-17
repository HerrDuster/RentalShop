package com.systemnet.shop.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;


import javax.servlet.ServletContext;

import com.systemnet.shop.service.OrderService;
import com.systemnet.shop.service.ProductService;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceManager {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);
	public static ServiceManager getInstance(ServletContext context) {
		ServiceManager instance = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
		if (instance == null) {
			instance = new ServiceManager(context);
			context.setAttribute("SERVICE_MANAGER", instance);
		}
		return instance;
	}
	private final Properties applicationProperties = new Properties();
	private final BasicDataSource dataSource;
	private final ProductService productService;
	private final OrderService orderService;

	private BasicDataSource createDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDefaultAutoCommit(false);
		dataSource.setDriverClassName(getApplicationProperty("db.driver"));
		dataSource.setUrl(getApplicationProperty("db.url"));
		dataSource.setUsername(getApplicationProperty("db.username"));
		dataSource.setPassword(getApplicationProperty("db.password"));
		dataSource.setInitialSize(Integer.parseInt(getApplicationProperty("db.pool.initSize")));
		dataSource.setMaxActive(Integer.parseInt(getApplicationProperty("dp.pool.maxSize")));
		return dataSource;
	}

	public ProductService getProductService() {
		return productService;
	}


	public OrderService getOrderService() {
		return orderService;
	}


	public String getApplicationProperty(String key) {
		return applicationProperties.getProperty(key);
	}


	public void close() {
		try {
			dataSource.close();
		} catch (SQLException e) {
			LOGGER.error("Close datasorse faild :" + e.getMessage(),e);
		}
	}

	private ServiceManager(ServletContext context) {
		loadApplicationProperties();
		dataSource=createDataSource();
		productService = new ProductServiceImpl(dataSource);
		orderService = new OrderServiceImpl(dataSource);
	}
	
	private void loadApplicationProperties(){
		try(InputStream in = ServiceManager.class.getClassLoader().getResourceAsStream("application.properties")) {
			applicationProperties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
