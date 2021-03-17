package ru.dopegeek.currencyexchange.response;

public class ResponseModelCurrency {


        private String id;
        private String numCode;
        private String charCode;
        private String nominal;
        private String name;
        private String value;
        private String previous;



        @Override
        public String toString() {
            return "ru.dopegeek.currencyexchange.Currency{"
                    + "id=" + id + ", "
                    + "numCode=" + numCode + ", "
                    + "charCode=" + charCode + ", "
                    + "nominal=" + nominal + ", "
                    + "name=" + name + ", "
                    + "value=" + value + ", "
                    + "previous=" + previous + "}";
        }
    }

