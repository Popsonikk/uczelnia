package org.example;

public class Task {
    private String tytuł;
    private String opis;
    private int prio;
    private String termin;


    public Task(String tytuł, String opis, int prio,String termin) {
        this.tytuł = tytuł;
        this.opis = opis;
        this.prio = prio;
        this.termin=termin;

    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }
}
