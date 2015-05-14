package gameServer.client;

import client.other.ControlledObject;
import client.other.Point;
import client.other.Polygon;
import client.other.SimpleSpaceObject;
import gameServer.models.MessageType;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;

import java.awt.Graphics;
import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

import client.other.SimpleGame;
/**
 * 
 * @author Mikhail
 * This is game Server Client
 * Here we define which data is flowing between clients
 * And getting a connection with the server
 *
 */

@ClientEndpoint
public class ClientAnnotated {
    private Session session;
    private String sessionId;
    client.other.Point[] flyingShape = { new client.other.Point(210, 100), new client.other.Point(190, 90),
			new client.other.Point(200, 100), new client.other.Point(190, 110) };
    private SimpleGame game = new SimpleGame("Game", 300, 900); // creating an instance of game object

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sessionId = session.getId();
        
    }

    @OnMessage
    public void onMessage(String message) throws IOException, EncodeException {
        System.out.println("messageRecieved = " + message);
        if (message.equals("Game started")) {
        	
            System.out.println("Client:Game started");
            // TODO: redo with controller and PositionHolder and other stuff
            startSendingPosition(); //functuion to define data updates
        }
        if (message.startsWith("{")){
       	 JsonReader jsonReader = Json.createReader(new StringReader(message));
          	 JsonObject object = jsonReader.readObject();
          	 jsonReader.close();
          	 String sessionId = object.getString("SessionId");
          	 int x = object.getInt("x");
          	 int y = object.getInt("y");
          	 ControlledObject opponentShip = game.getShipOpponent();
        	opponentShip = new ControlledObject(new SimpleSpaceObject(flyingShape, new client.other.Point(x,y), -90));
        	game.setShipOpponent(opponentShip);
       	}

    }

    private void startSendingPosition() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                    	
                        //session.getBasicRemote().sendText(new Point(3, 5).toString());
                        //session.getAsyncRemote().sendObject(game);    
                    	SimpleSpaceObject obj = game.getMyPShip().getMyShip();
                    	Point p = obj.shape.offset;
                    	
            	   		//System.out.println("X:"+p.getX());
            	   		//System.out.println("Y:"+p.getY());
            	   		
            	   		JsonObject value = Json.createObjectBuilder()
            	   				.add("SessionId",sessionId)
            	   				.add("x",p.getX())
            	   				.add("y",p.getY())
            	   				.build();
                        game.repaint();
                        session.getBasicRemote().sendText(value.toString());
                        Thread.sleep(10);
                       
                    }
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
