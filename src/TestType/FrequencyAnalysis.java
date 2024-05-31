package TestType;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalysis {
    private static void frequencyReport(String input) {
        HashMap<Character, Integer> occurrence = new HashMap<>();
        HashMap<Character, Float> percentage = new HashMap<>();
        String removeSpace = input.replaceAll("\\s+", "").toUpperCase();
        char[] strArray = removeSpace.toCharArray();
        for (char c : strArray) {
            if (occurrence.containsKey(c)) {
                occurrence.put(c, occurrence.get(c) + 1);
            } else {
                occurrence.put(c, 1);
            }
        }
        for (char c : strArray) {
            percentage.put(c, (float) occurrence.get(c) * 100 / 310);
        }
        for (Map.Entry<Character, Float> entry : percentage.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        String text =
                "Ocs yif jcs Cvtirsfcv scvsf udscvsv bfivzesocoatsv Rif, jcs Oatstsfszijs tcsoo, jio scvzcks Deuid cv jsf Msjcvi, jio yistfsvj jsf kivzsv Viatx ebbsv yif. So yif mivatmid kivz dssf, mivatmid oioosv jfsc ejsf pcsf Dsgxs jifcv. Ysvv so irsf pedd yif, im tisgbckoxsv zycoatsv zysc gvj jfsc Gtf viatxo, tesfxs miv lsjso Yefx, jio jcs ivjsfsv Kisoxs oikxsv, gfj uim mcx lsjsm cvo Ksonfisat";
        System.out.println("The result of frequency analysis of " + text + " is as followed");
        frequencyReport(text);
        String onlyCharacter = text.replaceAll("\\s+", "").replaceAll("\\.", "").replaceAll("\\,", "");
        System.out.println(onlyCharacter.length());

    }
}
