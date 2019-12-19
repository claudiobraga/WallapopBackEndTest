import java.util.Scanner;

/**
 * Created by Cláudio Braga on 10/12/2019.
 */
public class MarsRover {

    static Scanner reader = new Scanner(System.in);
    static Map map = null;
    static Rover robot = null;

    public static void main(String[] args)
        throws java.io.IOException
    {
        boolean wallapop = true;
        int opt = 0;

        try {

        do {
            masterMenu();
            opt = reader.nextInt();
            switch (opt) {
                case 1:
                    Program();
                    break;
                case 2:
                    wallapop = false;
                    break;
                default:
                    System.out.println("Wrong Option! Press Enter to move forward Please");
                    reader.next();
                    break;
            }
            cls();
        }while (wallapop);

        }catch(Exception e){
            System.out.println("Something went wrong. Please try again, following the instructions on DASHBOARD, please! ");
        }
        System.out.println("The Program is finished. Thank You.");
    }

    private static void masterMenu(){
        System.out.println("<****> DASHBOARD <****> ");
        System.out.println(" 1 -> Start the Program. ");
        System.out.println(" 2 -> Finish and Exit. ");
        System.out.println(" _ ");
    }
    private static void Program(){
        int opt = 0;
        boolean wallapop = true;
        do{
            programMenu();
            opt = reader.nextInt();
            int sizexHL = 0, sizeyVC = 0;
            switch (opt) {
                case 1:
                    System.out.printf("Insert Horizontal Map Size(Lines):");
                    sizexHL = reader.nextInt();
                    System.out.printf("Insert Vertical Map Size(Colunm): ");
                    sizeyVC = reader.nextInt();
                    map = new Map(sizexHL,sizeyVC);
                    boolean wallaPop = true;
                    do{
                        cls();
                        map.showingMarsMap();
                        int dimenl = 0, dimenc = 0;
                        System.out.printf("Would you like insert an obstacle in the Map?: ");
                        System.out.printf(" 1 -> Yes 2 -> No :");
                        int following = reader.nextInt();
                        if(following == 1){
                            System.out.printf("Insert the Horizontal Position(Nª lines): ");
                            dimenl = reader.nextInt();
                            System.out.printf("Insert the Vertical Position(Nª Colunms): ");
                            dimenc = reader.nextInt();
                            map.playingEmptyField(dimenl, dimenc, "obstacle");
                        }else{
                            System.out.printf("1 -> Continue. 2 -> Exit of the Map");
                            following = reader.nextInt();
                            if(following == 2){
                                wallaPop = false;
                            }
                        }
                    }while(wallaPop);
                    break;
                case 2:
                    cls();
                    map.showingMarsMap();
                    System.out.printf("Insert the Robot Name Please: ");
                    String name = reader.next();
                    int roverxHL = map.gethmsLine()-1;
                    int roveryVC =(map.getvmsColunm()/2);
                    robot = new Rover(name, roverxHL, roveryVC);
                    String roverLocation[] = robot.getroverPosition();
                    roverxHL = Integer.parseInt(roverLocation[0]);
                    roveryVC = Integer.parseInt(roverLocation[1]);
                    map.playingEmptyField(roverxHL,roveryVC, roverLocation[2]);
                    boolean wallapOp = true;
                    String mr_robot="", rotate="";
                    do{
                        map.showingMarsMap();
                        System.out.println(mr_robot);
                        System.out.println("<****> DASHBOARD <****> ");
                        System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right, E/e = Exit):");
                        System.out.println("r -> Turn Right ");
                        System.out.println("l -> Turn Left ");
                        System.out.println("f -> Move Forward ");
                        System.out.println("b -> Move Back ");
                        System.out.println("E -> Exit of Mars ");
                        String command = reader.next();
                        switch (command){
                            case "r":
                                robot.turnRight();
                                roverLocation=robot.getroverPosition();
                                roverxHL=Integer.parseInt(roverLocation[0]);
                                roveryVC=Integer.parseInt(roverLocation[1]);
                                map.walkingRoverField(roverxHL,roveryVC, roverLocation[2]);
                                mr_robot= "Mr. " +robot.getName()+ " Turned Right ";

                                break;
                            case "l":
                                robot.turnLeft();
                                roverLocation=robot.getroverPosition();
                                roverxHL=Integer.parseInt(roverLocation[0]);
                                roveryVC=Integer.parseInt(roverLocation[1]);
                                map.walkingRoverField(roverxHL,roveryVC, roverLocation[2]);
                                mr_robot= "Mr. " +robot.getName()+ " Turned Left ";
                                break;
                            case "f":
                                roverLocation=robot.getroverPosition();
                                roverxHL=Integer.parseInt(roverLocation[0]);
                                roveryVC=Integer.parseInt(roverLocation[1]);
                                System.out.println("2121 -> Horizontal "+robot.getName()+" Position(Line): "+ roverxHL);
                                System.out.println("2121 -> Vertical "+robot.getName()+" Position(Colunm): "+ roveryVC);
                                System.out.println("2121 -> "+robot.getName() +" is Facing: "+ roverLocation[2]);

                                if(robot.getCoordenationPosition()== 0){
                                    if(map.invalidField(roverxHL-1, roveryVC)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 1){
                                    if(map.invalidField(roverxHL-1, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 2){
                                    if(map.invalidField(roverxHL, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 3){
                                    if(map.invalidField(roverxHL+1, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 4){
                                    if(map.invalidField(roverxHL+1, roveryVC)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 5){
                                    if(map.invalidField(roverxHL+1, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 6){
                                    if(map.invalidField(roverxHL, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }

                                if(robot.getCoordenationPosition()== 7){
                                    if(map.invalidField(roverxHL-1, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                break;
                            case "b":
                                roverLocation=robot.getroverPosition();
                                roverxHL=Integer.parseInt(roverLocation[0]);
                                roveryVC=Integer.parseInt(roverLocation[1]);
                                System.out.println("2121 -> Horizontal "+robot.getName()+" Position(Line): "+ roverxHL);
                                System.out.println("2121 -> Vertical "+robot.getName()+" Position(Colunm): "+ roveryVC);
                                System.out.println("2121 -> "+robot.getName() + " is Facing: "+ roverLocation[2]);
                                if(robot.getCoordenationPosition()== 0){
                                    if(map.invalidField(roverxHL+1, roveryVC)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()==1){
                                    if(map.invalidField(roverxHL+1, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 2){
                                    if(map.invalidField(roverxHL, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 3){
                                    if(map.invalidField(roverxHL-1, roveryVC-1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC-1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC-1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC-1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 4){
                                    if(map.invalidField(roverxHL-1, roveryVC)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 5){
                                    if(map.invalidField(roverxHL-1, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL-1, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL-1, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL-1, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 6){
                                    if(map.invalidField(roverxHL, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                if(robot.getCoordenationPosition()== 7){
                                    if(map.invalidField(roverxHL+1, roveryVC+1)){
                                        mr_robot="Invalid Field";
                                    }else{
                                        if(map.emptyField(roverxHL+1, roveryVC+1)){
                                            map.clearField(roverxHL, roveryVC);
                                            map.playingEmptyField(roverxHL+1, roveryVC+1,roverLocation[2]);
                                            robot.initCoordenationPosition(roverxHL+1, roveryVC+1);
                                        }else{
                                            mr_robot="Obstacle Ahead";
                                        }
                                    }
                                }
                                break;
                            case "E":
                            case "e":
                                wallapOp=false;
                                break;
                            default:
                                break;
                        }

                    }while(wallapOp);
                    break;
                case 3:
                    wallapop=false;
                    break;
                default:
                    break;
            }
            cls();
        }while(wallapop);
    }

    private static void programMenu(){
        System.out.println("1 -> Draw the Map please: ");
        System.out.println("2 -> Rover in Mars ");
        System.out.println("3 -> Back ");
        System.out.printf(" _ ");
    }

    private static void layOut(int lin,int col){
        lin = lin+10; col = col+10;
        String map[][] = new String[lin][col];
        for(int li = 0; li < lin; li++){
            for(int co = 0; co < col; co++){
                System.out.printf("( )");
            }
            System.out.println();
        }

    }

    private static void cls(){
        for(int i = 0; i <= 2; i++){
            System.out.println(" ");
        }
    }
}
