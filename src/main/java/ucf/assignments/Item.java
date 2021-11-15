package ucf.assignments;

import javafx.scene.control.*;

import java.time.LocalDate;

// Class for each item we will implement
public class Item {
    // Class's attributes and contextMenu
    private String Name;
    private TextArea Description;
    private LocalDate DueDate;
    private CheckBox MarkComplete;
    ItemContextMenu itemMenu;

    // Construct item's stuff
    public Item(String Name, LocalDate DueDate) {
        this.Name = Name;
        this.Description = new TextArea("Description");
        this.Description.setWrapText(true);
        this.DueDate = DueDate;
        this.MarkComplete = new CheckBox();
        this.itemMenu = new ItemContextMenu();
    }

    // All my getters and setters
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public TextArea getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description.setText(Description);
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

    public void setMarkComplete(CheckBox MarkComplete) {
        this.MarkComplete = MarkComplete;
    }
}

// Class for the context menu of every item
class ItemContextMenu extends ContextMenu {
    // Make context menu, and menu items for removing items and marking items complete
    ContextMenu menu = new ContextMenu();
    MenuItem removeItem = new MenuItem("Remove Item");
    MenuItem markComplete = new MenuItem("Mark Complete");

    // Constructor that adds all our menu items to the context menu (since we always need that)
    public ItemContextMenu() {
        menu.getItems().addAll(removeItem, markComplete);
    }
}