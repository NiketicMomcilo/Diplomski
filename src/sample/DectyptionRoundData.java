package sample;

public class DectyptionRoundData {

    public int Astart, Bstart, Cstart, Dstart;
    public int S2r2, S2r3;
    public int AminS2r2, CminS2r3;

    public int Ashift, Bshift, Cshift, Dshift;
    public int S2i, S2i1, t,u, f1, f2;
    public int AshiftMinS2i,CshiftMinS2i1;
    public int CshiftMinS2r3RotT, AshiftMinS2iRotU;
    public int AendRound, BendRound, CendRound, DendRound;

    public int S0, S1;
    public int Afinish, Bfinish, Cfinish, Dfinish;
    public int lgw = 5;

    public String toString(){
        return
                "A ,B, C, D:" + Astart + "|" + Bstart + "|" + Cstart + "|" + Dstart + "\n" +
                "A ,B, C, D:" + AendRound + "|" + BendRound + "|" + CendRound + "|" + DendRound + "\n" +
                "A ,B, C, D:" + Afinish + "|" + Bfinish + "|" + Cfinish + "|" + Dfinish + "\n" +
                "============================\n";
    }

}
