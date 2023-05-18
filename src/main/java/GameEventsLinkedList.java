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

    // Makes getting the eventType for the second pop method shorter
    public String getEventType() {
        return gameState.getEventType();
    }
}

public class GameEventsLinkedList implements Comparable<GameEventsLinkedList>{
    private GameEventNode head;
    private int size;

    public GameEventsLinkedList() {
        head = null;
        size = 0;
    }

    public GameEventNode getHead() {
        return head;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return head == null && size == 0;
    }

    public void push(GameEventNode node) {
        if (isEmpty()) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public GameEventNode pop() {
        if (isEmpty()) { return null; }

        GameEventNode temp = head;
        head = head.getNext();
        size--;
        return temp;
    }
    
    public GameEventsLinkedList pop(String search) {
        GameEventsLinkedList gell = new GameEventsLinkedList();
        GameEventNode current;
        if (!isEmpty()) {
            current = head;
            while (current != null) {
                if (head.getEventType().equals(search)) {
                    gell.push(new GameEventNode(head.getGameState()));
                    head = head.getNext();
                } else if (current.getNext() != null) {
                    if (current.getNext().getEventType().equals(search)) {
                        gell.push(new GameEventNode(current.getNext().getGameState()));
                        current.setNext(current.getNext().getNext()); 
                    }
                }
                current = current.getNext();
            }
        }
        return gell;
    }

    public void display() {
        GameEventNode current = head;
        while (current != null) {
            System.out.println(current.getGameState().getEventDetails());
            current = current.getNext();
        }
    }

    @Override
    public int compareTo(GameEventsLinkedList ll) {
        return this.getSize() - ll.getSize();
    }
}