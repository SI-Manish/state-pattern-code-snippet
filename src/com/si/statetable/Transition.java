package com.si.statetable;

import java.util.function.Consumer;

public class Transition {
    State currentState;
    Event event;
    State nextState;
    Consumer<TurnstileMachine> action;

    public Transition(State currentState, Event event, State nextState, Consumer<TurnstileMachine> action) {
        this.currentState = currentState;
        this.event = event;
        this.nextState = nextState;
        this.action = action;
    }
}