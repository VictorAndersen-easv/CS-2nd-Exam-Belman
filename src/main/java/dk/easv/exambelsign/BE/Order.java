package dk.easv.exambelsign.BE;

public class Order {

    private int ordernumber;
    private String ordername;
    private String approvedby;
    private String approvalstatus;


    public Order(int ordernumber, String ordername, String approvedby, String approvalstatus) {
        this.ordernumber = ordernumber;
        this.ordername = ordername;
        this.approvedby = approvedby;
        this.approvalstatus = approvalstatus;
    }

    public int getOrdernumber() {return this.ordernumber;}
    public String getOrdername() { return this.ordername;}
    public String getApprovedby() { return this.approvedby;}
    public String getApprovalstatus() { return this.approvalstatus;}





}
