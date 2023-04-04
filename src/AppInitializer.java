import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.D24_Room_Management_System.entity.Student;
import lk.ijse.D24_Room_Management_System.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("lk/ijse/D24_Room_Management_System/view/loginForm.fxml"))));
        primaryStage.setTitle("Login Form");
        primaryStage.centerOnScreen();
        primaryStage.show();


//        Session session = FactoryConfiguration.getInstance().getSession();
        /*String hql = "SELECT resId FROM Reservation ORDER BY resId DESC";
        Query query = session.createQuery(hql).setMaxResults(1);
        List<String> list = query.list();
        session.close();

        for (String s : list) {
            System.out.println(s);
            break;
        }*/

    }
}
