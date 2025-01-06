package com.systeminfos.design.pattern.delegate;

public class CheckServiceDelegate implements ICheckService {

    private ICheckService freeCheckServiceImpl;
    private ICheckService sendCheckServiceImpl;

    public CheckServiceDelegate(ICheckService checkService) {
        this.freeCheckServiceImpl = checkService;
    }

    @Override
    public void doCheck(Integer type) {
        getCheckService(type).doCheck(type);
    }

    private ICheckService getCheckService(Integer type) {
        return CheckTypeEnum.isFreeCheck(type) ? freeCheckServiceImpl : sendCheckServiceImpl;
    }

    @Override
    public CheckTypeEnum checkType() {
        return freeCheckServiceImpl.checkType();
    }

    public void setFreeCheckServiceImpl(ICheckService freeCheckServiceImpl) {
        this.freeCheckServiceImpl = freeCheckServiceImpl;
    }

    public void setSendCheckServiceImpl(ICheckService sendCheckServiceImpl) {
        this.sendCheckServiceImpl = sendCheckServiceImpl;
    }
}
