import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ByBirthHandleData implements ActionListener {
    JTextField inputYear;
    Query query;

    ByBirthHandleData() {
        query = new Query();
    }

    public void setJTextField(JTextField... text) {
        inputYear = text[0];
    }

    public void actionPerformed(ActionEvent e) {
        String yy = inputYear.getText();
        query.setDatabaseName("a");
        String SQL =
                "SELECT * FROM “© where   ”¶÷¢ LIKE '%" + yy + "%'";
        query.setSQL(SQL);
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
