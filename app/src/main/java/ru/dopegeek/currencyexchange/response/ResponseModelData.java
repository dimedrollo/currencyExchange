package ru.dopegeek.currencyexchange.response;

public class ResponseModelData {

    public String name;
    public ResponseModelCurrency mResponseModelCurrency;


    @Override
    public String toString() {
        return "Valute{"
                + "name=" + name + ", "
                + "currency=" + mResponseModelCurrency + "}";
    }
}
