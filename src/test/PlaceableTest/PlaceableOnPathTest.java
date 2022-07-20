package test.PlaceableTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.Enemies.BasicEnemy;
import unsw.loopmania.Enemies.Slug;
import unsw.loopmania.Enemies.Vampire;
import unsw.loopmania.Enemies.Zombie;

import org.javatuples.Pair;

import unsw.loopmania.Character;
import unsw.loopmania.LoopManiaWorld;
import unsw.loopmania.PathPosition;
import unsw.loopmania.Buildings.Building;
import unsw.loopmania.Buildings.TowerBuilding;
import unsw.loopmania.Buildings.VampireCastleBuilding;
import unsw.loopmania.Buildings.VillageBuilding;
import unsw.loopmania.Buildings.ZombiePitBuilding;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableBehaviour;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnNonPath;
import unsw.loopmania.Cards.PlacableBehaviour.PlacableOnPath;
import unsw.loopmania.Cards.PlacableBehaviour.PlaceableOnAdjacentPath;

public class PlaceableOnPathTest {
    @Test
    public void PlaceableOnNonPathCheckTest() {
        LoopManiaWorld world = initialise();
        PlacableBehaviour adj = new PlacableOnPath();
    
        assertEquals(adj.placable(1, 1, world.getOrderedPath()), true);
        assertEquals(adj.placable(4, 1, world.getOrderedPath()), false);     
    }

    @Test
    public void PlaceableCheckTest() {
        PlacableBehaviour adj = new PlacableOnPath();

        assertEquals(adj.itemPlacable(1, 2), false);
    }

    public LoopManiaWorld initialise() {

    List<Pair<Integer, Integer>> orderedpath = new ArrayList<>();
    orderedpath.add(new Pair<Integer, Integer>(1, 1));
    orderedpath.add(new Pair<Integer, Integer>(1, 2));
    orderedpath.add(new Pair<Integer, Integer>(2, 1));
    orderedpath.add(new Pair<Integer, Integer>(2, 2));
    LoopManiaWorld world = new LoopManiaWorld(5, 5, orderedpath);
    Character character = new Character(new PathPosition(1, orderedpath));
    world.setCharacter(character);
    return world;
    }
    
}