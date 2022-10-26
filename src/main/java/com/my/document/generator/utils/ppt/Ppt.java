package com.my.document.generator.utils.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Ppt {

    private XMLSlideShow slideShow;

    public Ppt(){
        this.slideShow = this.createPPT(SlideSize.MEDIUM.width, SlideSize.MEDIUM.height);
    }

    public Ppt(SlideSize size){
        this.slideShow = this.createPPT(size.width, size.height);
        this.slideShow.setPageSize(new Dimension(size.width, size.height));
    }

    private XMLSlideShow createPPT(int width, int height){
        XMLSlideShow xmlSlideShow = new XMLSlideShow();
        xmlSlideShow.setPageSize(new Dimension(width, height));
        return xmlSlideShow;
    }

    public XMLSlideShow getXMLSlideShow() {
        return this.slideShow;
    }

    public Slide createSlide(){
        return new Slide(this.slideShow);
    }

    public void write(HttpServletResponse res, String fileName) throws IOException {
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName, StandardCharsets.UTF_8)+".pptx");
        this.slideShow.write(res.getOutputStream());
        this.slideShow.close();
    }

    enum SlideSize{

        LARGE(1920, 1280),
        MEDIUM(1280, 960),
        SMALL(1024, 768);

        public final int width, height;

        SlideSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

    }

}
