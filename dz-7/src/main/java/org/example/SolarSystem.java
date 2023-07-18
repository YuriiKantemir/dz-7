package org.example;

public enum SolarSystem {
    MERCURY(0, 20),
    VENUS(10, 30, MERCURY),
    EARTH(10, 40, VENUS),
    MARS(10, 50, EARTH),
    JUPITER(10, 60, MARS),
    SATURN(10, 100, JUPITER),
    URANUS(10, 80, SATURN),
    NEPTUNE(10, 90, URANUS);

    final public int num;
    final public int prevDistance;
    final public int radius;
    final public int sunDistance;
    final public SolarSystem previous;

    private SolarSystem next;
    SolarSystem(int prevDistance, int radius, SolarSystem previous) {
        this.prevDistance = prevDistance;
        this.radius = radius;
        if (previous == null) {
            this.num = 1;
            this.sunDistance = 100;
            this.previous = null;
        } else {
            this.num = previous.num + 1;
            this.sunDistance = previous.sunDistance + prevDistance;
            this.previous = previous;
            this.previous.next = this;
        }
    }

    SolarSystem(int prevDistance, int radius) {
        this(prevDistance, radius, null);
    }

}
