/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_interfaces_graficas_ddr_11;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author DiscoDurodeRoer
 */
public class FondoSwing implements Border {

    private BufferedImage mImagen = null;

    /**
     * Constructor, indicamos la imagen que queremos que se redimensione
     *
     * @param ruta ruta de la imagen
     * @throws java.io.IOException
     */
    public FondoSwing(String ruta) throws IOException {
        mImagen = ImageIO.read(new File(ruta));
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    public void setBorder(JFrame frame) {
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setBorder(this);
    }

}
