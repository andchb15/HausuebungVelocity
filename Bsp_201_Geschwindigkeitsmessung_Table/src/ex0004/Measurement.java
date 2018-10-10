package ex0004;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Measurement implements Serializable
{

    LocalDate datum;
    LocalTime zeit;
    String kennzeichen;
    int gemessen;
    int erlaubt;
    int uebertreten = gemessen - erlaubt;

    public Measurement(LocalDate datum, LocalTime zeit, String kennzeichen, int gemessen, int erlaubt, int uebertreten)
    {
        this.datum = datum;
        this.zeit = zeit;
        this.kennzeichen = kennzeichen;
        this.gemessen = gemessen;
        this.erlaubt = erlaubt;
        this.uebertreten = uebertreten;
    }

    public LocalDate getDatum()
    {
        return datum;
    }

    public void setDatum(LocalDate datum)
    {
        this.datum = datum;
    }

    public LocalTime getZeit()
    {
        return zeit;
    }

    public void setZeit(LocalTime zeit)
    {
        this.zeit = zeit;
    }

    public String getKennzeichen()
    {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen)
    {
        this.kennzeichen = kennzeichen;
    }

    public int getGemessen()
    {
        return gemessen;
    }

    public void setGemessen(int gemessen)
    {
        this.gemessen = gemessen;
    }

    public int getErlaubt()
    {
        return erlaubt;
    }

    public void setErlaubt(int erlaubt)
    {
        this.erlaubt = erlaubt;
    }

    public int getUebertreten()
    {
        return uebertreten;
    }

    public void setUebertreten(int uebertreten)
    {
        this.uebertreten = uebertreten;
    }

}
