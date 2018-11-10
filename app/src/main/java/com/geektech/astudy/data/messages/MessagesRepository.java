package com.geektech.astudy.data.messages;

import com.geektech.astudy.data.messages.model.RMessage;
import com.geektech.core.realm.RealmBaseDataSource;

import io.realm.Realm;
import io.realm.RealmResults;

// Created by askar on 11/7/18.
public class MessagesRepository extends RealmBaseDataSource
        implements MessagesDataSource {

    //region Static

    private static MessagesRepository INSTANCE;

    public static MessagesDataSource getInstance(

    ){
        if (INSTANCE == null) {
            INSTANCE = new MessagesRepository();
        }
        return INSTANCE;
    }

    //endregion

    //region Private

    void saveMessage(RMessage message){
        if (message.getId() == 0) {
            message.setId(getNextId(RMessage.class));
        }

        executeTransaction(realm -> {
            //Copy or update realm record, current 'message' is not managed
            realm.copyToRealmOrUpdate(message);

            //Managed
            RMessage managed = realm.where(RMessage.class)
                    .equalTo("id", message.getId()).findFirst();
            //Record for managed models are updated, p.s. update only in transaction
            managed.setContent("New content");

            //Unmanaged
            RMessage unmanaged = realm.copyFromRealm(managed);
            //Record in db not updated
            unmanaged.setContent(".......");
        });
    }

    //endregion

    //region Contract

    @Override
    public void getMessages(MessagesCallback messagesCallback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            RealmResults<RMessage> messages = realm.where(RMessage.class)
                    .findAll();

            messagesCallback.onSuccess(realm.copyFromRealm(messages));
        } catch (Exception e) {

        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void getMessage(long id, MessageCallback messageCallback) {
        Realm realm = null;

        try {
            realm = getRealmInstance();

            RMessage message = realm.where(RMessage.class)
                    .equalTo("id", id)
                    .findFirst();

            messageCallback.onSuccess(realm.copyFromRealm(message));

        } catch (Exception e) {

        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void addMessage(RMessage message) {
        saveMessage(message);
    }

    //endregion
}
