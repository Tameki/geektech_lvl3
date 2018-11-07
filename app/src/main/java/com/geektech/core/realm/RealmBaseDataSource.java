package com.geektech.core.realm;

import io.realm.Realm;

// Created by askar on 11/7/18.
public abstract class RealmBaseDataSource {
    protected Realm getRealmInstance(){
        return Realm.getDefaultInstance();
    }

    //Autoincrement Realm object id
    protected long getNextId(Class c){
        Realm realm = null;
        try {
            realm = getRealmInstance();
            String primartKeyField = realm.getSchema().get(c.getSimpleName()).getPrimaryKey();
            if (realm.where(c).max(primartKeyField)== null)
                return 1;

            int value = realm.where(c).max(primartKeyField).intValue();

            return value + 1;
        } catch (Exception e) {
            return -1;
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    //Crashes free transactions execution
    protected void executeTransaction(Realm.Transaction transaction){
        Realm realm = null;
        try {
            realm = getRealmInstance();
            realm.executeTransaction(transaction);
        } catch (Exception e) {
            //Log exception
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
