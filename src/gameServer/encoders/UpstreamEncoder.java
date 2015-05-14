package gameServer.encoders;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.Base64;

/**
 * 
 * @author Mikhail
 * Encoder to encode messages that is being send
 *
 */
public class UpstreamEncoder implements Encoder.Text<String> {
    @Override
    public String encode(String s) throws EncodeException {
        return s;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
