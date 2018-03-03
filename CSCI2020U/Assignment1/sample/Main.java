package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    private static double[] avgHousingPricesByYear = {
            247381.0,264171.4,287715.3,294736.1,
            308431.4,322635.9,340253.0,363153.7
    };
    private static double[] avgCommercialPricesByYear = {
            1121585.3,1219479.5,1246354.2,1295364.8,
            1335932.6,1472362.0,1583521.9,1613246.3
    };

    private static String[] ageGroups = {
            "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
    };
    private static int[] purchasesByAgeGroup = {
            648, 1021, 2453, 3173, 1868, 2247
    };
    private static Color[] pieColours = {
            Color.AQUA, Color.GOLD, Color.DARKORANGE,
            Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
    };

    private Canvas canvas;


    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        canvas = new Canvas();

        canvas.setHeight(600);
        canvas.setWidth(800);

        root.getChildren().add(canvas);
        primaryStage.setTitle("Lab 6");
        primaryStage.setScene(scene);
        primaryStage.show();

        draw();
    }

    private void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        System.out.println("width: " + canvas.getWidth());
        System.out.println("height: " + canvas.getHeight());
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double value;
        int x = 0;
        for(int i=0; i<avgHousingPricesByYear.length;i++){
            value = avgHousingPricesByYear[i];

            //normalize the value
            /**
             * a = min scaled value
             * b = max scaled value
             * A = min value in array
             * B = max value in array
             * x = value to scale
             * a+(x-A)(b-a)/(B-A)
             */
            value = (20 + (value-avgHousingPricesByYear[0])*((canvas.getHeight()-20)-20))
                    / (avgCommercialPricesByYear[avgCommercialPricesByYear.length-1]-avgHousingPricesByYear[0]);
            gc.setFill(Color.RED);
            gc.fillRect(x, 600-value-20, 20, value);
            x+=20;


            value = avgCommercialPricesByYear[i];

            value = (20 + (value-avgCommercialPricesByYear[0])*((canvas.getHeight()-20)-20))
                    / (avgCommercialPricesByYear[avgCommercialPricesByYear.length-1]-avgCommercialPricesByYear[0]);
            gc.setFill(Color.BLUE);
            gc.fillRect(x, 600-value-20, 20, value);
            x+=30;
        }

        x+=50;

        double total =0;
        for(int i =0; i<purchasesByAgeGroup.length;i++){
            total+=purchasesByAgeGroup[i];
        }

        value = 0;
        double startAngle = 0;
        for(int i =0; i<purchasesByAgeGroup.length;i++){
            value = (purchasesByAgeGroup[i]/total)*360;
            // arcs
            gc.setFill(pieColours[i]);
            gc.fillArc(x, canvas.getHeight()/2-(300/2), 300, 300, startAngle, value, ArcType.ROUND);
            startAngle +=value;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}