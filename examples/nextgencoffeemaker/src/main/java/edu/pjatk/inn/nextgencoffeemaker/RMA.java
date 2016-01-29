package edu.pjatk.inn.nextgencoffeemaker;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

/**
 * Created by Mike Sobolewski on 8/26/15.
 */
public interface RMA {

    public Context addRMA(Context context) throws RemoteException, ContextException;

}
