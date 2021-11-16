package ucf.assignments;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

// Class for the context menu of every item
public class ItemContextMenu extends ContextMenu {
    // Make context menu, and menu items for removing items and marking items complete
    ContextMenu menu = new ContextMenu();
    MenuItem removeItem = new MenuItem("Remove Item");
    MenuItem markComplete = new MenuItem("Mark Complete");

    // Constructor that adds all our menu items to the context menu (since we always need that)
    public ItemContextMenu() {
        menu.getItems().addAll(removeItem, markComplete);
    }
}