package br.com.dom.modernflatlayout;

import br.com.dom.modernflatlayout.util.FXMLUtil;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by DOM on 26/03/2017.
 * email: douglas.janerson@gmail.com
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLUtil.getFxml("app_root");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
