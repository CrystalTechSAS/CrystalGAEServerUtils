package jcrystal.utils;

public final class SingleCallWSEntity {
	
	private static final String ENTITY_NAME = "SingleCallWSEntity";
	
	private final com.google.appengine.api.datastore.Entity rawEntity;
	
	private SingleCallWSEntity(com.google.appengine.api.datastore.Entity rawEntity){
		this.rawEntity = rawEntity;
	}
	public  SingleCallWSEntity(String path){
		rawEntity = new com.google.appengine.api.datastore.Entity(ENTITY_NAME, path);
	}
	public String path(){
		return rawEntity.getKey().getName();
	}
	public SingleCallWSEntity put(){
		com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService().put(null, rawEntity);
		return this;
	}
	private static com.google.appengine.api.datastore.Entity rawGet(String path){
		if(null == path){return null;}
		try{
			return com.google.appengine.api.datastore.DatastoreServiceFactory.getDatastoreService().get(null, com.google.appengine.api.datastore.KeyFactory.createKey(ENTITY_NAME, path));
		}
		catch(com.google.appengine.api.datastore.EntityNotFoundException | java.lang.IllegalArgumentException e){
			return null;
		}
	}
	public SingleCallWSEntity version(long version){
		rawEntity.setUnindexedProperty("version", version);
		return this;
	}
	public long version(){
		return jcrystal.db.datastore.EntityUtils.getLong(rawEntity, "version");
	}
	public static SingleCallWSEntity get(String path){
		com.google.appengine.api.datastore.Entity ent = rawGet(path);
		if(ent == null)return new SingleCallWSEntity(path).version(0);
		return new SingleCallWSEntity(ent);
	}
}
