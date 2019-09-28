package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;



public class Controller {

    @FXML
    private TextField weightInput;

    @FXML
    private ImageView imageView;

    public void initialize()
    {
        imageView.setImage(new Image("https://cdnassets.hw.net/4d/22/86d3132a467b99e1e0091913a144/bmi-tools-logo.png"));
    }

    @FXML
    private TextField heightInput;

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField bmiOutput;

    @FXML
    private TextField statusOutput;

    @FXML
    private Text close;

    @FXML
    void Calculate(ActionEvent event){
    try {
        Double weightValue = Double.parseDouble(weightInput.getText());
        Double heightValue = Double.parseDouble(heightInput.getText());
        Double bmiValue = weightValue/(heightValue*heightValue);
        heightInput.clear();
        weightInput.clear();
        setResult(bmiValue);
    }catch (Exception e){
        //Handle exception
    }
    }
    void setResult(Double bmiValue){
        bmiOutput.setText(bmiValue.toString());
        if (bmiValue<=18.5){
            statusOutput.setText("Underweight");
        }
        else if (bmiValue>=18.6 && bmiValue<=24.9){
            statusOutput.setText("Normal Weight");
        }
        else if (bmiValue >= 25 && bmiValue<=29.9){
            statusOutput.setText("Overweight");
        }
        else {
            statusOutput.setText("Obesity");
        }
    }

    @FXML
    void  close(MouseEvent event) {
        System.exit(0);
    }

}