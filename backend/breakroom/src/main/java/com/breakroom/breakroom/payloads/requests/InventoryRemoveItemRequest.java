package com.breakroom.breakroom.payloads.requests;

import jakarta.validation.constraints.NotBlank;

public class InventoryRemoveItemRequest {
    private Long id;
    private int serial;
    @NotBlank
    private int amount;

    public InventoryRemoveItemRequest(Long id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public InventoryRemoveItemRequest(int serial, int amount) {
        this.serial = serial;
        this.amount = amount;
    }

    public InventoryRemoveItemRequest(Long id, int serial, int amount) {
        this.id = id;
        this.serial = serial;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
