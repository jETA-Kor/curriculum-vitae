package net.jetalab.cv.controller;

import net.jetalab.cv.dao.OverviewDAO;
import net.jetalab.cv.dto.OverviewDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
@MapperScan(basePackages = "net.jetalab.cv.dao")
public class MainController {

    @Autowired
    private OverviewDAO overview;

    @GetMapping(value = "/")
    public String main() throws Exception {
        List<OverviewDTO> list = overview.selectOverview();

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("key: " + list.get(i).getKey());
//            System.out.println("value: " + list.get(i).getValue());
//        }

        return "main";
    }

}
