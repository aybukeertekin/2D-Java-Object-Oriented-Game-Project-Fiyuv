package org.openjfx.utilization;

import org.openjfx.model.commonEntities.LocatableObject;
import org.openjfx.model.commonEntities.Location;
import org.openjfx.model.preBossEntities.PreBossMap;

public class PositionHelper {
    private double left;
    private double right;
    private double top;
    private double bottom;
    private double middlePointX;
    private double middlePointY;

    public PositionHelper(LocatableObject locatableObject){
        left = locatableObject.getLocation().getPositionX();
        right = locatableObject.getLocation().getPositionX() + locatableObject.getHitBoxWidth();
        top = locatableObject.getLocation().getPositionY();
        bottom = locatableObject.getLocation().getPositionY() + locatableObject.getHitBoxHeight();
        middlePointX = (left + right) / 2;
        middlePointY = (top + bottom) / 2;
    }

    public static boolean isThereACollision(PositionHelper obj1, PositionHelper obj2){
        return (
                !((obj1.top > obj2.bottom) || (obj2.top > obj1.bottom) || (obj1.right < obj2.left) || (obj2.right < obj1.left))
                );
    }

    public static boolean isInRadar(PositionHelper enemy, PositionHelper spacecraft, double radarRadius){
        return (
                    Math.sqrt(Math.pow(spacecraft.getMiddlePointY() - enemy.getMiddlePointY(), 2)
                    + Math.pow(spacecraft.getMiddlePointX() - enemy.getMiddlePointX(), 2)) <= radarRadius
                );
    }


    public double findRadius(){
        return Math.sqrt(Math.pow((middlePointX-left),2) + Math.pow((middlePointY-top),2)) + 3;
    }

    public boolean isInside(double maxWidth, double maxHeight){
        if (top < 0 | bottom > maxHeight | right > maxWidth | left < 0){
            return false;
        }
        else
            return true;
    }

    public boolean isInsideTurnableObj(LocatableObject locatableObject, double maxWidth, double maxHeight){
        double amount = locatableObject.getHitBoxWidth()/4;
        if (top < amount | bottom+amount > maxHeight | right+amount > maxWidth | left < amount){
            return false;
        }
        else
            return true;
    }

    public static Location createLocationInsideMap(){ //it assigns location for locatableObjects far away from spacecrafts initial position
        double x = Math.random()*PreBossMap.MAP_WIDTH;
        double y = Math.random()*PreBossMap.MAP_HEIGHT;
        while (x < 5760 && x > 4160){
            x = Math.random()*PreBossMap.MAP_WIDTH;
        }
        return new Location(x,y);
    }

    public static Location fixLocationBoundry(PositionHelper helper){ //it fixes location if initial location of object is on the boundries of map.
        double x = helper.getLeft();
        double y = helper.getTop();
        if(helper.getRight() >= PreBossMap.MAP_WIDTH){
            x -= 100;
        }
        if(helper.getLeft() <= 0){
            x += 100;
        }
        if(helper.getTop() <= 0){
            y += 100;
        }
        if(helper.getBottom() >= PreBossMap.MAP_HEIGHT){
            y -= 100;
        }
        return new Location(x,y);
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public double getMiddlePointX() {
        return middlePointX;
    }

    public void setMiddlePointX(double middlePointX) {
        this.middlePointX = middlePointX;
    }

    public double getMiddlePointY() {
        return middlePointY;
    }

    public void setMiddlePointY(double middlePointY) {
        this.middlePointY = middlePointY;
    }
}
