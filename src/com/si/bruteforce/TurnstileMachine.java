package com.si.bruteforce;

public class TurnstileMachine {
    private State state;
    public TurnstileMachine() {
        this.state = State.LOCKED;
        this.lock();
    }

    /**
     * What if there is a new state?
     * OCP - for every new state, you need to come to this class and add a new switch case
     * @param event
     */
    public void handleEvent(Event event) {
        switch (state) {
            case LOCKED: {
                switch (event) {
                    case COIN:
                        this.state = State.UNLOCKED; this.unlock(); break;
                    case PASS:
                        this.state = State.LOCKED; this.siren(); break;
                }
            }
            case UNLOCKED: {
                switch (event) {
                    case COIN:
                        this.state = State.UNLOCKED; this.thanks();break;
                    case PASS:
                        this.state = State.LOCKED; this.lock(); break;
                }
            }
        }
    }

    private void lock(){
        System.out.println("Lock");
    }
    private void unlock(){
        System.out.println("unlock");
    }
    private void thanks(){
        System.out.println("thanks");
    }
    private void siren(){
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
