package gameServer.models;

/**
 * 
 * @author Mikhail
 * Enum representing the type of message send to 
 * clients
 *
 */
public enum MessageType {
    GAME_START,
    GAME_STOP,
    UPDATE,
    WAITING_FOR_SECOND_USER
}
