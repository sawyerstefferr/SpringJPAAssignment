package edu.wctc.distjavazodiac.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.wctc.distjavazodiac.entity.Fortune;
import edu.wctc.distjavazodiac.entity.Month;
import edu.wctc.distjavazodiac.repo.MonthRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DbMonthListService implements MonthListService {
    private List<Month> monthList;
    private MonthRepository monthRepo;
    @Override
    public List<Month> getMonths() {
        return monthList;
    }

    @PostConstruct
    public void initMonths() {
        List<Month> list = new ArrayList<>();
        monthRepo.findAll().forEach(list::add);
        monthList = list;
    }
}
