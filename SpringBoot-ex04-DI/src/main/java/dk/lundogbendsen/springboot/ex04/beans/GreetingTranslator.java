package dk.lundogbendsen.springboot.ex04.beans;


import java.util.Locale;

public class GreetingTranslator {

    public GreetingTranslator() {
        System.out.println("GreetingTranslator()");
    }

    public String translate(String message, Locale from, Locale to) {
        return message.toUpperCase();
    }
}
