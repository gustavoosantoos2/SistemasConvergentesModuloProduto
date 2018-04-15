package br.edu.positivo.scpe.entity;

import br.edu.positivo.scpe.prods_ws.ServiceStatus;

public class StatusMessage {
	
	public static ServiceStatus CreateMessage(String statusCode, String message) {
		ServiceStatus status = new ServiceStatus();
		
		status.setStatusCode(statusCode);
		status.setMessage(message);
		
		return status;
	}
}
