package com.cngc.boot.data.etl;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EtlInitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            KettleEnvironment.init();
        } catch (KettleException e) {
            throw new RuntimeException("etl engine started fail!");
        }
    }
}
