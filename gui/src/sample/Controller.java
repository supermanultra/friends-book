package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {

    public TextField textGetAge;
    public TextField textGetPhone;
    public TextField textGetName;
    public TextField textGetGender;
    public ListView<Friend> friendList = new ListView<>();
    public Label lblName;
    public Label lblGender;
    public Label lblPhone;
    public Label lblAge;
    public Button btnRemove;
    public Button btnAddFriend;
    public Label lblViewName;
    public Label lblViewGender;
    public Label lblViewAge;
    public Label lblViewPhone;
    public Label lblInfo;


    //Requires: nothing
    //Modifies:this
    //Effects: Adds friend to list and clears text fields
    public void addFriend(ActionEvent actionEvent) {
        String name = textGetName.getText();
        int age = Integer.parseInt(textGetAge.getText());
        long num = Long.parseLong(textGetPhone.getText());
        String gender = textGetGender.getText();
        Friend temp = new Friend(name,gender,age,num);
        friendList.getItems().add(temp);
        textGetName.clear();
        textGetPhone.clear();
        textGetAge.clear();
        textGetGender.clear();
        btnAddFriend.setDisable(true);

    }

    //Requires: nothing
    //Modifies:this
    //Effects: Displays friends attributes
    public void displayFriend(MouseEvent mouseEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        lblAge.setText(Integer.toString(temp.getAge()));
        lblName.setText(temp.name);
        lblPhone.setText(Long.toString(temp.getPhoneNumber()));
        lblGender.setText(temp.gender);
        btnRemove.setDisable(false);
        enableAttributes(true);


    }

    //Requires: nothing
    //Modifies: this
    //Effects: Removes friend from list
    public void removeFriend(ActionEvent actionEvent) {
        Friend temp;
        temp = friendList.getSelectionModel().getSelectedItem();
        friendList.getItems().remove(temp);
        lblName.setText("");
        lblAge.setText("");
        lblPhone.setText("");
        lblGender.setText("");
        btnRemove.setDisable(true);
        enableAttributes(false);

    }

    //Requires: nothing
    //Modifies: this
    //Effects: Checks if all fields have input before allowing user to add friend
    public void keyReleased() {
        boolean isFull = (textGetAge.getText().isEmpty() || textGetGender.getText().isEmpty() || textGetPhone.getText().isEmpty() || textGetName.getText().isEmpty());
        btnAddFriend.setDisable(isFull);
    }

    //Requires: nothing
    //Modifies: this
    //Effects: Hides info categories unless a friend is selected
    private void enableAttributes(boolean status){
        btnRemove.setVisible(status);
        lblViewAge.setVisible(status);
        lblViewGender.setVisible(status);
        lblViewName.setVisible(status);
        lblViewName.setVisible(status);
        lblViewPhone.setVisible(status);
        lblInfo.setVisible(status);

    }
}
