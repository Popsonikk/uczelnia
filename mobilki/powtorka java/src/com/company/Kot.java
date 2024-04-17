package com.company;

public class Kot {
   private String imie;
   private String kolor;
   private String rasa;
   private int  waga;
   private int wiek;
   String OdewijSie()
   {
       return "Meow Meow";
   }
   void Nakarn()
   {
       waga+=1;
   }
   void StarzejSie()
   {
       wiek+=1;
   }

    public Kot(String imie, String kolor, String rasa, int waga, int wiek) {
        this.imie = imie;
        this.kolor = kolor;
        this.rasa = rasa;
        this.waga = waga;
        this.wiek = wiek;
    }
}
