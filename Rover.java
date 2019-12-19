/**
 * Created by Cláudio Braga on 10/12/2019.
 */
public class Rover {

    private String name;
    private Map map;
    private int line;
    private int colunm;
    private int coordenatioPosition = 0;
    private String coordenation[] = new String[8];
    private String RoverMoving[] = new String[3];

    public Rover(){
    }

    public Rover(String name){
        this.name = name;
        initCoordenation();
        coordenatioPosition = 0;
    }

    public Rover(String name, Map mp){
        this.name = name;
        this.map = mp;
        initCoordenation();
        coordenatioPosition = 0;
    }

    public Rover(String name, int line, int colunm){
        this.name = name;
        this.map = new Map(line, colunm);
        initCoordenation();
        coordenatioPosition = 0;
        initPosition();
        initCoordenationPosition(line, colunm);

    }

    private void initPosition(){
        RoverMoving[0] = line +"";
        RoverMoving[1] = colunm +"";
        RoverMoving[2] = coordenation[coordenatioPosition];
    }

    public void initCoordenationPosition(int line, int colunm){
        this.line = line;
        this.colunm = colunm;
        RoverMoving[0] = line+"";
        RoverMoving[1] = colunm+"";
        RoverMoving[2] = coordenation[coordenatioPosition];
    }

    public int getCoordenationPosition(){
        return coordenatioPosition;
    }

    public void initCoordenation(){
        coordenation[0] = "N";
        coordenation[1] = "Ne";
        coordenation[2] = "E";
        coordenation[3] = "Se";
        coordenation[4] = "S";
        coordenation[5] = "Sw";
        coordenation[6] = "W";
        coordenation[7] = "Nw";
    }

    public int getLine(){
        return line;
    }

    public int getColunm(){
        return colunm;
    }

    public String[] getroverPosition(){
        return RoverMoving;
    }

    public String getName(){
        return name;
    }

    public void moveForward(){
        int position = coordenatioPosition;
        int line = Integer.parseInt(RoverMoving[0]);
        int colunm = Integer.parseInt(RoverMoving[1]);
        switch(position){
            case 0://North
                break;
            case 1://NorthEast
                break;
            case 2://East
                break;
            case 3://SouthEast
                break;
            case 4://South
                break;
            case 5://SouthWest
                break;
            case 6://West
                break;
            case 7://NorthWest
                break;
        }
    }


    public void turnLeft(){

        if(coordenatioPosition == 0){
            coordenatioPosition = 7;
        }else{
            --coordenatioPosition;
        }
        RoverMoving[0] = line +"";
        RoverMoving[1] = colunm +"";
        RoverMoving[2] = coordenation[coordenatioPosition];
    }

    public void turnRight(){
        if(coordenatioPosition == 7){
            coordenatioPosition = 0;
        }else{
            ++coordenatioPosition;
        }
        RoverMoving[0] = line +"";
        RoverMoving[1] = colunm +"";
        RoverMoving[2] = coordenation[coordenatioPosition];
    }
}