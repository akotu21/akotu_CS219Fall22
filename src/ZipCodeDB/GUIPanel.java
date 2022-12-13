package ZipCodeDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//base class
public class GUIPanel extends JPanel {
    private JTextField zipcode;
    private JButton submit;
    private JTextArea output;

    private Database db; //the zipcode database

    public GUIPanel() {
        this.zipcode = new JTextField("zipcode", 7);
        this.add(this.zipcode);

        this.submit = new JButton("Submit");
        this.add(this.submit);
        this.submit.addActionListener(new SubmitButtonListener());

        this.output = new JTextArea(5,20);
        this.add(this.output);

        this.db = new Database();
    }

    class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //This action will get called when the user presses submit.

            // get the zipcode out if the text field
            String code = zipcode.getText();
            output.setText(code);

            Zipcode zc = db.search(code);
            WeatherObservation wob = zc.getWeatherData();
            output.setText(wob.toString());

        }
    }
}
