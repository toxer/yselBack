package yselback

import grails.util.Holders
import groovy.sql.Sql

import org.springframework.context.ApplicationContext

class PresenzeService {

	private static dataSources = [:]


	//attenzione, i datasource devono essere tutti stati definiti nel file Datasource
	
	private getCurrentDatasoruce(def dataSourceName){
		if (!dataSources."${dataSourceName}"){
			ApplicationContext ctx = Holders.grailsApplication.mainContext
			dataSources."${dataSourceName}"=ctx.getBean("dataSource_"+dataSourceName?.toString().toLowerCase());
			
		}
		return dataSources."${dataSourceName}"
	}



	def getPresenze(def req,def dataSourceName){
		def sql = Sql.newInstance(getCurrentDatasoruce(dataSourceName));
		log.info("SQL: "+sql);
	}
}
