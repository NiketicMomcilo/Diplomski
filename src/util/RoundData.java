package util;

public class RoundData {
    public int Astart, Afinish, Bstart, Bfinish, Cstart, Cfinish, Dstart, Dfinish;
    public int t, u, f1, f2;
    public int AxorT, CxorU;
    public int AxorTrotU, CxorUrotT;
    public int AddS2i, AddS2i1;
    public int S0, S1, S2i, S2i1, S2r2, S2r3;
    public int BS0, DS1;
    public int lgw = 5;


    public String toString ( ) {
        return "A ,B, C, D:" + Astart + "|" + Bstart + "|" + Cstart + "|" + Dstart + "\n" +
                "A ,B, C, D:" + Afinish + "|" + Bfinish + "|" + Cfinish + "|" + Dfinish + "\n" +
                "============================\n";
    }
}
