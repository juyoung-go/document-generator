package com.my.document.generator.utils.ppt;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Slide {

    private XMLSlideShow ppt;
    private XSLFSlide slide;
    public Slide(XMLSlideShow XMLSlideShow){
        this.ppt =  XMLSlideShow;
        this.slide = this.ppt.createSlide();
    }

    public Image addImage(String path, PictureData.PictureType type) throws IOException {
        return new Image(path, type, ppt, slide);
    }

}
