package org.openjfx.model.preBossEntities.Enemy;
import org.openjfx.model.commonEntities.LocatableObject;
import org.openjfx.model.commonEntities.Location;
import org.openjfx.model.commonEntities.Buff.BuffTypes;
import org.openjfx.model.commonEntities.FiringBehavior.FiringBehavior;

import java.io.Serializable;


public abstract class Enemy extends LocatableObject{
    private double velocity;
    private int radarRadius;
    private Location destinationLocation;
    private EnemyDestinations destinationType;
    private BuffTypes buffType;
    private boolean isEvolved;
    private int changeDirectionPeriod = 40;
    private int changeDirectionTimer = 0;
    private FiringBehavior firingBehavior;
    private int scorePoint;

    public Enemy(Location location, double hitBoxWidth, double hitBoxHeight, int healthPoint, double velocity, int radarRadius, boolean isEvolved, int scorePoint) {
        super(location, hitBoxWidth, hitBoxHeight, isEvolved ? 2*healthPoint : healthPoint);
        this.isEvolved = isEvolved;
        this.velocity = velocity;
        this.radarRadius = isEvolved ? 3*radarRadius/2 : radarRadius;
        this.scorePoint = isEvolved ? 2*scorePoint : scorePoint;
        this.destinationType = EnemyDestinations.RandomLocation;
        this.destinationLocation = new Location(0,0 );
        double random = (Math.random()*22) -10;
        if(random < 8)
            buffType = BuffTypes.EMPTY;
        else if(random < 8.5)
            buffType = BuffTypes.HEALTH;
        else if(random < 9.5)
            buffType = BuffTypes.GUN_POWER;
        else if(random < 10)
            buffType = BuffTypes.GUN_TYPE;
        else if(random < 10.5)
            buffType = BuffTypes.FIRE_RATE;
        else if(random < 11.00)
            buffType = BuffTypes.SPEED;
        else if(random < 11.5)
            buffType = BuffTypes.HYPER_JUMP;
        else if(random < 12)
            buffType = BuffTypes.SMART_BOMB;
        else
            buffType = BuffTypes.EMPTY;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getRadarRadius() {
        return radarRadius;
    }

    public void setRadarRadius(int radarRadius) {
        this.radarRadius = radarRadius;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public EnemyDestinations getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(EnemyDestinations destinationType) {
        this.destinationType = destinationType;
    }

    public BuffTypes getBuffType() {
        return buffType;
    }

    public void setBuffType(BuffTypes buffType) {
        this.buffType = buffType;
    }

    public boolean isEvolved() {
        return isEvolved;
    }

    public void setEvolved(boolean evolved) {
        isEvolved = evolved;
    }

    public int getChangeDirectionPeriod() {
        return changeDirectionPeriod;
    }

    public void setChangeDirectionPeriod(int changeDirectionPeriod) {
        this.changeDirectionPeriod = changeDirectionPeriod;
    }

    public int getChangeDirectionTimer() {
        return changeDirectionTimer;
    }

    public void setChangeDirectionTimer(int changeDirectionTimer) {
        this.changeDirectionTimer = changeDirectionTimer;
    }

    public FiringBehavior getFiringBehavior() {
        return firingBehavior;
    }

    public void setFiringBehavior(FiringBehavior firingBehavior) {
        this.firingBehavior = firingBehavior;
    }

    public int getScorePoint() {
        return scorePoint;
    }

    public void setScorePoint(int scorePoint) {
        this.scorePoint = scorePoint;
    }
}
