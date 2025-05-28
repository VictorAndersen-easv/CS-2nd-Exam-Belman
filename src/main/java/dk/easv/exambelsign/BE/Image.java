package dk.easv.exambelsign.BE;

import java.io.File;

public class Image {

    private int id = 0;
    private String path = "";
    private int orderID = 0;


    public Image(int id,String path,int orderID) {

        this.id = id;
        this.path = path;
        this.orderID = orderID;

    }

}
