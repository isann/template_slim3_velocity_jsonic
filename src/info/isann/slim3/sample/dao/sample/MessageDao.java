package info.isann.slim3.sample.dao.sample;

import info.isann.slim3.sample.model.sample.Message;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

public class MessageDao extends DaoBase<Message>{

    public Message selectById(Key key){
        return Datastore.get(Message.class, key);
    }
    
}
