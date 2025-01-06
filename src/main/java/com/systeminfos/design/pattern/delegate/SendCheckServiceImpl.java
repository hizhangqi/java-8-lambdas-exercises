package com.systeminfos.design.pattern.delegate;

public class SendCheckServiceImpl implements ICheckService {
    @Override
    public void doCheck(Integer type) {
        System.out.println("送检");
    }

    @Override
    public CheckTypeEnum checkType() {
        return CheckTypeEnum.SEND_CHECK;
    }

}
