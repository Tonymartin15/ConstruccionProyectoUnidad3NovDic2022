package modelos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import utils.JsonReader;

public class EmployeeTableModel {

  public void loadData(JTable table) throws IOException {
    List<Employee> employeesList = JsonReader.getEmployees();
    DefaultTableModel model = new DefaultTableModel() {
                public Class getColumnClass(int column) {
                    return getValueAt(0, column).getClass();
                }
    };
    table.setRowHeight(50);
    table.setModel(model);
    

    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("Apellido");
    model.addColumn("Foto");

    for (int i = 0; i < employeesList.size(); i++) {
      
      Employee e = employeesList.get(i);
      ImageIcon imageIcon = new ImageIcon(ImageIO.read(new URL(e.getPhoto())));
            Image image = getScaledImage(imageIcon.getImage(), 50, 50);
            imageIcon = new ImageIcon(image);
            Icon icon = (Icon) imageIcon;
      
      model.addRow(new Object[] { e.getId(), e.getName(), e.getLastname(),icon});
    }
    
        for (int i = 0; i < employeesList.size(); i++) {
                table.getColumnModel().getColumn(i).setPreferredWidth(50);
                table.getColumnModel().getColumn(i).setResizable(false);
        }
    }
  
  
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    
  }
