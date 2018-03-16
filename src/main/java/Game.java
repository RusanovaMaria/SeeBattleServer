import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class Game {

    private Gamer firstGamer;
    private Gamer secondGamer;
    private GameField gameField;
    private int [] [] firstGameField;
    private int [] [] secondGameField;
    private String firstGamerName;
    private String secondGamerName;
    private PrintWriter firstWriter;
    private PrintWriter secondWriter;
    private Scanner firstScanner;
    private Scanner secondScanner;

    Game(Gamer firstGamer, Gamer secondGamer){
           this.firstGamer = firstGamer;
           this.secondGamer = secondGamer;

           firstScanner = firstGamer.gerScanner();
           secondScanner = secondGamer.gerScanner();

           firstWriter = firstGamer.getPrintWriter();
           secondWriter = secondGamer.getPrintWriter();
    }

        public void play(){
           generateGameFields();
            int x = -1;
            int y = -1;
           while ((!(endOfTheGame(firstGameField))) && (!(endOfTheGame(secondGameField)))){
               System.out.println("not end");
            x = getCoordinateX(firstWriter, firstScanner);
            System.out.println(x);
            y = getCoordinateY(firstWriter, firstScanner);
            System.out.println(y);
            firstWriter.println(fight(x,y,secondGameField));
               if (endOfTheGame(secondGameField)){
                   firstWriter.println("Вы победили");
                   secondWriter.println("Все ваши корабли потоплены");
                  closeAllStreams();
                  break;
               } else {
                   x = getCoordinateX(secondWriter, secondScanner);
                   y = getCoordinateY(secondWriter, secondScanner);
                   secondWriter.println(fight(x, y, firstGameField));
               }
                   if (endOfTheGame(firstGameField)) {
                       System.out.println("end");
                       firstWriter.println("Вы победили");
                       secondWriter.println("Все ваши корабли потоплены");
                       closeAllStreams();
                       break;
               }
           }
        }

        private String fight(int x, int y, int [] [] gameField){
                String s = " ";
            if (gameField[x][y]==1){
                s = "Попал";
                gameField[x][y]=0;
            }  else s = "Мимо";
            return s;
    }

        private boolean endOfTheGame(int [][] gameField){
            boolean end = true;
            for (int i = 0; i < gameField.length; i++){
                for (int j = 0; j < gameField.length; j++){
                    if (gameField[i][j] == 1) end = false;
                }
            }
            return end;
        }

        private int getCoordinateX (PrintWriter writer, Scanner scanner){
        int x = -1;
         writer.println("Введите координату х");
         if (scanner.hasNext()) x = scanner.nextInt();
         return x;
        }

    private int getCoordinateY (PrintWriter writer, Scanner scanner){
        int y = -1;
        writer.println("Введите координату y");
        if (scanner.hasNext()) y = scanner.nextInt();
        return y;
    }

        private void closeAllStreams(){
            firstWriter.close();
            firstScanner.close();
            secondWriter.close();
            secondScanner.close();
        }

        private void generateGameFields(){
        gameField = new GameField();
            firstGameField = gameField.generate();
            secondGameField = gameField.generate();
        }
}
