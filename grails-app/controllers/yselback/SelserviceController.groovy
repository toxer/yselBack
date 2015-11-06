package yselback


import grails.converters.JSON
import groovy.json.JsonBuilder

import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.web.json.JSONObject

import ysel.request.PresenzaRequest
import ysel.response.StandardErrorResponse;

class SelserviceController {
	//static allowedMethods = [getPresenza:['POST'],presenzaExample:['POST']]
	SimpleDateFormat standardFormat = new SimpleDateFormat('dd-MM-yyyy');
	def presenzeService
	def commonUtilsService


	



	def getPresenza(PresenzaRequest req){

		def codiceCamera = commonUtilsService.getCodiceCameraSipert(req);
		def nomeCamera= commonUtilsService.getNomeCamera(req);
		def dataSource= commonUtilsService.getDataSource(req);
		if (!codiceCamera){
			render text:(new StandardErrorResponse("Codice camera non trovato") as JSON),contentType:'application/json', encoding: "UTF-8"
		}
		presenzeService.getPresenze(req,dataSource)
	}

	def presenzaExample(){

		JSONObject presenza = new JSONObject();
		presenza.data=standardFormat.format(new Date())
		presenza.ente='xxxxxx'
		presenza.matricoleDipendenti =[1, 2, 3, 5, 8]
		presenza.userId='yyyyyy'

		render text:presenza as JSON,contentType:'application/json', encoding: "UTF-8"

	}






}
