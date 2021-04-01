package exam.questions.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ClientCache {
	
	private Map<String,Questions> clientMap	=new HashMap<String, Questions>();

	public Map<String, Questions> getClientMap() {
		return clientMap;
	}

	public void setClientMap(Map<String, Questions> clientMap) {
		this.clientMap = clientMap;
	}
	
	

}
