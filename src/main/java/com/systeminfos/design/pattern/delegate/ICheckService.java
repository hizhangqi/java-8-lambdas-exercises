package com.systeminfos.design.pattern.delegate;

public interface ICheckService {
    void doCheck(Integer type);

    default CheckTypeEnum checkType() {
        return CheckTypeEnum.FREE_CHECK;
    }

}
