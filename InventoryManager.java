import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InventoryManager extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField idField, nameField, quantityField, priceField;

    public InventoryManager() {
        setTitle("Inventory Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Item Details"));

        idField = new JTextField(); nameField = new JTextField();
        quantityField = new JTextField(); priceField = new JTextField();

        inputPanel.add(new JLabel("ID:")); inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantity:")); inputPanel.add(quantityField);
        inputPanel.add(new JLabel("Price:")); inputPanel.add(priceField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        buttonPanel.add(addBtn); buttonPanel.add(updateBtn); buttonPanel.add(deleteBtn);
        inputPanel.add(buttonPanel);

        add(inputPanel, BorderLayout.SOUTH);

        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                quantityField.setText(model.getValueAt(row, 2).toString());
                priceField.setText(model.getValueAt(row, 3).toString());
            }
        });

        setVisible(true);
    }

    private void addItem() {
        if (validateFields()) {
            model.addRow(new Object[]{idField.getText(), nameField.getText(), quantityField.getText(), priceField.getText()});
            clearFields();
        }
    }

    private void updateItem() {
        int row = table.getSelectedRow();
        if (row >= 0 && validateFields()) {
            model.setValueAt(idField.getText(), row, 0);
            model.setValueAt(nameField.getText(), row, 1);
            model.setValueAt(quantityField.getText(), row, 2);
            model.setValueAt(priceField.getText(), row, 3);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to update.");
        }
    }

    private void deleteItem() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select a row to delete.");
        }
    }

    private boolean validateFields() {
        return !(idField.getText().isEmpty() || nameField.getText().isEmpty() || quantityField.getText().isEmpty() || priceField.getText().isEmpty());
    }

    private void clearFields() {
        idField.setText(""); nameField.setText(""); quantityField.setText(""); priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryManager());
    }
}
