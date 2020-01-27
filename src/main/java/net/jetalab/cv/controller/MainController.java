package net.jetalab.cv.controller;

import net.jetalab.cv.dao.OverviewDAO;
import net.jetalab.cv.dao.WorkExperienceDAO;
import net.jetalab.cv.dto.OverviewDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@MapperScan(basePackages = "net.jetalab.cv.dao")
public class MainController {

    @Autowired
    private OverviewDAO overviewDAO;
    private WorkExperienceDAO workExperienceDAO;

    @GetMapping(value = "/")
    public String main(Model model) throws Exception {
        List<OverviewDTO> overviewList = overviewDAO.selectOverview();
        Map<String, String> overview = new HashMap<>();

        for (int i = 0; i < overviewList.size(); i++) {
            overview.put(overviewList.get(i).getKey(), overviewList.get(i).getValue());
        }

        model.addAttribute("page_title", overview.get("name") + " - Curriculum Vitae");
        model.addAttribute("overview", overview);

        return "main";
    }

}
