package org.openjfx.model.menuEntities;


import org.openjfx.model.bossEntities.BossMap;
import org.openjfx.model.preBossEntities.PreBossMap;

import java.io.Serializable;

public class GameSaveObj implements Serializable {

    private static GameSaveObj gameSaveObj;

    private static PreBossMap preBossMap;
    private static BossMap bossMap;

    private GameSaveObj(){

    }

    private GameSaveObj(PreBossMap pre, BossMap boss){
        preBossMap = pre;
        bossMap = boss;
    }

    public static GameSaveObj getInstance(){
        if(gameSaveObj == null){
            gameSaveObj = new GameSaveObj();
        }
        return gameSaveObj;
    }

    public static GameSaveObj getInstance(PreBossMap pre, BossMap boss){
        if(gameSaveObj == null){
            gameSaveObj = new GameSaveObj(pre,boss);
        }
        else {
            preBossMap = pre;
            bossMap = boss;
        }
        return gameSaveObj;
    }

    public static void setInstance(GameSaveObj gameSaveObj2){
        gameSaveObj = gameSaveObj2;
    }

    public BossMap getBossMap() {
        return bossMap;
    }

    public void setBossMap(BossMap bossMap) {
        GameSaveObj.bossMap = bossMap;
    }

    public PreBossMap getPreBossMap() {
        return preBossMap;
    }

    public void setPreBossMap(PreBossMap preBossMap) {
        GameSaveObj.preBossMap = preBossMap;
    }
}