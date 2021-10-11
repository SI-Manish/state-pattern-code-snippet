package com.si.statepattern;

/**
 * - Intent
 * 	Allow an object to alter its behavior when its internal state changes.The object
 * will appear to change its class.
 * 	In the absence of this pattern, you would have wild conditional statements scattered in your codebase
 * 	Behavioural Object Pattern
 *
 */



public class TurnstileMachine {
    private MachineState state;
    public TurnstileMachine() {
        this.state = LockedState.getInstance();
        this.lock();
    }

    public void handleEvent(Event event) {
        state.handle(event, this);
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

    void shutdown() {
        this.state = UnlockedState.getInstance();
        this.unlock();
    }

    void setState(MachineState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TurnstileMachine{" +
                "state=" + state +
                '}';
    }
}
