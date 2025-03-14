package com.hrithik.base;

import com.hrithik.Constants.Constant;

public abstract class BaseMasterExecutor {
    public BaseTransactionIO save(BaseTransactionIO io){
        return executeSave(io, Constant.SAVE);
    }
    public BaseTransactionIO submit(BaseTransactionIO io){
        return executeSave(io,Constant.SUBMIT);
    }
    public BaseTransactionIO submitVerification(BaseTransactionIO io){
        return executeVerify(io,Constant.SUBMIT_VERIFICATION);
    }

    private BaseTransactionIO executeVerify(BaseTransactionIO io, String mode) {
        return io;
    }

    private BaseTransactionIO executeSave(BaseTransactionIO io, String mode) {
        updateWorkFlowStatus(io,mode);
        persistMainTx(io);
        return io;
    }

    private void updateWorkFlowStatus(BaseTransactionIO io,String mode) {
        switch (mode){
            case "SAVE" :
                io.getBaseMasterDO().setWorkFlowStatusCd(Constant.PENDINDDE);
                break;
            case "SUBMIT" :
                io.getBaseMasterDO().setWorkFlowStatusCd(Constant.DECOMPLETED);
                break;
            case "SUBMIT_VERIFICATION" :
                io.getBaseMasterDO().setWorkFlowStatusCd(Constant.PUBLISH);
                break;
        }
    }

    public abstract void persistMainTx(BaseTransactionIO io);

    public abstract void coreSystemNum(BaseTransactionIO io);
    public abstract BaseTransactionIO fetchByGuid(String guid);

    private void preSave(BaseTransactionIO io,String mode) {
        initialSave(io);
        updateWorkFlowStatus(io,mode);
    }

    private void initialSave(BaseTransactionIO io) {
        coreSystemNum(io);
    }
}
