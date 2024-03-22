package com.coderscampus.assignment6;

public enum ModelType {
    MODEL_3,
    MODEL_S,
    MODEL_X;

    @Override
    public String toString() throws IllegalArgumentException {
        switch(this) {
            case MODEL_3:
                return "Model 3";
            case MODEL_S:
                return "Model S";
            case MODEL_X:
                return "Model X";
            default:
                throw new IllegalArgumentException("ModelType is in an invalid state.");
        }
    }
}
