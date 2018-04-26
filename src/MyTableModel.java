import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
    public MyTableModel(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
