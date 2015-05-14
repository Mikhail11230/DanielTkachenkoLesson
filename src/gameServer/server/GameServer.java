package gameServer.server;

import gameServer.decoders.UpstreamDecoder;
import gameServer.models.MessageType;
import gameServer.util.SessionHolder;

import org.glassfish.tyrus.server.Server;

import client.other.SimpleGame;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;

/**
 * 
 * @author Mikhail
 * A little bit of server logic and establishment of connection 
 * Between users making users have asynchronous messages
 * and starting game only when 2 users are connected. 
 *
 */
@ServerEndpoint(value = "/game", decoders = UpstreamDecoder.class)
public class GameServer {
	SimpleGame game = new SimpleGame("game", 300, 900);
    @OnOpen
    public void onOpen(Session session) throws IOException {
        SessionHolder sessionHolder = SessionHolder.getInstance();
        sessionHolder.addUser(session);
        HashSet<Session> connectedUsers = sessionHolder.getConnectedUsers();
        if (connectedUsers.size() == 2) {
            for (Session connectedUser : connectedUsers) {
                connectedUser.getBasicRemote().sendText("Game started");
              
                
            }
        } else {
            session.getBasicRemote().sendText("Waiting for user to connect");
        }
    }

    @OnMessage
    public String onMessage(String message, Session session) throws IOException {
         System.out.println("message = " + message);
         if (message.startsWith("{")){
        	 JsonReader jsonReader = Json.createReader(new StringReader(message));
        	 JsonObject object = jsonReader.readObject();
        	 jsonReader.close();
        	 String sessionId = object.getString("SessionId");
        	 int x = object.getInt("x");
        	 int y = object.getInt("y");
        	 
        	 for( Session s : SessionHolder.getInstance().getConnectedUsers()){
        		 if(!s.getId().equals(sessionId)){
        			 s.getBasicRemote().sendText(message);
        		 }
        	 }
         }
        return message;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {

    }

    public static void runServer() {
        Server server = new Server("localhost", 8025, "/websocket", null, GameServer.class);

        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }

    public static void main(String[] args) {
        runServer();
        
    }
}
