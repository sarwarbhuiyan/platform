/**
 * 
 */
package org.mcplissken.osgi.vertx.eventbus;


/**
 * @author 	Sherief Shawky
 * @email 	sherif.shawki@mubasher.info
 * @date 	Aug 14, 2014
 */
public interface VertxEventBusService {
	
	public void subscribe(String address, TextEventBusHandler handler);
	
	public void subscribe(String address, JsonEventbusHandler handler);
	
	public void unsubscribe(String address, JsonEventbusHandler handler);
	
	public void unsubscribe(String address, TextEventBusHandler handler);
	
	public void publish(String address, String message);
	
	public void publish(String address, Object message, String contentType);
}
