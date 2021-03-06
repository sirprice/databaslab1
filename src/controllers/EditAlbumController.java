package controllers;

import enums.AlbumGenre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Album;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by cj on 09/12/15.
 */
public class EditAlbumController implements Initializable{

    private Stage editStage;
    private Parent edit;
    private AlbumGenre genre;
    @FXML private TextField editTitle, editArtist;
    @FXML private ChoiceBox editGenre, editRating;

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<AlbumGenre> editGenreList = FXCollections.observableArrayList();
        ObservableList<Integer> editRaitingList = FXCollections.observableArrayList(1,2,3,4,5);
        for (AlbumGenre ag: AlbumGenre.values()){
            editGenreList.add(ag);
        }


        editRating.setItems(editRaitingList);
        editGenre.setItems(editGenreList);

    }
    public void setParent(Parent parent){
        this.edit = parent;
    }

    public void editAlbum(Album album, Event e){

        System.out.println(album.getArtist());
        System.out.println(album.getTitle());

        editTitle.setText(album.getTitle());
        editArtist.setText(album.getArtist());
        editGenre.setValue(album.getGenre());
        editRating.setValue(album.getRating());

        editStage = new Stage();
        editStage.setScene(new Scene(edit, 600, 500));
        editStage.initModality(Modality.WINDOW_MODAL);
        editStage.initOwner(((Node) e.getSource()).getScene().getWindow());
        editStage.show();

    }
}
