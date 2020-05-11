package com.tao.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {

    @RequestMapping("/map")
    public String toMap(){
        return "map";
    }

        @RequestMapping("/toMusicPage")
    public String toMusicPage(){
        return "newFile";
    }

}
