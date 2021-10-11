package com.si.statepattern;

public interface MachineState {
    void handle(Event event, TurnstileMachine machine);
}
