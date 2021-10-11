package com.si.statetable;

public class TransitionFactory {
    private static TransitionFactory factory = new TransitionFactory();
    Transition[] transitions = new Transition[] {
            new Transition(State.LOCKED, Event.COIN, State.UNLOCKED, TurnstileMachine::unlock),
            new Transition(State.LOCKED, Event.PASS, State.LOCKED, TurnstileMachine::siren),
            new Transition(State.UNLOCKED, Event.COIN, State.UNLOCKED, TurnstileMachine::thanks),
            new Transition(State.UNLOCKED, Event.PASS, State.LOCKED, TurnstileMachine::lock),
    };

    public Transition[] getTransitions() {
        return transitions;
    }

    public static TransitionFactory getInstance() {
        return factory;
    }
}
