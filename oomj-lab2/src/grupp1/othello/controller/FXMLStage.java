package grupp1.othello.controller;

/*------------------------------------------------
 * IMPORTS
 *----------------------------------------------*/

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/*------------------------------------------------
 * CLASS
 *----------------------------------------------*/

/**
 * Provides an intermediary FXML loader class that automatically loads its
 * associated view upon instantiation.
 *
 * @author Philip Arvidsson (S133686)
 */
public class FXMLStage<T> extends Stage {

/*------------------------------------------------
 * FIELDS
 *----------------------------------------------*/

/**
 * The result, if any.
 */
private T result;

/*------------------------------------------------
 * PUBLIC METHODS
 *----------------------------------------------*/

/**
 * Constructor. FXML for the view is automatically loaded in it.
 */
public FXMLStage() {
    String     className = getClass().getSimpleName();
    String     viewName  = "/grupp1/othello/view/" + className + ".fxml";
    FXMLLoader fxml      = new FXMLLoader(getClass().getResource(viewName));

    fxml.setController(this);

    try {
        setScene(fxml.load());
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}

public T showAndGetResult() {
    showAndWait();
    return (result);
}

/*------------------------------------------------
 * PROTECTED METHODS
 *----------------------------------------------*/

/**
 * Sets the result.
 *
 * @param value The result.
 */
protected void setResult(T value) {
    result = value;
}

}