package view;

import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JComponent;
 
import utilities.Scaling;
import model.Avatar;
import model.GameMap;
import model.Location;
 
public class MapView extends JComponent{
        private GameMap map;
        private Avatar avatar;
        private EntityView entityView;
        private TileView[][] tiles;
        public static final int CHARACTER_OFFSET = 3;
       
        public MapView(GameMap map, EntityView entityView, Avatar avatar) {
                this.map = map;
                this.entityView = entityView;
                this.avatar = avatar;
                this.map.updateEntityLocation(this.avatar, new Location(3,3));
                this.setTileComponents();
//              this.setLayout(new GridLayout(7,7));
//              this.setComponents();
        }
       
        void setTileComponents(){
               
                this.tiles = new TileView[map.getMapLength().getY()][map.getMapLength().getX()];
                for(int i = 0;i < this.map.getMapLength().getY();i++){
                        for(int j = 0; j < this.map.getMapLength().getX();j++){
                                this.tiles[i][j] = new TileView(map.getTile(new Location(j,i)));
                        }
                }
        }
       
        public void paintComponent(Graphics g){;
                this.setTileComponents();
                Location location= this.map.getLocation(this.avatar);
                int lowX=location.getX()-CHARACTER_OFFSET;
                int highX=location.getX()+CHARACTER_OFFSET;
                int lowY=location.getY()-CHARACTER_OFFSET;
                int highY=location.getY()+CHARACTER_OFFSET;
                for(int i=lowX;i<=highX;i++){
                        for(int j=lowY;j<=highY;j++){
                                this.tiles[j][i].paintComponent(g, lowX, lowY);
                                if (location.equals(new Location(i,j))){
                                        this.entityView.paintComponent(g);
                                }
                        }
                }
                repaint();
                g.dispose();
        }      
        public Dimension getPreferredSize(){
                return new Dimension( Scaling.GAME_VIEW_WIDTH , Scaling.GAME_VIEW_HEIGHT);
        }
}