package fr.insalyon.teamparrot.testjavafx.event;

import fr.insalyon.teamparrot.testjavafx.model.Value;

public class ValueCreatedEvent implements Event {
    private final Value value;

    public ValueCreatedEvent(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }
}
