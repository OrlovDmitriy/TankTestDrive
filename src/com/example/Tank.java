package com.example;

public class Tank {
    private int x, y;
    private int dir;
    private int fuel = 100;
    private final static String MODEL = "T34";
    private static int countTank;
    private int c;

    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        c = ++countTank;
    }

    public void move(int i) {
        if (dir == 0) x += i;
        else if (dir == 1) y += i;
        else if (dir == 2) x -= i;
        else y -= i;
        fuel = fuel - Math.abs(i);
    }
    public void goForward(int i) {
        if (i < 0 && -i > -fuel)
            i = -fuel;
        else if (i > fuel)
            i = fuel;
        move(i);

    }

    public void printPosition() {
        System.out.println("The Tank " + MODEL + "-" + c + " is at " + x +", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }
}

class TankTestDrive {
    public static void main(String[] args) {
        /*
        Make (add code to class Tank),
        with fuel and different constructors
        */

        // At (0;0) fuel=100
        Tank justTank = new Tank();
        // At (10;10) fuel=100
        Tank anywareTank = new Tank(10, 10);
        // At (20;30) fuel=200
        Tank customTank = new Tank(30, 30, 200);

        justTank.goForward(-60);
        justTank.goForward(-35);
        justTank.printPosition();
        anywareTank.goBackward(-200);
        anywareTank.printPosition();
        customTank.goForward(201);
        customTank.printPosition();

        /*
        This fragment of code has to output

        The Tank is at 100, 0 now.
        The Tank is at 110, 10 now.
        The Tank is at 220, 30 now.

        */
    }
}
