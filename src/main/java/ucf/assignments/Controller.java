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

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
        /*
            Set up Name Column
            .
            .
            .
            Set up RemoveColumn

            Allow editing on NameColumn
            Allow editing on DescriptionColumn
            Allow editing on DueDateColumn

            tableView.set(ItemList)
            tableView.isEditable(true) */

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
        // ItemList.add(item)

        // Add the new item to our arrayList
        ItemList.add(new Item());
    }

    @FXML
    protected void removeItem() {
        // for each item, remove it if remove.isSelected()

        for(Item item: ItemList) {
            if(item.getRemoveBoolean())
                ItemList.remove(item);
        }
    }

    // This method will clear my TableView (Todo List)
    @FXML
    protected void ClearList() {
        // tableView.clear

        tableView.getItems().clear();
    }

    // Reset the TableView to our original list in case it was changed
    @FXML
    protected void DisplayAllItemsInList() {
        // tableView.set(ItemList)

        // Set the table's view as our original ItemList
        tableView.setItems(ItemList);
    }

    // Show only complete items
    @FXML
    protected void DisplayCompleteItemsInList() {
        /*  Make ObservableList<Item> tempList
            Add all complete items to it using for each loop
            tableView.set(tempList) */

        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(item.getMarkCompleteBoolean())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    // Show only incomplete items
    @FXML
    protected void DisplayIncompleteItemsInList() {
        /*  Make ObservableList<Item> tempList
            Add all incomplete items to it using for each loop
            tableView.set(tempList) */

        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(!item.getMarkCompleteBoolean())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    // Saves the list to a txt file
    @FXML
    protected void SaveList() throws Exception {
        // Make txt file
        FileWriter output = new FileWriter(Path.of("").toAbsolutePath()+"\\output.txt");
        // Write every single item into it
        for(Item item: ItemList) {
            // Write Strings
            output.write(item.getName() + " ");
            output.write(item.getDescription() + " ");
            output.write(item.getDueDate() + " ");

            // Write boolean values as strings
            if(item.getMarkCompleteBoolean())
                output.write("1 ");
            else
                output.write("0 ");

            if(item.getRemoveBoolean())
                output.write("1 ");
            else
                output.write("0 ");

            output.write("\n");
        }
        output.close();
    }

    // Loads saved list
    @FXML
    protected void LoadList() throws Exception {
        // Make file and scanner
        ItemList.clear();
        File input = new File(Path.of("").toAbsolutePath()+"\\output.txt");
        Scanner scan = new Scanner(input);

        // Loop through entire file
        while(scan.hasNextLine()) {
            // Save an entire line into str, then tokenize it into temp (arrayList)
            ArrayList<String> temp = new ArrayList<>();
            String str = scan.nextLine();
            StringTokenizer Tokenizer = new StringTokenizer(str);
            while(Tokenizer.hasMoreTokens()) {
                temp.add(Tokenizer.nextToken());
            }

            // Add all the tokenized strings into our array lists
            ItemList.add(new Item());
            int size = ItemList.size()-1;
            ItemList.get(size).setName(temp.get(0));
            ItemList.get(size).setDescription(temp.get(1));
            ItemList.get(size).setDueDate(temp.get(2));

            // Interpret boolean values
            if(temp.get(3).equals("1"))
                ItemList.get(size).setMarkComplete(true);
            else
                ItemList.get(size).setMarkComplete(false);

            if(temp.get(4).equals("1"))
                ItemList.get(size).setRemove(true);
            else
                ItemList.get(size).setRemove(false);
        }
    }
}