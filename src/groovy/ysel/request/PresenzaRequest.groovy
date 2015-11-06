package ysel.request

import groovy.transform.ToString

/**
 * Usata per richiedere la presenza  
 * @author marco
 *
 */

@ToString
class PresenzaRequest {
	String userId
	String ente
	Date requestTimestamp;
	String data
	String oreMinuti; //formato HH:mm ora in cui controllare la presenza
	//array dei numeri di matricola dei dipendenti per cui si richiede la presenza
	def matricoleDipendenti =[]
	
	
	
	 

}
