package net.jetalab.cv.dao;

import net.jetalab.cv.dto.OverviewDTO;

import java.util.List;

public interface OverviewDAO {
    List<OverviewDTO> selectOverview() throws Exception;
}
