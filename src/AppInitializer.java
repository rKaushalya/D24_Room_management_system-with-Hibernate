import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /*primaryStage.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("lk/ijse/D24_Room_Management_System/view/loginForm.fxml"))));
        primaryStage.setTitle("Login Form");
        primaryStage.centerOnScreen();
        primaryStage.show();*/

//        Student student = new Student("s001","Ravindu","Galle","119","2012-07-12","Male");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        session.save(student);
        transaction.commit();
        session.close();
    }
}
