package gameServer.decoders;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * 
 * @author Mikhail
 * Decoder to decode data that is being send
 *
 */

public class UpstreamDecoder implements Decoder.Text<String> {
    @Override
    public String decode(String s) throws DecodeException {
        return s;
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
