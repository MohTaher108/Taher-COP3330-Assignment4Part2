package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Controller {
    // My main tableview that will contain everything
    @FXML private TableView<Item> tableView;
    @FXML private TableColumn<Item, String> NameColumn;
    @FXML private TableColumn<Item, TextArea> DescriptionColumn;
    @FXML private TableColumn<Item, LocalDate> DueDateColumn;
    @FXML private TableColumn<Item, CheckBox> MarkCompleteColumn;

    // Extra tableview that will show when the user needs it
    @FXML private TableView<Item> tableViewExtra;
    @FXML private TableColumn<Item, String> NameColumnExtra;
    @FXML private TableColumn<Item, TextArea> DescriptionColumnExtra;
    @FXML private TableColumn<Item, LocalDate> DueDateColumnExtra;
    @FXML private TableColumn<Item, CheckBox> MarkCompleteColumnExtra;

    // ArrayList that will hold all my items
    ObservableList<Item> ItemList = FXCollections.observableArrayList();

    // Initialize all my columns
    @FXML
    public void initialize() {
        // Set up the columns in the table
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        MarkCompleteColumn.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));

        // Set up the extra columns in the extra table
        NameColumnExtra.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumnExtra.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DueDateColumnExtra.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        MarkCompleteColumnExtra.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));

        tableView.setItems(ItemList);
    }

    // This method will add an item when the MenuItem is clicked
    @FXML
    protected void AddItem() {
        /*  ItemList.add(item)
            tableView.add(item) */

        // Add the new item to our arrayList
        ItemList.add(new Item("Item", LocalDate.now()));
        // Add the new item into the TableView
    }

    // This method will clear my TableView (Todo List)
    @FXML
    protected void ClearList() {
        tableView.getItems().clear();
    }

    @FXML
    protected void DisplayAllItemsInList() {
        tableView.setItems(ItemList);
    }

    @FXML
    protected void DisplayCompleteItemsInList() {
        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(item.getMarkComplete().isSelected())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    @FXML
    protected void DisplayIncompleteItemsInList() {
        ObservableList<Item> tempList = FXCollections.observableArrayList();
        for(Item item: ItemList) {
            if(!item.getMarkComplete().isSelected())
                tempList.add(item);
        }
        tableView.setItems(tempList);
    }

    @FXML
    protected void SaveList() {
        /*
        new File("TodoList 1")
         */
    }

    @FXML
    protected void LoadList() {
        /*
        new FileReader("TodoList 1")
        open File
         */
    }

    @FXML
    protected void SortList() {
        /*

         */
    }
}