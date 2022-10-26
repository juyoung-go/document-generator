package com.my.document.generator.utils;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import javax.servlet.http.HttpServletResponse;

public class SlideUtil {

    public XMLSlideShow createSlide(){
        XMLSlideShow ppt = new XMLSlideShow();

        return ppt;
    }

    public void write(HttpServletResponse res){

    }

}
