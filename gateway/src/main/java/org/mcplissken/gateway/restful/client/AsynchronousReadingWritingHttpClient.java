/**
 * 
 */
package org.mcplissken.gateway.restful.client;

import java.util.Map;

/**
 * @author 	Sherief Shawky
 * @email 	sherif.shawki@mubasher.info
 * @date 	Aug 27, 2014
 */
public interface AsynchronousReadingWritingHttpClient extends AsynchronousReadingHttpClient{
	
	public void create(
			String uri, 
			Map<String, String> headers,
			String documentType,
			Object input,
			HttpDocumentResponseCallback callback
			);
}
