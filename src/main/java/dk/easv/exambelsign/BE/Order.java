package dk.easv.exambelsign.BE;

public class Order {

    private int ordernumber;
    private String ordername;
    private String approvedby;
    private String approvalstatus;
    private String frontphoto;
    private String leftphoto;
    private String rightphoto;
    private String topphoto;
    private String bottomphoto;
    private String backphoto;
    private String photoaddress;



    public Order(int ordernumber, String ordername, String approvedby, String approvalstatus,
                 String photoaddress, String frontphoto, String leftphoto, String rightphoto,
                 String topphoto, String bottomphoto, String backphoto) {

        this.ordernumber = ordernumber;
        this.ordername = ordername;
        this.approvedby = approvedby;
        this.approvalstatus = approvalstatus;
        this.photoaddress = photoaddress;
        this.frontphoto = frontphoto;
        this.leftphoto = leftphoto;
        this.rightphoto = rightphoto;
        this.topphoto = topphoto;
        this.bottomphoto = bottomphoto;
        this.backphoto = backphoto;
    }

    public int getOrdernumber() { return this.ordernumber; }
    public String getOrdername() { return this.ordername; }
    public String getApprovedby() { return this.approvedby; }
    public String getApprovalstatus() { return this.approvalstatus; }
    public String getPhotoaddress() { return this.photoaddress; }
    public String getFrontphoto() { return this.frontphoto; }
    public String getLeftphoto() { return this.leftphoto; }
    public String getRightphoto() { return this.rightphoto; }
    public String getTopphoto() { return this.topphoto; }
    public String getBottomphoto() { return this.bottomphoto; }
    public String getBackphoto() { return this.backphoto; }

}
