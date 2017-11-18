package fr.insalyon.teamparrot.testjavafx.model;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;

public class Value implements Observable {

    private Integer value;

    private final ArrayList<InvalidationListener> listeners;

    public Value() {
        this.value = 0;
        listeners = new ArrayList<>();
    }

    public void addListener(InvalidationListener invalidationListener) {
        listeners.add(invalidationListener);
    }

    public void removeListener(InvalidationListener invalidationListener) {
        listeners.remove(invalidationListener);
    }

    @SuppressWarnings("unused")
    public Integer getValue() {
        return value;
    }

    @SuppressWarnings("unused")
    public void setValue(Integer value) {
        this.value = value;
        listeners.forEach(l -> l.invalidated(this));
    }

    public void add(Integer value) {
        this.value += value;
        listeners.forEach(l -> l.invalidated(this));
    }

    public void withdraw(Integer value) {
        this.value -= value;
        listeners.forEach(l -> l.invalidated(this));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
