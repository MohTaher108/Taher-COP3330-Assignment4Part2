package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void addItem() {
        Controller test = new Controller();
        ObservableList<Item> ItemList = FXCollections.observableArrayList();
        test.initialize();
        test.AddItem();
        assertEquals(ItemList.size(), 1);
    }

    @Test
    void clearList() {
    }

    @Test
    void displayAllItemsInList() {
    }

    @Test
    void displayCompleteItemsInList() {
    }

    @Test
    void displayIncompleteItemsInList() {
    }

    @Test
    void saveList() {
    }

    @Test
    void loadList() {
    }
}