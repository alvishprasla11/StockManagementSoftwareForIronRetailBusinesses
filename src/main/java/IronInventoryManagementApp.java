
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class IronInventoryManagementApp {
    public static final String DATABASE_URL = "jdbc:sqlite:/Users/alvishprasla/VS_Code/Java/StockMangement/Series/data/inventory24.db";

    public static void main(String[] args) {
        Database.createTables();

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Inventory Management App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createMainPanel());
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();

        // Set the frame size to cover the entire screen
        frame.setSize(bounds.width, bounds.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));

        JButton addStockButton = createButton("Add Stock", e -> AddStock.createAddStockFrame());
        JButton printInvoiceButton = createButton("Print Invoice", e -> PrintInvoiceFrame.createPrintInvoiceFrame());
        JButton financialsButton = createButton("Financials", e -> Financials.createFinancialsFrame());
        JButton showStockButton = createButton("Show Stock", e -> ShowStock.createShowStockFrame());

        panel.add(addStockButton);
        panel.add(printInvoiceButton);
        panel.add(financialsButton);
        panel.add(showStockButton);

        return panel;
    }

    private static JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }
}
