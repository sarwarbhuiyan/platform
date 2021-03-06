/**
 * 
 */
package org.mcplissken.oauth.google;

import org.mcplissken.oauth.HandshakeAdpater;
import org.mcplissken.oauth.OAuthAuthorizer;
import org.scribe.model.Token;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

/**
 * @author 	Sherief Shawky
 * @email 	sherif.shawki@mubasher.info
 * @date 	Jan 18, 2015
 */
public class GoogleOauthAuthorizer extends OAuthAuthorizer {

	/**
	 * @param service
	 * @param provider
	 */
	public GoogleOauthAuthorizer(OAuthService service, String provider) {
		super(service, provider);
	}

	/* (non-Javadoc)
	 * @see com.mubasher.market.security.oauth.OAuthAuthorizer#start(org.scribe.oauth.OAuthService)
	 */
	@Override
	public String start() {
		
		return service.getAuthorizationUrl(null);
	}

	/* (non-Javadoc)
	 * @see com.mubasher.market.security.oauth.OAuthAuthorizer#createAccessToken(com.mubasher.market.security.oauth.HandshakeAdpater, org.scribe.oauth.OAuthService)
	 */
	@Override
	protected Token createAccessToken(HandshakeAdpater handshakeAdpater,
			OAuthService service) {
		
		String code = handshakeAdpater.readParameter("code");
		
		return service.getAccessToken(null, new Verifier(code));
	}

}
