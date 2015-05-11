package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 

import org.glassfish.tyrus.server.*;

import client.SimpleGame;
import client.ServerMessage;
 


/**
 * This class is essentially a driver: it creates a websockets Server (what package is the Server from?) and configures it.
 * 
 * @author sdexter72
 *
 */
public class WebSocketServer {
 
    public static void main(String[] args) {
        runServer();
    }
 
    public static void runServer() {
        
        		
       Server server = new Server("localhost", 8025, "/websockets", null, GameServerEndPoint.class);
 
        try {
            server.start();
            System.out.print("Server has started");
        	ServerMessage game = new ServerMessage("New",300,900);
            game.requestFocus();
            game.startGame();
       
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            server.stop();
        }
    }
}