package ru.dopegeek.currencyexchange.response;

public class ResponseModel {

    public ResponseModel() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public String getPreviousDate() {
        return PreviousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.PreviousDate = previousDate;
    }

    public String getPreviousURL() {
        return PreviousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.PreviousURL = previousURL;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.Timestamp = timestamp;
    }

    public void setValute(ResponseModelValute valute) {
        this.Valute = valute;
    }

    private String Date;
    private String PreviousDate;
    private String PreviousURL;
    private String Timestamp;
    private ResponseModelValute Valute;

    public ResponseModelValute getValute() {
        return Valute;
    }


    @Override
    public String toString() {
        return "Response{"
                + "Date=" + Date + ", "
                + "PreviousDate=" + PreviousDate + ", "
                + "PreviousURL=" + PreviousURL + ", "
                + "Timestamp=" + Timestamp + ", "
                + "Valute=" + Valute + ", " + "}";
    }
}
