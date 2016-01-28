package edu.pjatk.inn.nextgencoffeemaker.impl;

/**
 * Created by Michal Kulesza on 28/01/16.
 */

import edu.pjatk.inn.nextgencoffeemaker.Payment;

import java.rmi.RemoteException;
import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

/**
 * Created by Mike Sobolewski on 8/29/15.
 */
public class PaymentImpl implements Payment {

    @Override
    public Context payment(Context context) throws RemoteException, ContextException {
        Integer flatRate = 60;
        context.putValue("delivery/cost", flatRate);
        if (context.getValue("delivery/paid") != null) {
            context.putValue("deliver/change", ((Integer) context.getValue("delivery/paid")) - flatRate);
        }

        if (context.getReturnPath() != null) {
            context.setReturnValue(flatRate);
        }
        return context;

        return context;
    }
}
