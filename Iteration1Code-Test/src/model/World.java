package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;
import model.entity.Orc;
import view.MapView;

public class World {
	private static Map<String, GameMap> maps = new HashMap<String, GameMap>();
	private Map<String, Integer> keySet = new HashMap<String, Integer>();
	private Avatar avatar;
	
	public World(Avatar avatar){//MapView mv){
		this.avatar = avatar;
		MapBuilder m = new MapBuilder();
		m.generateStructuredMapv3();
		maps.put("Main",new GameMap());
		maps.put("Cave", new GameMap(m));
		genDefaultKeys();
		this.runEntities();
	}
	
	public World(GameMap Main, Avatar avatar){//, MapView mv){
		this.avatar = avatar;
		maps.put("Main",Main);
		maps.put("Cave", new GameMap());
		genDefaultKeys();
		this.runEntities();
	}
	
	public World( Map<String, GameMap> maps, Map<String, Integer> keySet,Avatar avatar){
		this.avatar = avatar;
		this.maps = maps;
		this.keySet = keySet;
		this.runEntities();
	}
	
	public void setMapView(MapView mv) {
		maps.get("Main").setMapView(mv);
		maps.get("Cave").setMapView(mv);
	}
	
	public void setWorldAvatar(Avatar avatar){
		this.avatar = avatar;
	}
	
	public Map<String, GameMap> getMaps() {
		return maps;
	}
	
	public static GameMap getMap(String s){
		return maps.get(s);
	}
	
	public void setAvatar(Avatar avatar){
		for (Entry<String, GameMap> entry : maps.entrySet()) {
		    GameMap map = entry.getValue();
		    map.setAvatar(avatar);
		}
	}
	
	//Key Bind Functions
	/**
	 * Generates the default key set.
	 */
	public void genDefaultKeys(){
		keySet.put("SOUTHWEST",97);
		keySet.put("SOUTH",83);
		keySet.put("SOUTHEAST",99);
		keySet.put("EAST",68);
		keySet.put("NORTHEAST",105);
		keySet.put("NORTH",87);
		keySet.put("NORTHWEST",103);
		keySet.put("WEST",65);
		keySet.put("DANCE1",48);
		keySet.put("DANCE2",53);
	}
	
	public Map<String, Integer> getKeySet(){
		return keySet;
	}
	
	public void editKeySet(String s, int i){
		keySet.put(s,i);
	}
	
	public Set<Entity> getEntities(){
//		Set<Entity> mainEntities = this.maps.get("Main").getEntities();
//		Set<Entity> caveEntities = this.maps.get("Cave").getEntities();
//		mainEntities.addAll(caveEntities);
		return this.maps.get(this.avatar.getCurrMap()).getEntities();
	}
	
	// this method is called to run all Entities in idle states, whatever they may be
	public void runEntities(){
		Set<Entity> entities = this.getEntities();

		for (Entity ent : entities){
			if (isAvatar(ent)) continue;
			ent.grantSight(avatar);
			ent.idle();
		}
	}
	
	// sorry Dave
	private boolean isAvatar(Entity e) {
		String en = e.toString();
		String entityName = en.substring(0, en.indexOf(":"));
		return entityName.equals("Avatar");
	}
	
	public String toString(){
		String result = "World:" + maps.keySet().size();
		for (Entry<String, GameMap> entry : maps.entrySet()) {
		    String key = entry.getKey();
		    GameMap map = entry.getValue();
		    result = result +  "\n" + key;
		    result = result + "\n" +  map;
		}
		for (String key : this.keySet.keySet()) result += "\n" + key + ":" + this.keySet.get(key);
		return result;
	}
}
