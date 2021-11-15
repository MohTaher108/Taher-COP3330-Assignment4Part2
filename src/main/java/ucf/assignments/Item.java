package ucf.assignments;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import java.time.LocalDate;

/*
// Class for the context menu of every item
class ItemContextMenu {
    // Make context menu, and menu items for removing items and marking items complete
    ContextMenu menu = new ContextMenu();
    MenuItem removeItem = new MenuItem("Remove Item");
    MenuItem markComplete = new MenuItem("Mark Complete");

    // Constructor that adds all our menu items to the context menu (since we always need that)
    public ItemContextMenu() {
        menu.getItems().addAll(removeItem, markComplete);
    }
}
*/

// Class for each item we will implement
public class Item {
    private String Name;
    private TextArea Description;
    private LocalDate DueDate;
    private CheckBox MarkComplete;

    public Item(String Name, LocalDate DueDate) {
        this.Name = Name;
        this.Description = new TextArea("Description");
        this.Description.setWrapText(true);
        this.DueDate = DueDate;
        this.MarkComplete = new CheckBox();
        // ItemContextMenu itemMenu = new ItemContextMenu();
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public TextArea getDescription() {
        return Description;
    }

    public void setDescription(TextArea Description) {
        this.Description = Description;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate DueDate) {
        this.DueDate = DueDate;
    }

    public CheckBox getMarkComplete() {
        return MarkComplete;
    }

    public void setMarkComplete(CheckBox markComplete) {
        this.MarkComplete = MarkComplete;
    }
}