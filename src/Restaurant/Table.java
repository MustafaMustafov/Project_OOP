package Restaurant;

import java.io.Serializable;

public class Table implements Serializable {
    private int tableId;
    private boolean isFree;

    public Table(int tableId, boolean isFree) {
        this.tableId = tableId;
        this.isFree = isFree;
    }

    public Table() {
        this.tableId = 1;
        this.isFree = true;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", isFree=" + isFree +
                '}';
    }
}
