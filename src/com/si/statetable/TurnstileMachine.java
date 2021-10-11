package com.si.statetable;

import java.util.Arrays;

public class TurnstileMachine {
    private State state;
    public TurnstileMachine() {
        this.state = State.LOCKED;
        this.lock();
    }

    public void handleEvent(Event event) {
        Arrays.stream(TransitionFactory.getInstance().getTransitions())
                .filter(t -> t.currentState == state && t.event == event)
                .findFirst()
                .ifPresent(t -> {
                    state = t.nextState;
                    t.action.accept(this);
                });
    }

    void lock(){
        System.out.println("Lock");
    }
    void unlock(){
        System.out.println("unlock");
    }
    void thanks(){
        System.out.println("thanks");
    }
    void siren(){
        System.out.println("siren");
    }

    public void shutdown() {
        this.state = State.UNLOCKED;
        this.unlock();
    }

    @Override
    public String toString() {
        return "TurnstileMachine{" +
                "state=" + state +
                '}';
    }
}
