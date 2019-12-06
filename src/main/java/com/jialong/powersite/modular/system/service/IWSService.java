package com.jialong.powersite.modular.system.service;

import java.io.IOException;

public interface IWSService {

    void pushAlarmLog() throws IOException;

    void pushOperationRecord() throws IOException;
}
