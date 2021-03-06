package org.openjfx.model.commonEntities.Spacecraft;

import org.openjfx.model.commonEntities.LocatableObject;
import org.openjfx.model.commonEntities.Location;
import org.openjfx.model.commonEntities.FiringBehavior.FiringBehavior;
import org.openjfx.model.commonEntities.FiringBehavior.SpacecraftGun;

public class Spacecraft extends LocatableObject {
    public static final int MAX_HEALTH = 100;
    public static final int HEALTH_INCREASE = 20;
    public static final double WIDTH = 100;
    public static final double HEIGHT = 75;
    public static final int MAX_SMARTBOMB = 3;
    public static final int SMARTBOMB_DAMAGE = 100;
    public static final int SMARTBOMB_RADIUS = 500;
    public static final double MAX_VELOCITY = 15;
    public static final double BULLET_VELOCITY = 30;
    public static final double MAX_BULLET_DAMAGE = 30;
    public static final int MIN_GUNPERIOD = 9;
    public static final int GUNPERIOD_BUFF = 3;
    public static final int INIT_GUNPERIOD = 15;
    public static final double INIT_VELOCITY = 10;
    public static final int INIT_BULLET_DAMAGE = 10;
    public static final int MAX_HYPERJUMP_ENERGY = 100;
    public static final int HYPERJUMP_ENERGY_BUFF = 50;
    public static final int HYPERJUMP_PERIOD = 50;

    private double velocity;
    private int smartBombStock;
    private boolean isDirectionLeft;
    private int hyperJumpBattery;
    private int batteryTimer;
    private boolean isMoving;
    private FiringBehavior spacecraftGun;
    private GunTypes gunTypes;
    private int choosenPicNo;

    public Spacecraft(Location location) {
        super(location, WIDTH, HEIGHT, MAX_HEALTH);
        gunTypes = GunTypes.SINGLE;
        velocity = INIT_VELOCITY;
        smartBombStock = MAX_SMARTBOMB;
        isDirectionLeft = false;
        hyperJumpBattery = MAX_HYPERJUMP_ENERGY;
        batteryTimer = 0;
        isMoving = false;
        spacecraftGun = new SpacecraftGun(INIT_GUNPERIOD, INIT_BULLET_DAMAGE, 0, BULLET_VELOCITY, this);
    }



    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity < MAX_VELOCITY ?  velocity : MAX_VELOCITY;
    }


    public int getSmartBombStock() {
        return smartBombStock;
    }

    public void setSmartBombStock(int smartBombStock) {
        this.smartBombStock = smartBombStock < MAX_SMARTBOMB ? smartBombStock : MAX_SMARTBOMB;
    }

    public boolean isDirectionLeft() {
        return isDirectionLeft;
    }

    public void setDirectionLeft(boolean directionLeft) {
        isDirectionLeft = directionLeft;
    }

    public int getHyperJumpBattery() {
        return hyperJumpBattery;
    }

    public void setHyperJumpBattery(int hyperJumpBattery) {
        this.hyperJumpBattery = hyperJumpBattery < MAX_HYPERJUMP_ENERGY ? hyperJumpBattery : MAX_HYPERJUMP_ENERGY;
    }

    public int getBatteryTimer() {
        return batteryTimer;
    }

    public void setBatteryTimer(int batteryTimer) {
        this.batteryTimer = batteryTimer;
    }

    public FiringBehavior getSpacecraftGun() {
        return spacecraftGun;
    }

    public void setSpacecraftGun(FiringBehavior spacecraftGun) {
        this.spacecraftGun = spacecraftGun;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getChoosenPicNo() {
        return choosenPicNo;
    }

    public void setChoosenPicNo(int choosenPicNo) {
        this.choosenPicNo = choosenPicNo;
    }

    public GunTypes getGunTypes() {
        return gunTypes;
    }

    public void developGun() {
        if (gunTypes.equals(GunTypes.SINGLE))
            gunTypes = GunTypes.DOUBLE;
        else if (gunTypes.equals(GunTypes.DOUBLE))
            gunTypes = GunTypes.TRIPLE;
    }

    @Override
    public void setHealthPoint(int healthPoint) {
        if(healthPoint < MAX_HEALTH )
            super.setHealthPoint(healthPoint);
        else
            super.setHealthPoint(MAX_HEALTH);
    }
}
