package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RC6 {
    public static int word = 32, rounds = 20;
    public static int[] S;
    public static int[] L;
    public static int Pw = 0xb7e15163, Qw = 0x9e3779b9; //magic constants

    public static ArrayList <EncryptionRoundData> encryptionRoundData = new ArrayList <>();
    public static ArrayList <DectyptionRoundData> dectyptionRoundData = new ArrayList <>();

    public static byte[] encryption ( byte[] encData ) {
        int temp, t, u;
        int[] temp_enc_data = new int[ encData.length / 4 ];
        temp_enc_data = convertBytetoInt(encData, temp_enc_data.length);
        int A, B, C, D;
        A = temp_enc_data[ 0 ];
        B = temp_enc_data[ 1 ];
        C = temp_enc_data[ 2 ];
        D = temp_enc_data[ 3 ];

        EncryptionRoundData rd = new EncryptionRoundData();

        rd.S0 = S[ 0 ];
        rd.S1 = S[ 1 ];

        rd.S2r2 = S[ 2 * rounds + 2 ];
        rd.S2r3 = S[ 2 * rounds + 3 ];

        rd.Astart = A;
        rd.Bstart = B;
        rd.Cstart = C;
        rd.Dstart = D;


        B = B + S[ 0 ];
        D = D + S[ 1 ];

        rd.BS0 = B;
        rd.DS1 = D;

        int lgw = 5;

        byte[] outputArr;
        for ( int i = 1 ; i <= rounds ; i++ ) {


            if ( i == 1 ) {
                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];


                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AxorT = A ^ t;

                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                rd.CxorU = C ^ u;

                rd.AxorTrotU = rotateLeft(A ^ t, u);
                rd.CxorUrotT = rotateLeft(C ^ u, t);


                A = rotateLeft(A ^ t, u) + S[ 2 * i ];
                rd.AddS2i = A;
                C = rotateLeft(C ^ u, t) + S[ 2 * i + 1 ];
                rd.AddS2i1 = C;

                temp = A;
                A = B;
                B = C;
                C = D;
                D = temp;

                rd.Afinish = A;
                rd.Bfinish = B;
                rd.Cfinish = C;
                rd.Dfinish = D;

                RC6.encryptionRoundData.add(rd);

            } else if ( i == rounds ) {

                rd = new EncryptionRoundData();

                rd.Astart = A;
                rd.Bstart = B;
                rd.Cstart = C;
                rd.Dstart = D;

                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];


                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AxorT = A ^ t;

                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                rd.CxorU = C ^ u;

                rd.AxorTrotU = rotateLeft(A ^ t, u);
                rd.CxorUrotT = rotateLeft(C ^ u, t);


                A = rotateLeft(A ^ t, u) + S[ 2 * i ];
                rd.AddS2i = A;
                C = rotateLeft(C ^ u, t) + S[ 2 * i + 1 ];
                rd.AddS2i1 = C;

                temp = A;
                A = B;
                B = C;
                C = D;
                D = temp;

                rd.Afinish = A;
                rd.Bfinish = B;
                rd.Cfinish = C;
                rd.Dfinish = D;
            } else {
                rd = new EncryptionRoundData();

                rd.Astart = A;
                rd.Bstart = B;
                rd.Cstart = C;
                rd.Dstart = D;

                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];


                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AxorT = A ^ t;

                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                rd.CxorU = C ^ u;

                rd.AxorTrotU = rotateLeft(A ^ t, u);
                rd.CxorUrotT = rotateLeft(C ^ u, t);


                A = rotateLeft(A ^ t, u) + S[ 2 * i ];
                rd.AddS2i = A;
                C = rotateLeft(C ^ u, t) + S[ 2 * i + 1 ];
                rd.AddS2i1 = C;

                temp = A;
                A = B;
                B = C;
                C = D;
                D = temp;

                rd.Afinish = A;
                rd.Bfinish = B;
                rd.Cfinish = C;
                rd.Dfinish = D;

                RC6.encryptionRoundData.add(rd);
            }

        }


        A = A + S[ 2 * rounds + 2 ];
        C = C + S[ 2 * rounds + 3 ];

        rd.Afinish = A;
        rd.S2r2 = S[ 2 * rounds + 2 ];
        rd.Cfinish = C;
        rd.S2r3 = S[ 2 * rounds + 3 ];
        encryptionRoundData.add(rd);

        temp_enc_data[ 0 ] = A;
        temp_enc_data[ 1 ] = B;
        temp_enc_data[ 2 ] = C;
        temp_enc_data[ 3 ] = D;


        outputArr = convertIntToByte(temp_enc_data, encData.length);


        return outputArr;
    }

    //DECRYPTION ALGORITHM
    public static byte[] decryption ( byte[] keySchArray ) {
        int temp, t, u;
        int A, B, C, D;

        int[] temp_data_decryption = new int[ keySchArray.length / 4 ];

        temp_data_decryption = convertBytetoInt(keySchArray, temp_data_decryption.length);

        A = temp_data_decryption[ 0 ];
        B = temp_data_decryption[ 1 ];
        C = temp_data_decryption[ 2 ];
        D = temp_data_decryption[ 3 ];

        DectyptionRoundData rd = new DectyptionRoundData();

        rd.Astart = A;
        rd.Bstart = B;
        rd.Cstart = C;
        rd.Dstart = D;

        rd.S0 = S[ 0 ];
        rd.S1 = S[ 1 ];
        rd.S2r2 = S[ 2 * rounds + 2 ];
        rd.S2r3 = S[ 2 * rounds + 3 ];
        System.out.println(Integer.toHexString(rd.S2r2));
        System.out.println(Integer.toHexString(rd.Astart));

        C = C - S[ 2 * rounds + 3 ];
        A = A - S[ 2 * rounds + 2 ];

        rd.AminS2r2 = A;
        rd.CminS2r3 = C;
        System.out.println(Integer.toHexString(rd.AminS2r2));
        int lgw = 5;
        byte[] outputArr;
        for ( int i = rounds ; i >= 1 ; i-- ) {
            if ( i == 20 ) {//first round
                temp = D;
                D = C;
                C = B;
                B = A;
                A = temp;
                rd.Ashift = A;
                rd.Bshift = B;
                rd.Cshift = C;
                rd.Dshift = D;
                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];
                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.CshiftMinS2i1 = C - S[ 2 * i + 1 ];
                rd.CshiftMinS2r3RotT = rotateRight(C - S[ 2 * i + 1 ], t);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AshiftMinS2i = A - S[ 2 * i ];
                rd.AshiftMinS2iRotU = rotateRight(A - S[ 2 * i ], u);
                C = rotateRight(C - S[ 2 * i + 1 ], t) ^ u;
                A = rotateRight(A - S[ 2 * i ], u) ^ t;
                rd.AendRound = A;
                rd.BendRound = B;
                rd.CendRound = C;
                rd.DendRound = D;
                dectyptionRoundData.add(rd);
            } else if ( i == 1 ) {//final round
                rd = new DectyptionRoundData();
                rd.Astart = A;
                rd.Bstart = B;
                rd.Cstart = C;
                rd.Dstart = D;
                temp = D;
                D = C;
                C = B;
                B = A;
                A = temp;
                rd.Ashift = A;
                rd.Bshift = B;
                rd.Cshift = C;
                rd.Dshift = D;
                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];
                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.CshiftMinS2i1 = C - S[ 2 * i + 1 ];
                rd.CshiftMinS2r3RotT = rotateRight(C - S[ 2 * i + 1 ], t);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AshiftMinS2i = A - S[ 2 * i ];
                rd.AshiftMinS2iRotU = rotateRight(A - S[ 2 * i ], u);
                C = rotateRight(C - S[ 2 * i + 1 ], t) ^ u;
                A = rotateRight(A - S[ 2 * i ], u) ^ t;
                rd.AendRound = A;
                rd.BendRound = B;
                rd.CendRound = C;
                rd.DendRound = D;
                rd.S0 = S[ 0 ];
                rd.S1 = S[ 1 ];


            } else {
                rd = new DectyptionRoundData();
                rd.Astart = A;
                rd.Bstart = B;
                rd.Cstart = C;
                rd.Dstart = D;
                temp = D;
                D = C;
                C = B;
                B = A;
                A = temp;
                rd.Ashift = A;
                rd.Bshift = B;
                rd.Cshift = C;
                rd.Dshift = D;
                rd.S2i = S[ 2 * i ];
                rd.S2i1 = S[ 2 * i + 1 ];
                u = rotateLeft(D * ( 2 * D + 1 ), lgw);
                rd.f2 = D * ( 2 * D + 1 );
                rd.u = u;
                t = rotateLeft(B * ( 2 * B + 1 ), lgw);
                rd.CshiftMinS2i1 = C - S[ 2 * i + 1 ];
                rd.CshiftMinS2r3RotT = rotateRight(C - S[ 2 * i + 1 ], t);
                rd.f1 = B * ( 2 * B + 1 );
                rd.t = t;
                rd.AshiftMinS2i = A - S[ 2 * i ];
                rd.AshiftMinS2iRotU = rotateRight(A - S[ 2 * i ], u);
                C = rotateRight(C - S[ 2 * i + 1 ], t) ^ u;
                A = rotateRight(A - S[ 2 * i ], u) ^ t;
                rd.AendRound = A;
                rd.BendRound = B;
                rd.CendRound = C;
                rd.DendRound = D;
                dectyptionRoundData.add(rd);

            }
        }
        D = D - S[ 1 ];
        B = B - S[ 0 ];
        rd.Afinish = A;
        rd.Bfinish = B;
        rd.Cfinish = C;
        rd.Dfinish = D;
        dectyptionRoundData.add(rd);
        temp_data_decryption[ 0 ] = A;
        temp_data_decryption[ 1 ] = B;
        temp_data_decryption[ 2 ] = C;
        temp_data_decryption[ 3 ] = D;
        outputArr = convertIntToByte(temp_data_decryption, keySchArray.length);
        return outputArr;
    }
    // KEY SCHEDULING ALGORITHM
    public static void KeySchedule ( byte[] key ) {
        S = new int[ 2 * rounds + 4 ];
        S[ 0 ] = Pw;
        int c = key.length / ( word / 8 );
        L = convertBytetoInt(key, c);
        for ( int i = 1 ; i < ( 2 * rounds + 4 ) ; i++ ) {
            S[ i ] = S[ i - 1 ] + Qw;
        }
        int A, B, i, j;
        A = B = i = j = 0;
        int v = 3 * Math.max(c, ( 2 * rounds + 4 ));
        for ( int s = 0 ; s < v ; s++ ) {
            A = S[ i ] = rotateLeft(( S[ i ] + A + B ), 3);
            B = L[ j ] = rotateLeft(L[ j ] + A + B, A + B);
            i = ( i + 1 ) % ( 2 * rounds + 4 );
            j = ( j + 1 ) % c;

        }
    }



    // CODE TO CONVERT HEXADECIMAL NUMBERS IN STRING TO BYTE ARRAY
    public static byte[] hexStringToByteArray ( String s ) {
        int string_len = s.length();
        byte[] data = new byte[ string_len / 2 ];
        for ( int i = 0 ; i < string_len ; i += 2 ) {
            data[ i / 2 ] = ( byte ) ( ( Character.digit(s.charAt(i), 16) << 4 ) + Character.digit(s.charAt(i + 1), 16) );
        }
        return data;
    }

    // CODE TO CONVERT BYTE ARRAY TO HEX FORMAT
    public static String byteArrayToHex ( byte[] a ) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for ( byte b : a )
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }

    // CONVERT INT TO BYTE FORM
    public static byte[] convertIntToByte ( int[] integerArray, int length ) {
        byte[] int_to_byte = new byte[ length ];
        for ( int i = 0 ; i < length ; i++ ) {
            int_to_byte[ i ] = ( byte ) ( ( integerArray[ i / 4 ] >>> ( i % 4 ) * 8 ) & 0xff );
        }

        return int_to_byte;
    }

    // CONVERT BYTE TO INT FORM
    private static int[] convertBytetoInt ( byte[] arr, int length ) {
        int[] byte_to_int = new int[ length ];
        int counter = 0;
        for ( int i = 0 ; i < byte_to_int.length ; i++ ) {
            byte_to_int[ i ] = (
                    (   arr[ counter++ ] & 0xff ) ) |
                    ( ( arr[ counter++ ] & 0xff ) << 8 ) |
                    ( ( arr[ counter++ ] & 0xff ) << 16 ) |
                    ( ( arr[ counter++ ] & 0xff ) << 24 );
        }
        return byte_to_int;

    }

    // ROTATE LEFT METHOD
    private static int rotateLeft ( int val, int pas ) {
        return ( val << pas ) | ( val >>> ( 32 - pas ) );
    }

    //ROTATE RIGHT METHOD
    private static int rotateRight ( int val, int pas ) {
        return ( val >>> pas ) | ( val << ( 32 - pas ) );
    }
}
