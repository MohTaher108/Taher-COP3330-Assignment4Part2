package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    // My main tableview that will contain everything
    @FXML private TableView<Item> tableView;
    @FXML private TableColumn<Item, String> NameColumn;
    @FXML private TableColumn<Item, TextArea> DescriptionColumn;
    @FXML private TableColumn<Item, LocalDate> DueDateColumn;
    @FXML private TableColumn<Item, CheckBox> MarkCompleteColumn;
    @FXML private TableColumn<Item, CheckBox> ContextMenuColumn;

    // Extra tableview that will show when the user needs it
    @FXML private TableView<Item> tableViewExtra;
    @FXML private TableColumn<Item, String> NameColumnExtra;
    @FXML private TableColumn<Item, TextArea> DescriptionColumnExtra;
    @FXML private TableColumn<Item, LocalDate> DueDateColumnExtra;
    @FXML private TableColumn<Item, CheckBox> MarkCompleteColumnExtra;
    @FXML private TableColumn<Item, CheckBox> ContextMenuColumnExtra;

    // ArrayList that will hold all my items
    ArrayList<Item> ItemList = new ArrayList<>();

    // Initialize all my columns
    @FXML
    public void initialize() {
        // Set up the columns in the table
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        MarkCompleteColumn.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));
        ContextMenuColumn.setCellValueFactory(new PropertyValueFactory<>(""));

        // Set up the extra columns in the extra table
        NameColumnExtra.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumnExtra.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DueDateColumnExtra.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        MarkCompleteColumnExtra.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));
        ContextMenuColumnExtra.setCellValueFactory(new PropertyValueFactory<>(""));
    }

    // This method will add an item when the MenuItem is clicked
    @FXML
    protected void AddItem() {
        /*  ItemList.add(item)
            tableView.add(item) */
        // Add the new item to our arrayList
        ItemList.add(new Item("Item", LocalDate.now()));
        // Add the new item into the TableView
        tableView.getItems().add(ItemList.get(ItemList.size()-1));
    }

    // This method will clear my TableView (Todo List)
    @FXML
    protected void ClearList() {
        tableView.getItems().clear();
    }

    @FXML
    protected void DisplayAllItemsInList() {
        tableViewExtra.getItems().clear();
        for(Item item: ItemList)
            tableViewExtra.getItems().add(item);
    }

    @FXML
    protected void DisplayCompleteItemsInList() {
        tableViewExtra.getItems().clear();
        for(Item item: ItemList) {
            if(!item.getMarkComplete().isSelected())
                tableViewExtra.getItems().add(item);
        }
    }

    @FXML
    protected void DisplayIncompleteItemsInList() {
        tableViewExtra.getItems().clear();
        for(Item item: ItemList) {
            if(!item.getMarkComplete().isSelected())
                tableViewExtra.getItems().add(item);
        }
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