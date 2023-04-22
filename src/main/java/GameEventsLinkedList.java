class GameEvent {
    private int playerNumber;
    private String eventType;
    private String eventDetails;

    // 3 Parameter Constructor
    GameEvent(int playerNumber, String eventType, String eventDetails) {
        this.playerNumber = playerNumber;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

    // Getters and setters
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDetails() {
        return this.eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

}

class GameEventNode {
    private GameEvent gameState;
    private GameEventNode next;

    // 1 Parameter Constructor
    GameEventNode(GameEvent gameState){
        this.gameState = gameState;
        this.next = null;
    }

    // Getters and setters
    public GameEvent getGameState() {
        return this.gameState;
    }

    public void setGameState(GameEvent gameState) {
        this.gameState = gameState;
    }

    public GameEventNode getNext() {
        return this.next;
    }

    public void setNext(GameEventNode next) {
        this.next = next;
    }
}

public class GameEventsLinkedList {
    private GameEventNode head;
    private int size;

    public GameEventsLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null && size == 0;
    }

    public void add(GameEventNode node) {
        if (isEmpty()) {
            head = node;
        }
        else {
            GameEventNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
        size++;
    }

    public GameEvent remove(GameEventNode node) {
        GameEventNode current = head;
        GameEventNode remove = head;
        if (isEmpty()) {return null;}
        else if (head.equals(node)) {
            head = head.getNext();
            size--;
            return remove.getGameState();
        }
        while(current.getNext() != null && !current.getNext().equals(node)) {
            current = current.getNext();
            remove = current;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return remove.getGameState();
    }

    public GameEventsLinkedList extract(String search) {
        GameEventNode current = head;
        GameEventsLinkedList match = new GameEventsLinkedList();

        //if (isEmpty()) {return match;}
        while (current != null) {
            if (current.getGameState().getEventType().equals(search)) {
                match.add(new GameEventNode(current.getGameState()));
            }
            current = current.getNext();
        }
        return match;
    }

    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }
}