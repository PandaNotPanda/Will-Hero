package com.example.willhero;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    @FXML
    private Rectangle weaponChestOpen;
    @FXML
    private Rectangle weaponChestClosed;
    @FXML
    private Rectangle donut;
    @FXML
    private Rectangle coinChestOpen;
    @FXML
    private Rectangle coinChestClosed;
    @FXML
    private Button reviveButton;
    @FXML
    private Button backFromRevive;
    @FXML
    private Label currCoinsCount;
    @FXML
    private Button dashButton;
    @FXML
    private Label highScore;
    @FXML
    private Label currScore;
    @FXML
    private ImageView title;
    @FXML
    private Button newGameButton;
    @FXML
    private Button pauseButton;
    @FXML
    private Button resButton;
    @FXML
    private Button restartButton;
    @FXML
    private Button saveButton;
    @FXML
    private VBox pauseBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button load1;
    @FXML
    private Button load2;
    @FXML
    private Button load3;
    @FXML
    private Button back;
    @FXML
    private AnchorPane saveAnchor;
    @FXML
    private Rectangle heroRect;
    @FXML
    private Rectangle orcRect;
    @FXML
    private Rectangle island1;
    @FXML
    private Rectangle island2;
    @FXML
    private Rectangle island3;
    @FXML
    private Rectangle island4;
    @FXML
    private Rectangle island5;
    @FXML
    private Rectangle island6;
    @FXML
    private Rectangle island7;
    @FXML
    private Rectangle island8;
    @FXML
    private Rectangle island9;
    @FXML
    private Rectangle coin1;
    @FXML
    private Rectangle coin2;
    @FXML
    private Rectangle coin3;
    @FXML
    private Rectangle coin4;
    @FXML
    private Rectangle coin5;
    @FXML
    private Rectangle coin6;
    @FXML
    private Rectangle coin7;
    @FXML
    private Rectangle coin8;
    @FXML
    private Rectangle coin9;
    @FXML
    private Rectangle coin10;
    @FXML
    private Rectangle coin11;
    @FXML
    private Rectangle coin12;
    @FXML
    private Rectangle coin13;
    @FXML
    private Rectangle coin14;
    @FXML
    private Rectangle coin15;
    @FXML
    private Rectangle coin16;
    @FXML
    private Rectangle coin17;
    @FXML
    private Rectangle coin18;
    @FXML
    private Rectangle coin19;
    @FXML
    private Rectangle coin20;
    @FXML
    private Rectangle coin21;
    @FXML
    private Rectangle boss;
    @FXML
    private Rectangle deathRect;
    @FXML
    private Rectangle coinsimg;
    @FXML
    private Rectangle scoreimg;
    @FXML
    private Rectangle highscoreimg;
    @FXML
    private Rectangle orc1;
    @FXML
    private Rectangle orc2;
    @FXML
    private Rectangle orc3;
    @FXML
    private Rectangle orc4;
    @FXML
    private Rectangle orc5;
    @FXML
    private Rectangle orc6;
    @FXML
    private Rectangle orc7;
    @FXML
    private Rectangle orc8;

    private Stage stage;
    private TranslateTransition move;
    private TranslateTransition levitate;
    private Scene scene;
    private ArrayList<GameObjects> gameObjects;
    private HashMap<KeyCode, Boolean>keys = new HashMap<KeyCode, Boolean>();
    private boolean ifPaused = false;
    private boolean hasWeapon = false;
    transient private final Image img = new Image(this.getClass().getResource("helmet.png").toString());
    transient private final Image orcimg = new Image(this.getClass().getResource("orc.png").toString());
    transient private final Image smolisland = new Image(this.getClass().getResource("island.png").toString());
    transient private final Image longisland = new Image(this.getClass().getResource("longisland.png").toString());
    transient private final Image coinimg = new Image(this.getClass().getResource("coin.png").toString());
    transient private final Image bossimg = new Image(this.getClass().getResource("boss.png").toString());
    transient private final Image cointxt = new Image(this.getClass().getResource("coinstxt.png").toString());
    transient private final Image scoreimage = new Image(this.getClass().getResource("score.png").toString());
    transient private final Image hsimg = new Image(this.getClass().getResource("highscore.png").toString());
    transient private final Image chstopen = new Image(this.getClass().getResource("ChestOpen.png").toString());
    transient private final Image chstclose = new Image(this.getClass().getResource("ChestClosed.png").toString());
    transient private final Image weaponimg = new Image(this.getClass().getResource("helmet-weapon.png").toString());
    transient private final Image dont = new Image(this.getClass().getResource("donut.png").toString());
    transient private final Image horOrc = new Image(this.getClass().getResource("Horizorc.png").toString());

    private int currCoins = 0;
    private int highScoreint;

    private Parent Proot;
    private Scene Pscene;
    private Parent Sroot;
    private Scene savescene;
    private Point2D heroVelocity = new Point2D(0,0);
    private AnimationTimer animationTimer;
    private AnimationTimer orcTimer;
    private AnimationTimer orcTimer2;
    private AnimationTimer orcTimer3;
    private AnimationTimer orcTimer4;
    private AnimationTimer orcTimer5;
    private AnimationTimer orcTimer7;
    private AnimationTimer orcTimer8;
    private AnimationTimer bossTimer;
    private static int currentScore;
    private double mytime = 0.0;
    private double mytime2 = 0.0;
    private double mytime3 = 0.0;
    private TranslateTransition bounce = new TranslateTransition();


    @FXML
    private AnchorPane anchorpane;

    private Boolean mouseclicked = false;

    Game game = new Game();
    currScoreSerialize Save1 = new currScoreSerialize();
    currScoreSerialize Save2 = new currScoreSerialize();
    currScoreSerialize Save3 = new currScoreSerialize();
    currScoreSerialize Load2 = new currScoreSerialize();
    currScoreSerialize Load3 = new currScoreSerialize();
    currScoreSerialize Load1 = new currScoreSerialize();
    currScoreSerialize SaveforRevive = new currScoreSerialize();
    ScoreandCoin scoreandcoins = new ScoreandCoin();


    public GameController() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (this.heroRect != null && coinsimg != null) {
            heroRect.setFill(new ImagePattern(img));
            heroRect.setStrokeWidth(0);
            orcRect.setFill(new ImagePattern(orcimg));
            coinsimg.setFill(new ImagePattern(cointxt));
            coinsimg.setStrokeWidth(0);
            highscoreimg.setFill(new ImagePattern(hsimg));
            highscoreimg.setStrokeWidth(0);
            scoreimg.setFill(new ImagePattern(scoreimage));
            scoreimg.setStrokeWidth(0);
            orc1.setFill(new ImagePattern(orcimg));
            orc2.setFill(new ImagePattern(orcimg));
            orc3.setFill(new ImagePattern(orcimg));
            orc4.setFill(new ImagePattern(orcimg));
            orc5.setFill(new ImagePattern(horOrc));
            orc6.setFill(new ImagePattern(orcimg));
            orc7.setFill(new ImagePattern(orcimg));
            orc8.setFill(new ImagePattern(horOrc));
            coinChestClosed.setFill((new ImagePattern(chstclose)));
            coinChestOpen.setFill((new ImagePattern(chstopen)));
            weaponChestClosed.setFill((new ImagePattern(chstclose)));
            weaponChestOpen.setFill((new ImagePattern(chstopen)));
            if (donut != null){
                donut.setFill((new ImagePattern(dont)));
                donut.setStrokeWidth(0);
            }

            heroRect.translateXProperty().addListener((obj, old, nou) -> {
                int move = nou.intValue();
                if (move > 200 && move < 3950) {
                    anchorPane.setLayoutX(-(move - 200));
                    pauseButton.setLayoutX(move + 905);
                    dashButton.setLayoutX(move-143);
                    scoreimg.setLayoutX(move + 440);
                    currScore.setLayoutX(move+760);
                    highscoreimg.setLayoutX(move - 370);
                    highScore.setLayoutX(move+98);
                    coinsimg.setLayoutX(move + 460);
                    currCoinsCount.setLayoutX(move+760);

                }
            });
        }

        move = new TranslateTransition();
        move.setNode(title);
        move.setByY(-20);
        move.setAutoReverse(true);
        move.setDuration(Duration.millis(650));
        move.setCycleCount(TranslateTransition.INDEFINITE);
        move.play();

        ScoreandCoin scoreandcoins2 = new ScoreandCoin();

        try {
            FileInputStream fis = new FileInputStream("SaveScoreandCoins.txt");
            ObjectInputStream in = new ObjectInputStream(fis);
            scoreandcoins2 = (ScoreandCoin) in.readObject();
            fis.close();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        currCoins = scoreandcoins2.getTotalCoins();
        highScoreint = scoreandcoins2.getHighScore();

        animationTimer = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 100;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (heroRect!=null) {
                    double currX = heroRect.getLayoutX();
                    double curry = heroRect.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime = 0;
                        mouseclicked = false;
                    }
                    heroRect.relocate(newX, newY);
                    previousVelocity = velocityY;
                    mytime += .001;
                }

                if (island1 != null){
                    assert heroRect != null;
                    island1.setFill(new ImagePattern(smolisland));
                    island1.setStrokeWidth(0);
                    heroIsland(heroRect,island1);
                }

                if (island2 != null){
                    island2.setFill(new ImagePattern(longisland));
                    island2.setStrokeWidth(0);
                    heroIsland(heroRect,island2);
                }

                if (island3 != null){
                    island3.setFill(new ImagePattern(smolisland));
                    island3.setStrokeWidth(0);
                    heroIsland(heroRect,island3);
                }

                if (island4 != null){
                    island4.setFill(new ImagePattern(smolisland));
                    island4.setStrokeWidth(0);
                    heroIsland(heroRect,island4);
                }

                if (island5 != null){
                    island5.setFill(new ImagePattern(smolisland));
                    island5.setStrokeWidth(0);
                    heroIsland(heroRect,island5);
                }

                if (island6 != null){
                    island6.setFill(new ImagePattern(smolisland));
                    island6.setStrokeWidth(0);
                    heroIsland(heroRect,island6);
                }

                if (island7 != null){
                    island7.setFill(new ImagePattern(longisland));
                    island7.setStrokeWidth(0);
                    heroIsland(heroRect,island7);
                }

                if (island8 != null){
                    island8.setFill(new ImagePattern(longisland));
                    island8.setStrokeWidth(0);
                    heroIsland(heroRect,island8);
                }

                if (island9 != null){
                    island9.setFill(new ImagePattern(longisland));
                    island9.setStrokeWidth(0);
                    heroIsland(heroRect,island9);
                }


                if (island1!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island1);
                    orcIsland(orc1,island1);
                    orcIsland(orc2,island1);
                    orcIsland(orc3,island1);
                    orcIsland(orc4,island1);
                    orcIsland(orc5,island1);
                    orcIsland(orc6,island1);
                    orcIsland(orc7,island1);

                }
                if (island2!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island2);
                    orcIsland(orc1,island2);
                    orcIsland(orc2,island2);
                    orcIsland(orc3,island2);
                    orcIsland(orc4,island2);
                    orcIsland(orc5,island2);
                    orcIsland(orc6,island2);
                    orcIsland(orc7,island2);
                }
                if (island3!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island3);
                    orcIsland(orc1,island3);
                    orcIsland(orc2,island3);
                    orcIsland(orc3,island3);
                    orcIsland(orc4,island3);
                    orcIsland(orc5,island3);
                    orcIsland(orc6,island3);
                    orcIsland(orc7,island3);
                }
                if (island4!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island4);
                    orcIsland(orc1,island4);
                    orcIsland(orc2,island4);
                    orcIsland(orc3,island4);
                    orcIsland(orc4,island4);
                    orcIsland(orc5,island4);
                    orcIsland(orc6,island4);
                    orcIsland(orc7,island4);
                }
                if (island5!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null){
                    orcIsland(orcRect,island5);
                    orcIsland(orc1,island5);
                    orcIsland(orc2,island5);
                    orcIsland(orc3,island5);
                    orcIsland(orc4,island5);
                    orcIsland(orc6,island5);
                    orcIsland(orc7,island5);
                }
                if (island6!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island6);
                    orcIsland(orc1,island6);
                    orcIsland(orc2,island6);
                    orcIsland(orc3,island6);
                    orcIsland(orc4,island6);
                    orcIsland(orc6,island6);
                    orcIsland(orc7,island6);
                }
                if (island7!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island7);
                    orcIsland(orc1,island7);
                    orcIsland(orc2,island7);
                    orcIsland(orc3,island7);
                    orcIsland(orc4,island7);
                    orcIsland(orc6,island7);
                    orcIsland(orc7,island7);
                }
                if (island8!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island8);
                    orcIsland(orc1,island8);
                    orcIsland(orc2,island8);
                    orcIsland(orc3,island8);
                    orcIsland(orc4,island8);
                    orcIsland(orc5,island8);
                    orcIsland(orc6,island8);
                    orcIsland(orc7,island8);
                }
                if (island9!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    orcIsland(orcRect,island9);
                    orcIsland(orc1,island9);
                    orcIsland(orc2,island9);
                    orcIsland(orc3,island9);
                    orcIsland(orc4,island9);
                    orcIsland(orc5,island9);
                    orcIsland(orc6,island9);
                    orcIsland(orc7,island9);
                }

                if (heroRect!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                    heroOrc(heroRect,orcRect);
                    heroOrc(heroRect,orc1);
                    heroOrc(heroRect,orc2);
                    heroOrc(heroRect,orc3);
                    heroOrc(heroRect,orc4);
                }


                if (boss != null && island9!= null){
                    boss.setFill(new ImagePattern(bossimg));
                    boss.setStrokeWidth(0);
                    if (boss.getBoundsInParent().intersects(island9.getBoundsInParent())) {
                        boss.setLayoutY(boss.getLayoutY()-220);
                        mytime3=0;
                    }
                }

                if (donut != null){
                    assert heroRect != null;
                    if (heroRect.getBoundsInParent().intersects(donut.getBoundsInParent())){
                        Parent donroot = null;
                        try {
                            donroot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("winner.fxml")));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try{
                            animationTimer.stop();
                            Stage donstage = (Stage) deathRect.getScene().getWindow();
                            Scene donscene = new Scene(donroot);
                            donstage.setScene(donscene);
                            donstage.show();
                        }
                        catch (NullPointerException e){
                            System.out.println("Null Pointer");
                        }

                    }
                }

                if (coinChestClosed != null){
                    if (heroRect.getBoundsInParent().intersects(coinChestClosed.getBoundsInParent())){
                        coinChestClosed.relocate(1479, 560);
                        coinChestOpen.relocate(1519, 363);
                        currCoins+=50;
                        currCoinsCount.setText(String.valueOf(currCoins));
                    }
                }

                if (weaponChestClosed != null){
                    if (heroRect.getBoundsInParent().intersects(weaponChestClosed.getBoundsInParent())){
                        weaponChestClosed.relocate(2324, 575);
                        weaponChestOpen.relocate(2364, 388);
                        heroRect.setFill(new ImagePattern(weaponimg));
                        heroRect.setWidth(81.25);
                        heroRect.setHeight(54.625);
                        hasWeapon = true;
                    }
                }

                coincollect(coin1);
                coincollect(coin2);
                coincollect(coin3);
                coincollect(coin4);
                coincollect(coin5);
                coincollect(coin6);
                coincollect(coin7);
                coincollect(coin8);
                coincollect(coin9);
                coincollect(coin10);
                coincollect(coin11);
                coincollect(coin12);
                coincollect(coin13);
                coincollect(coin14);
                coincollect(coin15);
                coincollect(coin16);
                coincollect(coin17);
                coincollect(coin18);
                coincollect(coin19);
                coincollect(coin20);
                coincollect(coin21);


                if (orc5!= null && heroRect!= null) {
                    if (heroRect.getBoundsInParent().intersects(orc5.getBoundsInParent())) {
                        heroRect.setLayoutX(heroRect.getLayoutX()-30);
                    }
                }

                if (orc8!= null && heroRect!= null) {
                    if (heroRect.getBoundsInParent().intersects(orc8.getBoundsInParent())) {
                        heroRect.setLayoutX(heroRect.getLayoutX()-30);
                    }
                }

                if (orc6 != null){
                    if (!hasWeapon){
                        if (heroRect.getBoundsInParent().intersects(orc6.getBoundsInParent())){
                            orc6.setTranslateX(orc6.getTranslateX()+20);
                        }
                    }
                    else{
                        if (heroRect.getBoundsInParent().intersects(orc6.getBoundsInParent())){
                            orc6.relocate(500, 500);
                        }
                    }
                }

                if (orc7 != null){
                    if (!hasWeapon){
                        if (heroRect.getBoundsInParent().intersects(orc7.getBoundsInParent())){
                            orc7.setTranslateX(orc7.getTranslateX()+20);
                        }
                    }
                    else{
                        if (heroRect.getBoundsInParent().intersects(orc7.getBoundsInParent())){
                            orc7.relocate(500, 500);
                        }
                    }
                }


                if (deathRect != null){
                    island4.setStrokeWidth(0);
                    if (deathRect!=null && orcRect!=null && orc1!=null && orc2!=null && orc3!=null && orc4!=null && orc5!=null && orc6!=null && orc7!=null && orc8!=null) {
                        deathRect(orcRect,deathRect);
                        deathRect(orc1,deathRect);
                        deathRect(orc2,deathRect);
                        deathRect(orc3,deathRect);
                        deathRect(orc4,deathRect);
                        deathRect(orc5,deathRect);
                        deathRect(orc6,deathRect);
                        deathRect(orc7,deathRect);
                        deathRect(orc8,deathRect);

                    }
                    if (heroRect.getBoundsInParent().intersects(deathRect.getBoundsInParent()) || heroRect.getBoundsInParent().intersects(boss.getBoundsInParent())) {
                        scoreandcoins.setHighScore(highScoreint);
                        scoreandcoins.setTotalCoins(currCoins);
                        try {
                            FileOutputStream fos = new FileOutputStream("SaveScoreandCoins.txt");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(scoreandcoins);
                            oos.close();
                            fos.close();
                            System.out.println("Serialized");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        animationTimer.stop();

                        Parent revroot = null;
                        try {
                            revroot = FXMLLoader.load(getClass().getResource("ReviveMenu.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage revstage = (Stage)(deathRect.getScene().getWindow());
                        Scene revscene = new Scene(revroot);
                        if (revstage != null){
                            revstage.setScene(revscene);
                            revstage.show();
                        }

                        if (currCoins < 100 && reviveButton!= null){
                            reviveButton.setOpacity(50);
                            reviveButton.setDisable(false);
                        }
                    }
                }
            }
        };

        orcTimer = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orcRect!=null) {
                    double currX = orcRect.getLayoutX();
                    double curry = orcRect.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orcRect.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };
        orcTimer2 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc1!=null) {
                    double currX = orc1.getLayoutX();
                    double curry = orc1.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc1.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };
        orcTimer3 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc2!=null) {
                    double currX = orc2.getLayoutX();
                    double curry = orc2.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc2.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };

        orcTimer4 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc3!=null) {
                    double currX = orc3.getLayoutX();
                    double curry = orc3.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc3.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };

        orcTimer5 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc4!=null) {
                    double currX = orc4.getLayoutX();
                    double curry = orc4.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc4.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };


        TranslateTransition horizontalOrc = new TranslateTransition();
        horizontalOrc.setNode(orc5);
        horizontalOrc.setByX(100);
        horizontalOrc.setAutoReverse(true);
        horizontalOrc.setDuration(Duration.millis(600));
        horizontalOrc.setCycleCount(TranslateTransition.INDEFINITE);
        horizontalOrc.play();

        orcTimer7 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc6!=null) {
                    double currX = orc6.getLayoutX();
                    double curry = orc6.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc6.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };

        orcTimer8 = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (orc7!=null) {
                    double currX = orc7.getLayoutX();
                    double curry = orc7.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime2, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime2 = 0;
                        mouseclicked = false;
                    }
                    orc7.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime2 += .001;
                }
            }
        };

        TranslateTransition horizontalOrc2 = new TranslateTransition();
        horizontalOrc2.setNode(orc8);
        horizontalOrc2.setByX(50);
        horizontalOrc2.setAutoReverse(true);
        horizontalOrc2.setDuration(Duration.millis(600));
        horizontalOrc2.setCycleCount(TranslateTransition.INDEFINITE);
        horizontalOrc2.play();

        bossTimer = new AnimationTimer() {
            double velocityY = 0.0;
            final double gravity = 40;
            double previousVelocity = 0;
            @Override
            public void handle(long l) {
                if (boss!=null) {
                    double currX = boss.getLayoutX();
                    double curry = boss.getLayoutY();
                    velocityY = gravity*.5* Math.pow(mytime3, 2);
                    double deltaY = velocityY;
                    double newX = currX;
                    double newY = curry + deltaY;
                    if (mouseclicked) {
                        velocityY = 0;
                        mytime3 = 0;
                        mouseclicked = false;
                    }
                    boss.relocate(newX , newY);
                    previousVelocity = velocityY;
                    mytime3 += .001;
                }
            }
        };


        animationTimer.start();
        orcTimer.start();
        orcTimer2.start();
        orcTimer3.start();
        orcTimer4.start();
        orcTimer5.start();
        orcTimer7.start();
        orcTimer8.start();
        bossTimer.start();

        if (this.highScore!= null) {
            highScore.setText(String.valueOf(highScoreint));
        }
        if (this.currCoinsCount != null) {
            currCoinsCount.setText(String.valueOf(currCoins));
        }
        if (this.currScore!=null) {
            currScore.setText(String.valueOf(currentScore));
        }

    }

    public void backFromRevive(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void coincollect(Rectangle rectangle){
        if (rectangle != null){
            rectangle.setFill(new ImagePattern(coinimg));
            if (heroRect.getBoundsInParent().intersects(rectangle.getBoundsInParent())){
                rectangle.relocate(800, 800);
                currCoins += 1;
                currCoinsCount.setText(String.valueOf(currCoins));
            }
        }
    }

    @FXML
    public void dash() throws IOException, ClassNotFoundException {

        heroRect.setTranslateX(heroRect.getTranslateX() + 30);
        currentScore+=1;
        currScore.setText(String.valueOf(currentScore));
        if (currentScore>highScoreint) {
            highScoreint = currentScore;
            highScore.setText(String.valueOf(highScoreint));
        }
        if (heroVelocity.getY() < 10){
            heroVelocity = heroVelocity.add(1,0);
        }
        mouseclicked = true;

    }


    public void heroIsland(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent())) {
            rectangle1.setTranslateY(rectangle1.getTranslateY() - 80);
            mytime = 0;
        }
    }

    public void orcIsland(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent())) {
            rectangle1.setTranslateY(rectangle1.getTranslateY() - 50);
            mytime2 = 0;
        }
    }

    public void heroOrc(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent())) {
            rectangle2.setTranslateX(rectangle2.getTranslateX() + 20);
        }

    }

    public void deathRect(Rectangle rectangle1, Rectangle rectangle2) {
        if(rectangle1.getBoundsInParent().intersects(rectangle2.getBoundsInParent())) {
            rectangle1.setOpacity(0);
        }
    }

    public void save1(){
        try{
            Save1.setCurrentScore(currentScore);
            FileOutputStream fos = new FileOutputStream("Save1.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Save1);
            oos.close();
            fos.close();
            System.out.println("Serialized");
        }
        catch (IOException e){
            System.out.println("IOException ho gaya");
        }
    }

    public void load1(MouseEvent event) throws Exception {
        try {
            FileInputStream fis = new FileInputStream("Save1.txt");
            ObjectInputStream in = new ObjectInputStream(fis);

            Load3 = (currScoreSerialize) in.readObject();
            in.close();
            fis.close();
            stage = (Stage) (load1.getScene().getWindow());
            stage.close();
        }
        catch (IOException | ClassNotFoundException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Could Not Find Saved Game");
            alert.setHeaderText("No saved game has been detected in this slot");
            alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
            Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
            stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));
            alert.show();
            System.out.println("No save found");
        }

    }



    public void save2(){
        try{
            File f = new File("Save2.txt");
            if (f.exists()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Overwrite");
                alert.setHeaderText("Save 2 already exists. Do you wish to overwrite Save 2?");
                alert.setContentText("All existing data will be lost");
                alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
                Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
                stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));

                if (alert.showAndWait().get() == ButtonType.OK){
                    Save2.setCurrentScore(currentScore);
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Save3);
                    oos.close();
                    fos.close();
                    System.out.println("Serialized");
                }
            }
            else{
                Save2.setCurrentScore(currentScore);
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Save3);
                oos.close();
                fos.close();
                System.out.println("Serialized");
            }
        }
        catch (IOException e){
            System.out.println("IOException ho gaya");
        }
    }

     public void load2(){
        try {
            FileInputStream fis = new FileInputStream("Save1.txt");
            ObjectInputStream in = new ObjectInputStream(fis);
            Load1 = (currScoreSerialize) in.readObject();
            System.out.println("Deserialized");
            System.out.println(Load1.getCurrentScore());
            in.close();
            fis.close();
            System.out.println("Deserialized");
            stage = (Stage) (load1.getScene().getWindow());
            stage.close();
        }
        catch (IOException | ClassNotFoundException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Could Not Find Saved Game");
            alert.setHeaderText("No saved game has been detected in this slot");
            alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
            Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
            stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));
            alert.show();
            System.out.println("No save found");
        }
    }

    public void save3(){
        try{
            File f = new File("Save3.txt");
            if (f.exists()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Overwrite");
                alert.setHeaderText("Save 3 already exists. Do you wish to overwrite Save 3?");
                alert.setContentText("All existing data will be lost");
                alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
                Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
                stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));

                if (alert.showAndWait().get() == ButtonType.OK){
                    Save3.setCurrentScore(currentScore);
                    FileOutputStream fos = new FileOutputStream(f);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Save3);
                    oos.close();
                    fos.close();
                    System.out.println("Serialized");
                }
            }
            else{
                Save3.setCurrentScore(currentScore);
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Save3);
                oos.close();
                fos.close();
                System.out.println("Serialized");

            }
        }
        catch (IOException e){
            System.out.println("IOException ho gaya");
        }
    }

    public void load3(){
        try {
            FileInputStream fis = new FileInputStream("Save1.txt");
            ObjectInputStream in = new ObjectInputStream(fis);
            Load2 = (currScoreSerialize) in.readObject();
            in.close();
            fis.close();
            System.out.println("Deserialized");
            stage = (Stage) (load1.getScene().getWindow());
            stage.close();
        }
        catch (IOException | ClassNotFoundException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Could Not Find Saved Game");
            alert.setHeaderText("No saved game has been detected in this slot");
            alert.setGraphic(new ImageView(this.getClass().getResource("helmet_smol.png").toString()));
            Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
            stg.getIcons().add(new Image(this.getClass().getResource("helmet.png").toString()));
            alert.show();
            System.out.println("No save found");
        }
    }

    public void pause(MouseEvent event) throws Exception {
        Stage pauseStage = new Stage(StageStyle.UNDECORATED);
        Proot = FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        Pscene = new Scene(Proot);
        Pscene.getStylesheets().add(getClass().getResource("herostyle.css").toExternalForm());
        pauseStage.initStyle(StageStyle.UNDECORATED);
        pauseStage.initOwner(stage);
        ifPaused = true;
        pauseStage.setScene(Pscene);
        pauseStage.initModality(Modality.APPLICATION_MODAL);
        pauseStage.showAndWait();
        event.consume();
    }

    public void resume(MouseEvent event) throws Exception{
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
        stage = (Stage) stage.getOwner();
        //resButton.getScene().getWindow().hide();
    }


    public void reviveConfirm(MouseEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Revive");
        alert.setGraphic(new ImageView(this.getClass().getResource("wings.png").toString()));
        Stage stg = (Stage) alert.getDialogPane().getScene().getWindow();
        stg.getIcons().add(new Image(this.getClass().getResource("helmet_smol.png").toString()));
        alert.setHeaderText("Do you wish to use 100 Coins to revive?");
        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) (reviveButton.getScene().getWindow());
            stage.close();
        }
    }

    public void saveGameforRevive() throws IOException {
        File f = new File("Revive.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(game);
        oos.close();
        fos.close();
    }

    public void revive() throws IOException, ClassNotFoundException {
        saveGameforRevive();
        FileInputStream fis = new FileInputStream("Revive.txt");
        ObjectInputStream in = new ObjectInputStream(fis);
        game = (Game) in.readObject();
        in.close();
        fis.close();
        stage = (Stage) (reviveButton.getScene().getWindow());
        stage.close();
        game.start(stage);
        currCoins-=100;
        currCoinsCount.setText(String.valueOf(currCoins));
    }

    public void newGame(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root.getChildren().add(heroRect);
        scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void loadGame(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("LoadFXML.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backButton(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void restartButton(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        stage = (Stage) restartButton.getScene().getWindow();
        stage.close();
        stage.close();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backFromSave(MouseEvent event) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void saveButton(MouseEvent event) throws Exception {
        Stage saveStage = new Stage(StageStyle.UNDECORATED);
        Sroot = FXMLLoader.load(getClass().getResource("Save.fxml"));
        savescene = new Scene(Sroot);
        savescene.getStylesheets().add(getClass().getResource("herostyle.css").toExternalForm());
        saveStage.initOwner(saveButton.getScene().getWindow());
        saveStage.setScene(savescene);
        saveStage.showAndWait();
    }



}