package restaurentmanagement.goodwill.com.restaurentmanagement.helperClasses;

/**
 * Created by lenovo on 5/15/2018.
 */

public class TableStatusGetrSetr {
    public String getTableNo() {
        return tableNo;
    }

   /* public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }*/

    public String getStatus() {
        return status;
    }

    public int setStatus(String status) {
        this.status = status;
        return Integer.parseInt(status);
    }

    String tableNo,status;
    public TableStatusGetrSetr(String tableNO, String tableStatus) {
    this.tableNo=tableNO;
    this.status=tableStatus;
    }

}
