import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ByNameHandleData implements ActionListener {
    JTextField inputName;
    Query query;

    ByNameHandleData() {
        query = new Query();
    }

    public void setJTextField(JTextField... text) {
        inputName = text[0];
    }

    public void actionPerformed(ActionEvent e) {
        String na = inputName.getText();
        query.setDatabaseName("a");
        query.setSQL("SELECT * FROM Ò© where Ò©Æ·Ãû³Æ='" + na + "'");
        query.startQuery();
        String[] ziduan = query.getColumnName();
        String[][] record = query.getRecord();
        DialogOne dialog = new DialogOne();
        dialog.setZiduan(ziduan);
        dialog.setRecord(record);
        dialog.init();
        dialog.setVisible(true);
    }
}
