package com.edu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.edu.interfaz.Operaciones;

@Configuration
@ComponentScan("com.edu")
public class AppConfig {
	
	@Bean("suma")
	public Operaciones servicioOperaciones(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/Operaciones");
		rmiProxyFactoryBean.setServiceInterface(Operaciones.class);
		rmiProxyFactoryBean.afterPropertiesSet();
		return (Operaciones) rmiProxyFactoryBean.getObject();
		
	}
	
}
