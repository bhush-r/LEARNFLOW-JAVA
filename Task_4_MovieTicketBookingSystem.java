import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Task_4_MovieTicketBookingSystem extends Application {

    private ObservableList<String> movies = FXCollections.observableArrayList("Dunki", "Iron Man", "Spiderman");
    private ObservableList<String> showtimes = FXCollections.observableArrayList("10:00 AM", "02:00 PM", "07:00 PM");
    private ObservableList<String> seats = FXCollections.observableArrayList("A1", "A2", "A3", "B1", "B2", "B3");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Movie Ticket Booking System");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        // Movie selection
        Label movieLabel = new Label("Select Movie:");
        ComboBox<String> movieComboBox = new ComboBox<>(movies);
        grid.add(movieLabel, 0, 0);
        grid.add(movieComboBox, 1, 0);

        // Showtime selection
        Label showtimeLabel = new Label("Select Showtime:");
        ComboBox<String> showtimeComboBox = new ComboBox<>(showtimes);
        grid.add(showtimeLabel, 0, 1);
        grid.add(showtimeComboBox, 1, 1);

        // Seat selection
        Label seatLabel = new Label("Select Seat:");
        ListView<String> seatListView = new ListView<>(seats);
        seatListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        grid.add(seatLabel, 0, 2);
        grid.add(seatListView, 1, 2);

        // Book button
        Button bookButton = new Button("Book Tickets");
        bookButton.setOnAction(e -> bookTickets(movieComboBox.getValue(), showtimeComboBox.getValue(),
                seatListView.getSelectionModel().getSelectedItems()));
        grid.add(bookButton, 1, 3);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void bookTickets(String movie, String showtime, ObservableList<String> selectedSeats) {
        // Add your logic here to handle the booking process
        System.out.println("Movie: " + movie);
        System.out.println("Showtime: " + showtime);
        System.out.println("Selected Seats: " + selectedSeats);
        // Add more processing, e.g., update database, generate ticket, etc.
    }
}
