/**
 * Created by Cláudio Braga on 10/12/2019.
 */
public class Map {

    private int hmapsizel;
    private int vmapsizec;
    private String mars[][];
    private String coordenation[] = new String[8];


    public Map(int line, int colunm){
        hmapsizel = line;
        vmapsizec = colunm;
        mars = new String [hmapsizel][vmapsizec];
        loadVetor();
        loadingCoordenation();
    }


    public boolean emptyField(int line, int colunm){
        if((mars[line][colunm]).equalsIgnoreCase("  ")){
            return true;
        }
        return false;
    }
    public boolean marsRoverField(int line, int colunm){
        String mrs = mars[line][colunm];
        for(String c:coordenation){
            if(c.equalsIgnoreCase(mrs)){
                return true;
            }
        }
        return false;
    }

    public boolean invalidField(int line, int colunm){
        if(line >= hmapsizel || colunm >= vmapsizec || colunm < 0 || line < 0){
            return true;
        }
        return false;
    }
    public void playingEmptyField(int line, int colunm, String mrs){
        if(invalidField(line, colunm)){
            System.out.println("Can Not Play at this Field!");
        }else{
            if(emptyField(line, colunm)){

                mars[line][colunm]= mrs;
            }else{
                System.out.println("The Field is not Empty. Can Not Play");
            }
        }
    }

    public void clearField(int line, int colunm){
        mars[line][colunm]="  ";
    }

    public void walkingRoverField(int line, int colunm, String mrs){
        if(invalidField(line, colunm)){
            System.out.println("Invalid Field! Can Not Walk");
        }else{
            if(marsRoverField(line, colunm)){

                mars[line][colunm]= mrs;
            }else{
                System.out.println("The Field is not Empty! Can Not Walk");
            }
        }
    }

    public void loadVetor(){
        for(int i = 0; i < hmapsizel; i++){
            for(int j = 0; j < vmapsizec; j++){
                (mars[i][j])="  ";
            }
        }
    }

    public void showingMarsMap(){
        for(int li = 0; li < hmapsizel; li++){
            for(int co = 0; co < vmapsizec; co++){
                System.out.printf("("+ mars[li][co]+")");
            }
            System.out.println();
        }
    }

    public String [][] getMapa(){
        return mars;
    }

    public void setMapa(String a[][]){
        this.mars = a;
    }

    public int gethmsLine(){
        return hmapsizel;
    }

    public int getvmsColunm(){
        return vmapsizec;
    }

    private void loadingCoordenation(){
        coordenation[0] = "N";
        coordenation[1] = "Ne";
        coordenation[2] = "E";
        coordenation[3] = "Se";
        coordenation[4] = "S";
        coordenation[5] = "Sw";
        coordenation[6] = "W";
        coordenation[7] = "Nw";
    }
}

