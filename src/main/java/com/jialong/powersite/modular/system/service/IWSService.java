package com.jialong.powersite.modular.system.service;

import java.io.IOException;

public interface IWSService {

    public void pushAlarmLog() throws IOException;

    public void pushOperationRecord() throws IOException;
}
