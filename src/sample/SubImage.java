package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.paint.ImagePattern;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by misiek on 2017-04-10.
 */

public class SubImage {
    static public List<Tile> getTiles(File file) {                  //podzial na podobrazki
        List<Tile> temporaryList = new ArrayList(9);
        int counter = 0 ;

        for (int i = 0 ; i < 3 ; ++i) {
            for (int j = 0 ; j < 3 ; ++j ) {
                BufferedImage image = getImageFromFile(file);
                BufferedImage part = image.getSubimage(i*140, j*140, 140, 140);
                Tile settingTile = new Tile(140, 140, part, counter++);
                settingTile.setFill(new ImagePattern(SwingFXUtils.toFXImage(settingTile.getPart(), null)));
                settingTile.setLayoutX(14 + 151*i);
                settingTile.setLayoutY(28 + 147*j);
                temporaryList.add(settingTile);
            }
        }
        return temporaryList;
    }

    static public BufferedImage getImageFromFile (File file) {          //oblsuga obrazka czystego
        try {
            BufferedImage image = ImageIO.read(file);

            if (image.getHeight() != 420 && image.getWidth() != 420) {
                Image temp = image.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                BufferedImage bi2 = new BufferedImage(420,420, BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics = bi2.createGraphics();
                graphics.drawImage(temp,0,0,null);
                graphics.dispose();
                return bi2;
            }
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
