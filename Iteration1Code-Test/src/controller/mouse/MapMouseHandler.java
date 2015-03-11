package controller.mouse;

import java.awt.event.MouseEvent;

import model.GameMap;
import model.Location;
import model.Point;
import model.Entity.Avatar;
import model.items.TakeableItem;
import utilities.Scaling;
import view.MapView;

public class MapMouseHandler {
	private GameMap map;
	private Avatar avatar;
	
	public MapMouseHandler(GameMap map, Avatar avatar){
		this.avatar = avatar;
		this.map = map;
	}
	
    // all these classes need to be defined in the MapView
    
    
    // Point of Reference needs to be added to the tileY and tileX
    // the point of reference is the point that reflects the change in the display of the map
    private Location getTileLocation(MouseEvent e){
    	Point point = map.getLocation(avatar);
        int tileY = e.getY()/Scaling.TILE_HEIGHT;
        int tileX = e.getX()/Scaling.TILE_WIDTH;
        int xOff = point.getX() + (tileX - MapView.CHARACTER_OFFSET);
        int yOff = point.getY() + (tileY - MapView.CHARACTER_OFFSET);
        return new Location(xOff,yOff);
    }
       
    public void pickupItem(MouseEvent e) {
        Location tileLocation = this.getTileLocation(e);
        //TRANSACTION   USE get ,  if room in Inventory  then drop,  else do nothing
        // TODO  This is a Type Cast type casting is bad,  it leads to broke people on the streets and
        // corrupts governments,  please dont type cast,  Hackers love type casting. 
        // Testing Purposes for Iteration 1 only,   Implementation
        TakeableItem droppedItem = (TakeableItem) map.getTile(tileLocation).getItem();
        System.out.println(droppedItem+"  "+tileLocation);
        System.out.println(map.getTile(tileLocation));
        boolean itemIsOnAvatar = (map.getTile(tileLocation).getItem() == droppedItem) 
        	&& (map.getEntityTile(avatar) == map.getTile(tileLocation));
        if( itemIsOnAvatar){
        	if (avatar.getInventory().findAndEquip(droppedItem)){
                map.getTile(tileLocation).dropItem();
        	}
        }
    }

}