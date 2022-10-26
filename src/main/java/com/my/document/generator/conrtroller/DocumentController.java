package com.my.document.generator.conrtroller;

import com.my.document.generator.utils.ppt.Ppt;
import com.my.document.generator.utils.ppt.Slide;
import org.apache.poi.sl.usermodel.PictureData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/docs")
public class DocumentController {

    private void log(String s){
        System.out.println("[DocumentController] "+s);
    }

    @GetMapping
    public String getDocument(HttpServletResponse res) throws IOException {

        String a = "get getDocument !!!!";

//        XMLSlideShow ppt = new XMLSlideShow();
//        XSLFSlide slide = ppt.createSlide();
//
//        byte[] pictureData = IOUtils.toByteArray(new FileInputStream("C:\\Users\\goju\\Downloads\\1664956240743.png"));
//        XSLFPictureData pd = ppt.addPicture(pictureData, PictureData.PictureType.PNG);
//        XSLFPictureShape pic = slide.createPicture(pd);
//
//        Dimension dim = ppt.getPageSize();
//        log("width:"+dim.width);
//        log("height:"+dim.height);

        Ppt pptFile = new Ppt();
        Slide slide = pptFile.createSlide();
        slide.addImage("C:\\Users\\goju\\Downloads\\1664956240743.png", PictureData.PictureType.PNG)
                .setScale(0.5f)
                .setCenter()
        ;

        pptFile.write(res, "myppt");

        return a;
    }

}
