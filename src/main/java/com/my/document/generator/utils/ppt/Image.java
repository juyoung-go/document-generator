package com.my.document.generator.utils.ppt;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Image {

    private void log(String s){
        System.out.println("[Image] "+s);
    }

    private XMLSlideShow ppt;
    private XSLFSlide slide;
    private XSLFPictureShape image;

    public Image(String path, PictureData.PictureType type, XMLSlideShow ppt, XSLFSlide slide) throws IOException {
        this.ppt = ppt;
        this.slide = slide;

        byte[] pictureData = IOUtils.toByteArray(new FileInputStream(path));
        XSLFPictureData pd = ppt.addPicture(pictureData, type);
        this.image = slide.createPicture(pd);
    }

    public Image setScale(float scale)
    {
        Rectangle2D anchor = image.getAnchor();
        double w = anchor.getWidth() * scale;
        double h = anchor.getHeight() * scale;
        image.setAnchor(new Rectangle2D.Double(anchor.getX(), anchor.getY(), w, h));
        return this;
    }

    public Image setCenter(){

        Rectangle2D anchor = image.getAnchor();

        int pageWidth = ppt.getPageSize().width;
        int pageHeight = ppt.getPageSize().height;
        double calcX = (pageWidth / 2) - (anchor.getWidth() / 2);
        double calcY = (pageHeight / 2) - (anchor.getHeight() / 2);
        image.setAnchor(new Rectangle2D.Double(calcX, calcY, anchor.getWidth(), anchor.getHeight()));

        return this;
    }

}
