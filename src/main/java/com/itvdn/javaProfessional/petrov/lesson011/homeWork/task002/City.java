package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002;

public enum City {
    KYIV(Size.BIG), LVIV(Size.MEDIUM), VINNYTSIA(Size.MEDIUM);

    private Size size;

    City(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }
}
