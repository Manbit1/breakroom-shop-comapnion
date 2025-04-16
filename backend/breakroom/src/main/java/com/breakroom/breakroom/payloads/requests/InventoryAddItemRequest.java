package com.breakroom.breakroom.payloads.requests;

import jakarta.validation.constraints.NotBlank;

public class InventoryAddItemRequest {
    @NotBlank
    private String name;
    @NotBlank
    private int amount;
    @NotBlank
    private int serial;

    public InventoryAddItemRequest(String name, int amount, int serial) {
        this.name = name;
        this.amount = amount;
        this.serial = serial;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
