package ex0004;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class VeloCityTableRenderer extends DefaultTableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cmp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int col = table.convertColumnIndexToModel(column);
        if (col == 5)
        {

            if ((Integer) value > 30)
            {
                setBackground(Color.red);
            }
            if ((Integer) value > 20 && (Integer) value <= 30)
            {
                setBackground(Color.orange);
            }
            if ((Integer) value > 10 && (Integer) value <= 20)
            {
                setBackground(Color.yellow);
            }
            if ((Integer) value <= 10)
            {
                setBackground(Color.blue);
            }

        } else
        {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        if (isSelected)
        {
            setBackground(Color.lightGray);
            setForeground(Color.black);
        }
        return cmp;
    }

}
