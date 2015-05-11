package server;
import client.ServerMessage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.server.ServerEndpoint;

/**
 * This class is a websockets ServerEndpoint (roughly similar to a servlet
 * class, though it behaves quite differently). The guts of the class are in the
 * methods annotated by @OnOpen, @OnMessage, and @OnClose.
 * 
 * @author sdexter72
 *
 */

@ServerEndpoint(value = "/game")
public class GameServerEndPoint {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
	}


	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s closed because of %s",
				session.getId(), closeReason));
	}


	
}