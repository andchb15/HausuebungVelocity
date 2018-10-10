package ex0004;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class VeloCityTableModel extends AbstractTableModel
{

    private final String filename = System.getProperty("user.dir")
            + File.separator + "test"
            + File.separator + "res"
            + File.separator + "daten.res";

    private List<Measurement> liste = new LinkedList<>();
    private String[] colNames =
    {
        "Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertretung"
    };

    @Override
    public int getRowCount()
    {
        return liste.size();
    }

    public void add(Measurement m)
    {
        liste.add(m);
        Collections.sort(liste, (Measurement o1, Measurement o2) ->
        {
            if (o1.getUebertreten() > o2.getUebertreten())
            {
                return -1;
            } else
            {
                return 1;
            }
        });

    }

    public void remove(int i)
    {
        liste.remove(i);
    }

    @Override
    public int getColumnCount()
    {
        return colNames.length;
    }

    public int berechneDurchschnitt()
    {
        int helpi = 0;
        for (int i = 0; i < liste.size(); ++i)
        {
            helpi += (int) getValueAt(i, 5);
        }
        helpi /= liste.size();
        JOptionPane.showMessageDialog(null, "Der Durchschnitt beträgt :" + helpi + " km/h");
        return helpi;
    }

    public void save() throws FileNotFoundException, IOException
    {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(liste);
        oos.flush();
    }

    public void load() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        liste.clear();
        liste = (List<Measurement>) ois.readObject();

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Measurement m = liste.get(rowIndex);
        switch (columnIndex)
        {
            case 0:
                return m.getDatum();
            case 1:
                return m.getZeit();
            case 2:
                return m.getKennzeichen();
            case 3:
                return m.getGemessen();
            case 4:
                return m.getErlaubt();
            case 5:
                return m.getUebertreten();
            default:
                return "???";
        }

    }

    @Override
    public String getColumnName(int column)
    {
        return colNames[column];
    }

}
