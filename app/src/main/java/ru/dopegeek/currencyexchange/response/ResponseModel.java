package ru.dopegeek.currencyexchange.response;

public class ResponseModel {

    private String date;
    private String previousDate;
    private String previousURL;
    private String timestamp;
    private ResponseModelData valute;


    @Override
    public String toString() {
        return "Response{"
                + "date=" + date + ", "
                + "previousDate=" + previousDate + ", "
                + "previousURL=" + previousURL + ", "
                + "timestamp=" + timestamp + ", "
                + "valute=" + valute + ", " + "}";
    }
}
