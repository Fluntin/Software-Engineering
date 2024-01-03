import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class View extends Canvas {
    Model particleModel;
    HashMap<String, Integer> plane = new HashMap<>();
    static int move;

    View(Model model) {
        particleModel = model;
        int width = 200;
        int height = 200;
        setSize(width, height);

        for (int i = 0; i < 50; i++) {
            String q1 = String.valueOf(75 + i) + "," + 75;
            String q2 = String.valueOf(125) + "," + (75 + i);
            String q3 = String.valueOf(125 - i) + "," + 125;
            String q4 = String.valueOf(75) + "," + (125 - i);

            plane.put(q1, 1);
            plane.put(q2, 1);
            plane.put(q3, 1);
            plane.put(q4, 1);
        }
    }

    public void paint(Graphics g) {
        this.setBackground(Color.BLUE);
        g.setColor(Color.BLACK);
        g.drawLine(75, 75, 125, 75);
        g.drawLine(125, 75, 125, 125);
        g.drawLine(125, 125, 75, 125);
        g.drawLine(75, 125, 75, 75);

        g.drawLine(1, 1, 1, 199);
        g.drawLine(1, 199, 199, 199);
        g.drawLine(199, 199, 199, 1);
        g.drawLine(199, 1, 1, 1);

        for (Particle particle : particleModel.getParticles()) {
            int x, y;
            x = (int) Math.round(particle.getX());
            y = (int) Math.round(particle.getY());

            if (x < 3) {
                x = 2;
            }
            if (y < 3) {
                y = 2;
            }
            if (x > 197) {
                x = 198;
            }
            if (y > 197) {
                y = 198;
            }
            
            if (particle.isMovable()) {
                if ((x >= 3) && (x <= 197) && (y >= 3) && (y <= 197)) {
                    String xy = String.valueOf(x) + "," + y;
                    if (plane.containsKey(xy) && (plane.get(xy) == -1)) {
                        g.setColor(Color.RED);
                        g.drawLine(x, y, x, y);
                    } else if (plane.containsKey(xy) && (plane.get(xy) == 1)) {
                        g.setColor(Color.RED);
                        g.drawLine(x, y, x, y);
                        plane.put(String.valueOf(x) + "," + y, -1);
                        particle.setMovable(false);
                        
                        for (int i = -1; i < 2; i++) {
                            for (int j = -1; j < 2; j++) {
                                String key = String.valueOf(x + i) + "," + String.valueOf(y + j);
                                if (!plane.containsKey(key)) {
                                    plane.put(key, 1);
                                }
                            }
                        }
                    } else {
                        g.setColor(Color.WHITE);
                        g.drawLine(x, y, x, y);
                    }
                } else {
                    g.setColor(Color.RED);
                    g.drawLine(x, y, x, y);
                    plane.put(String.valueOf(x) + "," + y, -1);
                    particle.setMovable(false);
                    
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            String key = String.valueOf(x + i) + "," + String.valueOf(y + j);
                            if (!plane.containsKey(key)) {
                                plane.put(key, 1);
                            }
                        }
                    }
                }
            } else {
                g.setColor(Color.RED);
                g.drawLine(x, y, x, y);
            }
        }
        move++;
    }

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        Simulation simulation = new Simulation(model, view);
        Manipulation manipulation = new Manipulation(model);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setSize(200, 200);
        panel.add(view);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(manipulation, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




