package dk.easv.exambelsign.BE;

public class Order {

    private int ordernumber;
    private String ordername;
    private String approvedby;
    private String approvalstatus;
    private String photoaddress;


    public Order(int ordernumber, String ordername, String approvedby, String approvalstatus, String photoaddress) {
        this.ordernumber = ordernumber;
        this.ordername = ordername;
        this.approvedby = approvedby;
        this.approvalstatus = approvalstatus;
        this.photoaddress = photoaddress;
    }

    public int getOrdernumber() { return this.ordernumber; }
    public String getOrdername() { return this.ordername; }
    public String getApprovedby() { return this.approvedby; }
    public String getApprovalstatus() { return this.approvalstatus; }
    public String getPhotoaddress() { return this.photoaddress; }





}
