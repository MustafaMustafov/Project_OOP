package Restaurant;

public class Table {
    private int tableId;
    private boolean isFree;

    public Table(int tableId, boolean isFree) {
        this.tableId = tableId;
        this.isFree = isFree;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public boolean getIsFree() {
        return isFree;
    }

    public void setStatus(String status) {
        this.isFree = isFree;
    }
}
