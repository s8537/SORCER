package edu.pjatk.inn.nextgencoffeemaker;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

/**
 * Created by Mike Sobolewski on 8/26/15.
 */
public interface Payment {

    public Context payment(Context context) throws RemoteException, ContextException;

}
