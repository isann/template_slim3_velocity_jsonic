package info.isann.slim3.sample.meta.sample;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-16 01:26:04")
/** */
public final class MessageMeta extends org.slim3.datastore.ModelMeta<info.isann.slim3.sample.model.sample.Message> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<info.isann.slim3.sample.model.sample.Message, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<info.isann.slim3.sample.model.sample.Message, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<info.isann.slim3.sample.model.sample.Message> message = new org.slim3.datastore.StringAttributeMeta<info.isann.slim3.sample.model.sample.Message>(this, "message", "message");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<info.isann.slim3.sample.model.sample.Message, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<info.isann.slim3.sample.model.sample.Message, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MessageMeta slim3_singleton = new MessageMeta();

    /**
     * @return the singleton
     */
    public static MessageMeta get() {
       return slim3_singleton;
    }

    /** */
    public MessageMeta() {
        super("Message", info.isann.slim3.sample.model.sample.Message.class);
    }

    @Override
    public info.isann.slim3.sample.model.sample.Message entityToModel(com.google.appengine.api.datastore.Entity entity) {
        info.isann.slim3.sample.model.sample.Message model = new info.isann.slim3.sample.model.sample.Message();
        model.setKey(entity.getKey());
        model.setMessage((java.lang.String) entity.getProperty("message"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("message", m.getMessage());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        info.isann.slim3.sample.model.sample.Message m = (info.isann.slim3.sample.model.sample.Message) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMessage() != null){
            writer.setNextPropertyName("message");
            encoder0.encode(writer, m.getMessage());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected info.isann.slim3.sample.model.sample.Message jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        info.isann.slim3.sample.model.sample.Message m = new info.isann.slim3.sample.model.sample.Message();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("message");
        m.setMessage(decoder0.decode(reader, m.getMessage()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}