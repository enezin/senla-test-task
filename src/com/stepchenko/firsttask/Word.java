package com.stepchenko.firsttask;

public enum Word {

    RAINBOW("You can see it after the rain."),
    CAR("Type of transport."),
    SISTER("You have the same mother with her."),
    MARKET("Place where you can buy something."),
    SQUARE("Four-cornered figure."),
    WINDOW("Let light into the room."),
    MOUSE("She loves cheese very much."),
    BATHROOM("Place where you can take a shower."),
    WARDROBE("Furniture for your things."),
    FLOWER("You can give it to your girlfriend.");

    private final String description;

    Word(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}