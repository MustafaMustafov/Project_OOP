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
        if(tableId<1 || tableId>15) {
            System.out.println("No such table");
        } else {
            this.tableId = tableId;
        }
    }

//    public boolean getIsFree() {
//        return isFree;
//    }

//    public void setStatus(String status) {
//        this.isFree = isFree;
//    }

    @Override
    public String toString() {
        return "Table{" +
                "tableId=" + tableId +
                ", isFree=" + isFree +
                '}';
    }
}
