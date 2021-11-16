/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Mohammad Taher
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Item item = new Item("Item", "Description", "1900-01-01");

    @Test
    void AddItem() {
        /*
        assertEquals(0, itemListsize)
        itemList.add()
        assertEquals(1, itemListsize)
         */

        ObservableList<Item> ItemList = FXCollections.observableArrayList();
        assertEquals(0, ItemList.size());
        ItemList.add(item);
        assertEquals(1, ItemList.size());
    }

    @Test
    void removeItem() {
        /*
        assertEquals(0, itemListsize)
        itemList.add()
        assertEquals(1, itemListsize)
         */
        ObservableList<Item> ItemList = FXCollections.observableArrayList();
        ItemList.add(item);
        ItemList.add(item);
        ItemList.remove(0);
        assertEquals(ItemList.size(), 1);
    }

    @Test
    void clearList() {
        ObservableList<Item> ItemList = FXCollections.observableArrayList();
        ItemList.add(item);
        ItemList.add(item);
        assertEquals(ItemList.size(), 2);
        ItemList.clear();
        assertEquals(ItemList.size(), 0);
    }

    @Test
    void displayAllItemsInList() {
        ObservableList<Item> itemList = FXCollections.observableArrayList();
        itemList.add(item);
        assertEquals(itemList.size(), 1);
    }

    /*
    @Test
    void displayCompleteItemsInList() {

    }

    @Test
    void displayIncompleteItemsInList() {
    }

    @Test
    void saveList() {
        // check that path exists
    }

    @Test
    void loadList() {
        // check that everything is read properly
    }
    */
}
