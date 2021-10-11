package com.si.statepattern;

public class UnlockedState implements MachineState {
    private static final UnlockedState state = new UnlockedState();

    private UnlockedState() {}

    @Override
    public void handle(Event event, TurnstileMachine machine) {
        switch (event) {
            case COIN -> machine.thanks();
            case PASS -> {
                machine.setState(LockedState.getInstance());
                machine.lock();
            }
        }
    }

    public static MachineState getInstance() {
        return state;
    }
}
