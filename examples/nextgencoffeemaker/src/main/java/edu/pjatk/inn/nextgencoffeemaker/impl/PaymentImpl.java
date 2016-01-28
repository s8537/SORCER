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
        Integer amount = 0;

        if (context.getValue("payment/amount") != null) {
            amount = (Integer) context.getValue("payment/amount");
            context.putValue("payment/paid", true);
            context.putValue("payment/method", "mobile");
        }

        if (context.getReturnPath() != null) {
            context.setReturnValue(amount);
        }

        return context;
    }
}
