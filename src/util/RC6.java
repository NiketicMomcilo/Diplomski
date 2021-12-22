package util;

import java.util.ArrayList;

public class RC6 {
    public static int word = 32, rounds = 20;
    public static int[] S;
    public static int[] L;
    public static int Pw = 0xb7e15163, Qw = 0x9e3779b9; //magic constants

    public static String EncryptionPlaintext;
    public static String EncryptionUserKey;
    public static String EncryptionCypherText;

    public static String DecryptionPlaintext;
    public static String DecryptionUserKey;
    public static String DecryptionCypherText;

    public static ArrayList <RoundData> roundData = new ArrayList <RoundData>();


    // KEY SCHEDULING ALGORITHM
    public static void KeySchedule ( byte[] key ) {
        S = new int[ 2 * rounds + 4 ];
        S[ 0 ] = Pw;
        int c = key.length / ( word / 8 );
        L = bytestoWords(key, c);
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

    // ENCRYPTION ALGORITHM
    public static byte[] encryption ( byte[] encData ) {
        int temp, t, u;
        int[] temp_enc_data = new int[ encData.length / 4 ];
        for ( int i = 0 ; i < temp_enc_data.length ; i++ )
            temp_enc_data[ i ] = 0;
        temp_enc_data = convertBytetoInt(encData, temp_enc_data.length);
        int A, B, C, D;
        A = B = C = D = 0;
        A = temp_enc_data[ 0 ];
        B = temp_enc_data[ 1 ];
        C = temp_enc_data[ 2 ];
        D = temp_enc_data[ 3 ];

        RoundData rd = new RoundData();

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

        byte[] outputArr = new byte[ encData.length ];
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

                RC6.roundData.add(rd);

            } else if ( i == rounds ) {

                rd = new RoundData();

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
                rd = new RoundData();

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

                RC6.roundData.add(rd);
            }

        }


        A = A + S[ 2 * rounds + 2 ];
        C = C + S[ 2 * rounds + 3 ];

        rd.Afinish = A;
        rd.S2r2 = S[ 2 * rounds + 2 ];
        rd.Cfinish = C;
        rd.S2r3 = S[ 2 * rounds + 3 ];
        roundData.add(rd);

        temp_enc_data[ 0 ] = A;
        temp_enc_data[ 1 ] = B;
        temp_enc_data[ 2 ] = C;
        temp_enc_data[ 3 ] = D;

        System.out.println("aaaaaaaa");
        outputArr = convertIntToByte(temp_enc_data, encData.length);

        for ( int i = 0 ; i < RC6.roundData.size() ; i++ ) {
            System.out.println("Round " + i + ":");
            System.out.println(roundData.get(i));
        }

