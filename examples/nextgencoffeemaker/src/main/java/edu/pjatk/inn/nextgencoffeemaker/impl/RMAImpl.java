package edu.pjatk.inn.nextgencoffeemaker.impl;

import edu.pjatk.inn.nextgencoffeemaker.RMA;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

/**
 * Created by Mike Sobolewski on 8/29/15.
 */
public class RMAImpl implements RMA {

    @Override
    public Context addRMA(Context context) throws RemoteException, ContextException {
        String description = "";
        Boolean saved = false;
        if(context.getValue("rma/description") != null ) {
            description = (String) context.getValue("rma/description");
        }
        context.putValue("rma/result", saved);
        //TODO: add notification
        saved = true; // if notified
        if (context.getReturnPath() != null) {
            context.setReturnValue(saved);
        }
        return context;
    }
}
