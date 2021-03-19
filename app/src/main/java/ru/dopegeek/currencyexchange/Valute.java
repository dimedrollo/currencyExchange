package ru.dopegeek.currencyexchange;


public class Valute {

    private String mName;

    public Currency getCurrency() {
        return mCurrency;
    }

    public void setCurrency(Currency currency) {
        mCurrency = currency;
    }

    private Currency mCurrency;

    public Valute() {

        mCurrency = new Currency();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

}
