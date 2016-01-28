package edu.pjatk.inn.nextgencoffeemaker;

import sorcer.service.Context;
import sorcer.service.ContextException;

import java.rmi.RemoteException;

/**
 * Created by Mike Sobolewski on 8/26/15.
 */
public interface NextgencoffeeService {

    public Context addRecipe(Context context) throws RemoteException, ContextException;

    public Context getRecipes(Context context) throws RemoteException, ContextException;

    public Context makeCoffee(Context context) throws RemoteException, ContextException;

}
