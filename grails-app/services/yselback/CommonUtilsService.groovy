package yselback

import grails.converters.JSON

class CommonUtilsService {

	
	
	def getCodiceCameraSipert(def req){

		//identifico il codice sipert dal file di properties
		def codiciCamera =JSON.parse( grails.util.Holders.grailsApplication.config.codici_camera)
		def oggettoEnte =codiciCamera.find({it.codiceEaco == req.getEnte()})
		return oggettoEnte?oggettoEnte.codiceSipert:null
	}

	def getNomeCamera(def req){

		//identifico il codice sipert dal file di properties
		def codiciCamera =JSON.parse( grails.util.Holders.grailsApplication.config.codici_camera)
		def oggettoEnte =codiciCamera.find({it.codiceEaco == req.getEnte()})
		log.info(oggettoEnte?.nome)
		return oggettoEnte?oggettoEnte.nome:null
	}
	def getDataSource(def req){

		//identifico il codice sipert dal file di properties
		def codiciCamera =JSON.parse( grails.util.Holders.grailsApplication.config.codici_camera)
		def oggettoEnte =codiciCamera.find({it.codiceEaco == req.getEnte()})
		return oggettoEnte?oggettoEnte.datasource:null
	}
	
	
	def getQuery(def codiceCamera,def queryName){
		
	}
	
	
}
