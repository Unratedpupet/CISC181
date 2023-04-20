/**
 * <h1>GameEventsLinkedList</h1>
 * <h2>CISC 181-052L Spring 2023</h2>
 * <h3>University of Delaware</h3>
 * The major game event class involving linked lists.
 * @author Zach Phillips
 * @version 1.0
 * @since 2023-02-14
 */
class GameEvent {

    int playerNumber;
    String eventType;
    String eventDetails;

    public GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }
}


class GameEventNode {

    GameEvent gameState;
    GameEventNode next;

    public GameEventNode(GameEvent gameState) {
        this.gameState = gameState;
        this.next = null;
    }


    public GameEvent getGameState() {
        return gameState;
    }

    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }

    public GameEventNode getNext() {
        return next;
    }

    public void setNext(GameEventNode next) {
        this.next = next;
    }
}


public class GameEventsLinkedList {

    GameEventNode head;
    // Size of the Linked List
    int size;

    public GameEventsLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() { return size == 0; }

    public void add(GameEventNode nextEvent) {

        GameEventNode current = head;

        if (head == null) {
            GameEventNode newGameEventNode = new GameEventNode(nextEvent.gameState);
        }
        else if (size == 1) {
            head.next = new GameEventNode(nextEvent.gameState);
        }
        else {
            while (current.next != null) {
                current = current.getNext();
            }
            current.setNext(nextEvent);
        }
        size++;

    }

    public GameEvent remove(GameEventNode removedEvent) {
        size -= 1;
        return null;
    }

    public GameEventsLinkedList extract(String event) {
        //if the string matches an event type, it will return the GameEventNode that matches the string
        return null;
    }

    public void display() {
        //navigates through the GameEventsLinkedList and prints out each node's Event Details.
    }
}



