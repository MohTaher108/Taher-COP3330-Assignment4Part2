/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Mohammad Taher
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.time.LocalDate;

public class Controller {
    // My main tableview that will contain everything
    @FXML private TableView<Item> tableView;
    @FXML private TableColumn<Item, String> NameColumn;
    @FXML private TableColumn<Item, String> DescriptionColumn;
    @FXML private TableColumn<Item, String> DueDateColumn;
    @FXML private TableColumn<Item, CheckBox> MarkCompleteColumn;
    @FXML private TableColumn<Item, CheckBox> RemoveColumn;

    // ArrayList that will hold all my items
    ObservableList<Item> ItemList = FXCollections.observableArrayList();

    // Initialize all my columns
    @FXML
    public void initialize() {
        // Set up the columns in the table
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NameColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Item, String> t) {
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setName(t.getNewValue());
                }
            }
        );
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DescriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescriptionColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Item, String> t) {
                    String temp = t.getNewValue();
                    int tempLength = temp.length();
                    if(tempLength <= 256 && tempLength > 0)
                      (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(temp);
                    else
                      (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription("Invalid Description!");
                    tableView.refresh();
                }
            }
        );
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        DueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DueDateColumn.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Item, String> t) {
                    String temp = t.getNewValue();
                    LocalDate date = LocalDate.parse(temp);
                    (t.getTableView().getItems().get(t.getTablePosition().getRow())).setDueDate(date.toString());
                }
            }
        );
        MarkCompleteColumn.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));
        RemoveColumn.setCellValueFactory(new PropertyValueFactory<>("Remove"));

        // Set the tableview to show our ItemList ObservableList
        tableView.setItems(ItemList);
        tableView.setEditable(true);
    }

    // This method will add an item when the MenuItem is clicked
    @FXML
    protected void AddItem() {
        /*  ItemList.add(item) */

        // Add the new item to our arrayList
        ItemList.add(new Item());
    }

    @FXML
    protected void removeItem() {
        for(Item item: ItemList) {
            if(item.getRemove().isSelected())
                ItemList.remove(item);
        }
    }

    // This method will clear my TableView (Todo List)
    @FXML
    protected void ClearList() {
        tableView.getItems().clear();
    }

    // Reset the TableView to our original list in case it was changed
    @FXML
    protected void DisplayAllItemsInList() {
        // Set the table's view as our original ItemList
        tableView.setItems(ItemList);
    }

    // Show only complete items
    @FXML
    protected void DisplayCompleteItemsInList() {
        /*  Make ObservableList<Item> tempList
            Add all complete items to it
            tableView.set(tempList) */

        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(item.getMarkComplete().isSelected())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    // Show only incomplete items
    @FXML
    protected void DisplayIncompleteItemsInList() {
        /*  Make ObservableList<Item> tempList
            Add all incomplete items to it
            tableView.set(tempList) */

        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(!item.getMarkComplete().isSelected())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    @FXML
    protected void SaveList() {

    }

    @FXML
    protected void LoadList() {
        /*
        new FileReader("TodoList 1")
        open File
         */
    }
}