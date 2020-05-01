import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private JPanel MainPanel;
    private JTextField secondNameField;
    private JTextField fatherNameField;
    private JTextField nameField;
    private JButton callapceButton;
    private JPanel callapsePanel;
    private JPanel unionPanel;
    private JTextField FIO;
    private JButton catchButton;
    private static String fio;
    private static String name;
    private static String secondName;
    private static String fatherName;

    public MainForm() {

        unionPanel.setVisible(false);
        callapceButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) { return null; }

            @Override
            public void putValue(String key, Object value) { }

            @Override
            public void setEnabled(boolean b) { }

            @Override
            public boolean isEnabled() { return false; }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!secondNameField.getText().equals("") && !nameField.getText().equals("") && fatherNameField.getText().equals("")){
                    fio = secondNameField.getText() + " " + nameField.getText();
                    JOptionPane.showMessageDialog(
                            MainPanel,
                            fio,
                            "OK",
                            JOptionPane.PLAIN_MESSAGE);
                    callapsePanel.setVisible(false);
                    FIO.setText(fio);
                    unionPanel.setVisible(true);
                }else if(!secondNameField.getText().equals("") && !nameField.getText().equals("") && !fatherNameField.getText().equals("")) {
                    fio = secondNameField.getText() + " " + nameField.getText() + " " + fatherNameField.getText();
                    JOptionPane.showMessageDialog(
                            MainPanel,
                            fio,
                            "OK",
                            JOptionPane.PLAIN_MESSAGE);
                    callapsePanel.setVisible(false);
                    FIO.setText(fio);
                    unionPanel.setVisible(true);
                }
                else if(secondNameField.getText().equals("")){
                    JOptionPane.showMessageDialog(
                            MainPanel,
                            "Enter surname ",
                            "surname",
                            JOptionPane.PLAIN_MESSAGE);
                }else if(nameField.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            MainPanel,
                            "Enter name ",
                            "Name",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        catchButton.addActionListener(new Action() {

            @Override
            public Object getValue(String key) { return null; }

            @Override
            public void putValue(String key, Object value) { }

            @Override
            public void setEnabled(boolean b) { }

            @Override
            public boolean isEnabled() { return false; }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) { }

            @Override
            public void actionPerformed(ActionEvent e) {
                String fioField = FIO.getText();
                if(!fioField.equals("")){
                    String[] fio = fioField.split(" ");
                    if(fio.length == 3){
                        secondName = (fio[0]);
                        name = (fio[1]);
                        fatherName = (fio[2]);
                        sendMessage();
                    }else if(fio.length == 2){
                        secondName = (fio[0]);
                        name = (fio[1]);
                        fatherName = ("");
                        sendMessage();
                    }else {
                        JOptionPane.showMessageDialog(
                                MainPanel,
                                "Incorrect data",
                                "You entered:",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
    }

    public JPanel getMainPanel(){ return MainPanel; }

    private void sendMessage(){
        JOptionPane.showMessageDialog(
                MainPanel,
                secondName + " " + name+ " " + fatherName,
                "You entered: ",
                JOptionPane.PLAIN_MESSAGE);
        unionPanel.setVisible(false);
        callapsePanel.setVisible(true);
        secondNameField.setText(secondName);
        nameField.setText(name);
        fatherNameField.setText(fatherName);
    }
}