        return outputArr;
    }

    //DECRYPTION ALGORITHM
    public static byte[] decryption ( byte[] keySchArray ) {


        int temp, t, u;
        int A, B, C, D;

        A = B = C = D = 0;
        int[] temp_data_decryption = new int[ keySchArray.length / 4 ];

        for ( int i = 0 ; i < temp_data_decryption.length ; i++ )
            temp_data_decryption[ i ] = 0;

        temp_data_decryption = convertBytetoInt(keySchArray, temp_data_decryption.length);

        A = temp_data_decryption[ 0 ];
        B = temp_data_decryption[ 1 ];
        C = temp_data_decryption[ 2 ];
        D = temp_data_decryption[ 3 ];

        RoundData rd = new RoundData();

        rd.S0 = S[ 0 ];
        rd.S1 = S[ 1 ];
        rd.S2r2 = S[ 2 * rounds + 2 ];
        rd.S2r3 = S[ 2 * rounds + 3 ];

        rd.Astart = A;
        rd.Bstart = B;
        rd.Cstart = C;
        rd.Dstart = D;

        C = C - S[ 2 * rounds + 3 ];
        A = A - S[ 2 * rounds + 2 ];

        rd.BS0 = B;
        rd.DS1 = D;

        int lgw = 5;

        byte[] outputArr = new byte[ keySchArray.length ];

        for ( int i = rounds ; i >= 1 ; i-- ) {

            temp = D;
            D = C;
            C = B;
            B = A;
            A = temp;

            u = rotateLeft(D * ( 2 * D + 1 ), lgw);
            t = rotateLeft(B * ( 2 * B + 1 ), lgw);
            C = rotateRight(C - S[ 2 * i + 1 ], t) ^ u;
            A = rotateRight(A - S[ 2 * i ], u) ^ t;

        }
        D = D - S[ 1 ];
        B = B - S[ 0 ];


        temp_data_decryption[ 0 ] = A;
        temp_data_decryption[ 1 ] = B;
        temp_data_decryption[ 2 ] = C;
        temp_data_decryption[ 3 ] = D;


        outputArr = convertIntToByte(temp_data_decryption, keySchArray.length);


        return outputArr;
    }


    // CONVERT INT TO BYTE FORM
    public static byte[] convertIntToByte ( int[] integerArray, int length ) {
        byte[] int_to_byte = new byte[ length ];
        for ( int i = 0 ; i < length ; i++ ) {
            int_to_byte[ i ] = ( byte ) ( ( integerArray[ i / 4 ] >>> ( i % 4 ) * 8 ) & 0xff );
        }

        return int_to_byte;
    }

    // MAIN
    public static void main ( String[] args ) {
        String key_data;
        String given_text;
        String text_data;
        String key_value;
        String[] input_text_val;

        boolean flag = true;
        if ( flag ) {
            text_data = "45 46 47 48 c8 24 18 16 f0 d7 e4 89 20 ad 16 a1";
            key_data = "01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe";

            key_data = key_data.replace(" ", "");
            text_data = text_data.replace(" ", "");

            byte[] key = hexStringToByteArray(key_data);
            byte[] words = hexStringToByteArray(text_data);

            KeySchedule(key);

            byte[] encrypt = encryption(words);
            String encrypted_text = byteArrayToHex(encrypt);
            encrypted_text = encrypted_text.replaceAll("..", "$0 ");

            System.out.println("ciphertext: " + encrypted_text);
        } else {
            text_data = "87 f2 36 15 1c 59 96 ce aa 17 63 2e 88 c9 0d 4e";
            key_data = "01 23 45 67 89 ab cd ef 01 12 23 34 45 56 67 78 89 9a ab bc cd de ef f0 10 32 54 76 98 ba dc fe";

            key_data = key_data.replace(" ", "");
            text_data = text_data.replace(" ", "");

            byte[] key2 = hexStringToByteArray(key_data);
            byte[] X = hexStringToByteArray(text_data);
            KeySchedule(key2);
            byte[] decrypt = decryption(X);
            String decrypted_text = byteArrayToHex(decrypt);
            decrypted_text = decrypted_text.replaceAll("..", "$0 ");

            System.out.println("plaintext: " + decrypted_text);

        }


    }

    // CODE TO CONVERT HEXADECIMAL NUMBERS IN STRING TO BYTE ARRAY
    public static byte[] hexStringToByteArray ( String s ) {
        int string_len = s.length();
        byte[] data = new byte[ string_len / 2 ];
        for ( int i = 0 ; i < string_len ; i += 2 ) {
            data[ i / 2 ] = ( byte ) ( ( Character.digit(s.charAt(i), 16) << 4 ) + Character
                    .digit(s.charAt(i + 1), 16) );
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

    // CONVERT BYTE TO INT FORM
    private static int[] convertBytetoInt ( byte[] arr, int length ) {
        int[] byte_to_int = new int[ length ];
        for ( int j = 0 ; j < byte_to_int.length ; j++ ) {
            byte_to_int[ j ] = 0;
        }

        int counter = 0;
        for ( int i = 0 ; i < byte_to_int.length ; i++ ) {
            byte_to_int[ i ] = ( ( arr[ counter++ ] & 0xff ) ) |
                    ( ( arr[ counter++ ] & 0xff ) << 8 ) |
                    ( ( arr[ counter++ ] & 0xff ) << 16 ) |
                    ( ( arr[ counter++ ] & 0xff ) << 24 );
        }
        return byte_to_int;

    }


    // CONVERT BYTE TO WORDS
    private static int[] bytestoWords ( byte[] userkey, int c ) {
        int[] bytes_to_words = new int[ c ];
        for ( int i = 0 ; i < bytes_to_words.length ; i++ )
            bytes_to_words[ i ] = 0;

        for ( int i = 0, off = 0 ; i < c ; i++ )
            bytes_to_words[ i ] = ( ( userkey[ off++ ] & 0xFF ) ) | ( ( userkey[ off++ ] & 0xFF ) << 8 )
                    | ( ( userkey[ off++ ] & 0xFF ) << 16 ) | ( ( userkey[ off++ ] & 0xFF ) << 24 );

        return bytes_to_words;
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

