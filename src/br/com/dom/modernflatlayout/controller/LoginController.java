package br.com.dom.modernflatlayout.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.javafx.FontIcon;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by DOM on 28/03/2017.
 * email: douglas.janerson@gmail.com
 */
public class LoginController implements Initializable {

    @FXML
    private CustomTextField ctfLogin;
    @FXML
    private CustomPasswordField ctfPass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    void init() {
        ctfLogin.setLeft(new FontIcon(FontAwesome.USER));
        ctfLogin.requestFocus();
        ctfPass.setLeft(new FontIcon(FontAwesome.LOCK));
    }
}
