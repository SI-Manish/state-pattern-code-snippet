package com.si.statepattern;

public class LockedState implements MachineState {
    private static final LockedState state = new LockedState();
    private LockedState() {}

    @Override
    public void handle(Event event, TurnstileMachine machine) {
        switch (event) {
            case COIN -> {
                machine.setState(UnlockedState.getInstance());
                machine.unlock();
            }
            case PASS -> {
                machine.siren();
            }
        }
    }

    public static MachineState getInstance() {
        return state ;
    }
}
