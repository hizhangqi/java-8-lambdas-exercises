package com.systeminfos.design.pattern.delegate;


import java.util.ArrayList;
import java.util.List;

public class TestDelegateService {

    private List<ICheckService> checkServiceList = new ArrayList<>();

    public String checkForStrategy(Integer type) {
        for (ICheckService checkService : checkServiceList) {
            if (checkService.checkType().getType().equals(type)) {
                checkService.doCheck(type);
            }
        }
        return "success";
    }

    private ICheckService checkService;

    public String checkForDelegate(Integer type) {
        checkService.doCheck(type);
        return "success";
    }

    public static void main(String[] args) {
        TestDelegateService service = new TestDelegateService();
        service.checkForDelegate(1);
    }

}
