package ucf.assignments;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.*;

// Class for each item we will implement
public class Item {
    // Class's attributes
    private String Name;
    private String Description;
    private String DueDate;
    private CheckBox MarkComplete;
    private CheckBox Remove;

    // Construct item's basic stuff
    public Item() {
        this.Name = "Item";
        this.Description = "Description";
        this.DueDate = "1900-01-01";
        this.MarkComplete = new CheckBox();
        this.Remove = new CheckBox();
    }

    // All my getters and setters
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    public CheckBox getMarkComplete() {
        return MarkComplete;
    }

    public void setMarkComplete(CheckBox MarkComplete) {
        this.MarkComplete = MarkComplete;
    }

    public CheckBox getRemove() {
        return Remove;
    }

    public void setRemove(CheckBox Remove) {
        this.Remove = Remove;
    }

    /*
    Remove.selectedProperty().addListener(
      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

    });
    */
}