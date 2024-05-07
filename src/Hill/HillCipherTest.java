package Hill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HillCipherTest {

    @Test
    void hillEncoding_inputContainsSpace() {
        HillCipher testObject = new HillCipher();
        char[][] key = {{'H', 'I'}, {'L', 'L'}};
        assertEquals("APADJTFTWLFJ", testObject.hillEncoder("short example", key));
    }

    @Test
    void hillDecoding_shortText() {
        HillCipher decryption = new HillCipher();
        int[][] key = {{2, 3}, {3, 6}};
        assertEquals("ATTACK", decryption.hillDecoder("FKMFIO", key));
    }

    @Test
    void hillDecoding_SuZ3() {
        HillCipher decryption = new HillCipher();
        String result = "SCHWARZELOCHERSINDORTEDEREXTREMEDIEMASSEISTINIHNENSOSTARKZUSAMMENGEPRESSTDASSNICHTSIHRERENORMHOHENANZIEHUNGSKRAFTENTKOMMTNICHTEINMALDASLICHTDRINGTNACHAUSSENSCHWARZELOCHERSINDALSOQUASIUNSICHTBARWASIHNENIHRENNAMENGIBTINDENHERZENDERMEISTENGALAXIENSCHLAFTEINSUPERMASSEREICHESSCHWARZESLOCHDASDIEENTWICKLUNGDERGESAMTENGALAXIEERHEBLICHBEEINFLUSSTIMABSTANDVONMEISTEINIGENHUNDERTTAUSENDJAHRENERWACHTESZUNEUERAKTIVITATKOMMTIHMEINSTERNZUNAHEWIRDERVONDERGIGANTISCHENSCHWERKRAFTINSTUCKEGERISSENUNDSCHLIESSLICHVERSCHLUNGEN";
        String cipherText = "KSEXZZGHETHFXTCKJWFRWDEBKTNQKTGUQNIECCQYYQIPYLDWLHUCJRZZFVSYKKGUSFRNKTGOTACCRZCUVOCKPIXTLHFRPDBNLHNNSTTPDJMGHXPPWDFSYOESXECUVOWSKXHHSPLTCUVOROJBPJANHFIIGOLHKSEXZZGHETHFXTCKJWHHUCAKCCEWCPCUVOGFMVCCRJMZYLPILHANGUSFZRIPJWLHCVVELHEBIRWSJRLHKEODGJLHKSXQPPWDJBMUYJIRCCQYKTCUCVGOHFCGVEAWETHFSPNVIALHYFCUPFDJTNXTWQEMZNLHKEODGJKGTCBXMBHFSRWSPCWLGOIPUIIHKRJWMRKXWSJRWSYLWQVIDJEBDMKRSYLHTQVVKTMZMVGGVOAWCDMZCIYHNDHZBTFFYOESIPATWSCPWDLUCDANCVAEHQXTMRJWXTICKEFSYQHFLHKSEXXTHXPPIPCPSZQOQMXTYQQYIVJWKSXQIAGOMBHFINAJHFWLSFLH";
        int[][] key = {{6, 3}, {5, 3}};
        assertEquals(result, decryption.hillDecoder(cipherText, key));
    }
}

