package com.si.bruteforce;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        TurnstileMachine machine = new TurnstileMachine();
        displayMachine(machine);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter C for Coin, P for Pass and E to stop the system");
            String event = sc.next();

            switch (event) {
                case "C" -> {
                    machine.handleEvent(Event.COIN);
                    displayMachine(machine);
                }
                case "P" -> {
                    machine.handleEvent(Event.PASS);
                    displayMachine(machine);
                }
                default -> {
                    machine.shutdown();
                    displayMachine(machine);
                    System.exit(0);
                }
            }
        }

    }

    private static void displayMachine(TurnstileMachine fsm) {
        System.out.println(fsm);
    }}
