package com.systeminfos.design.pattern.delegate;

public class FreeCheckServiceImpl implements ICheckService {
    @Override
    public void doCheck(Integer type) {
        System.out.println("免检");
    }

    @Override
    public CheckTypeEnum checkType() {
        return CheckTypeEnum.FREE_CHECK;
    }

}
