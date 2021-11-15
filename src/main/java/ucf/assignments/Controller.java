package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Controller {
    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> NameColumn;

    @FXML
    private TableColumn<Item, TextArea> DescriptionColumn;

    @FXML
    private TableColumn<Item, LocalDate> DueDateColumn;

    @FXML
    private TableColumn<Item, CheckBox> MarkCompleteColumn;

    @FXML
    public void initialize() {
        // Set up the columns in the table
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("DueDate"));
        MarkCompleteColumn.setCellValueFactory(new PropertyValueFactory<>("MarkComplete"));
    }

    @FXML
    protected void AddItem() {
        Item item = new Item("Item", LocalDate.now());
        tableView.getItems().add(item);
        /*
        String Name = "Item 1";
        String Description = "Desc";
        LocalDate DueDate = LocalDate.now();
        tableView.getItems().add(new Person(Name, Description, DueDate));
         */
    }

    @FXML
    protected void editListTitle() {
        /*
        EditNameOfTab(string)
         */
    }

    @FXML
    protected void DisplayAllItemsInList() {
        /*
        for(all titledPanes)
            display titledPane
         */
    }

    @FXML
    protected void DisplayCompleteItemsInList() {
        /*
        for(all titledPanes)
            if(Tab.AnchorPane.Accordion.TitledPane complete?)
                display titledPane
         */
    }

    @FXML
    protected void DisplayIncompleteItemsInList() {
        /*
        for(all titledPanes)
            if(!Tab.AnchorPane.Accordion.TitledPane complete?)
                display titledPane
         */
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