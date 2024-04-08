import java.util.HashMap;

public class Converter implements IConverter{
    private final HashMap<Character, String> cyrillicMap = new HashMap<>() {
        {
            put(' ', " ");
            put('а', "a");
            put('б', "b");
            put('в', "v");
            put('г', "g");
            put('д', "d");
            put('е', "e");
            put('ё', "yo");
            put('ж', "zh");
            put('з', "z");
            put('и', "i");
            put('й', "j");
            put('к', "k");
            put('л', "l");
            put('м', "m");
            put('н', "n");
            put('о', "o");
            put('п', "p");
            put('р', "r");
            put('с', "s");
            put('т', "t");
            put('у', "u");
            put('ф', "f");
            put('х', "x");
            put('ц', "cz");
            put('ч', "ch");
            put('ш', "sh");
            put('щ', "shh");
            put('ъ', "``");
            put('ы', "y'");
            put('ь', "`");
            put('э', "e`");
            put('ю', "yu");
            put('я', "ya");
        }
    };

    private final HashMap<String, String> latinMap = new HashMap<>(){
        {
            put(" "," ");
            put("a", "а");
            put("b", "б");
            put("v", "в");
            put("g", "г");
            put("d", "д");
            put("e", "е");
            put("yo", "ё");
            put("zh", "ж");
            put("z", "з");
            put("i", "и");
            put("j", "й");
            put("k", "к");
            put("l", "л");
            put("m", "м");
            put("n", "н");
            put("o", "о");
            put("p", "п");
            put("r", "р");
            put("s", "с");
            put("t", "т");
            put("u", "у");
            put("f", "ф");
            put("x", "х");
            put("cz", "ц");
            put("ch", "ч");
            put("sh", "ш");
            put("shh", "щ");
            put("``", "ъ");
            put("y'", "ы");
            put("`", "ь");
            put("e`", "э");
            put("yu", "ю");
            put("ya", "я");
        }
    };
    @Override
    public String cyrillicToLatin(String value) {
        StringBuilder result = new StringBuilder();
        for (char symbol: value.toLowerCase().toCharArray()){
            result.append(cyrillicMap.getOrDefault(symbol, "_"));
        }
        return result.toString();
    }

    @Override
    public String latinToCyrillic(String value) {
        String thisValue = value.toLowerCase();
        StringBuilder result = new StringBuilder();
        int counter = 0;
        while (counter < thisValue.length()){
            if (counter + 3 <= thisValue.length() && latinMap.containsKey(thisValue.substring(counter, counter + 3))){
                result.append(latinMap.getOrDefault(thisValue.substring(counter, counter + 3), "_"));
                counter += 3;
            }
            else if (counter + 2 <= thisValue.length() && latinMap.containsKey(thisValue.substring(counter,counter + 2))){
                result.append(latinMap.getOrDefault(thisValue.substring(counter, counter + 2), "_"));
                counter += 2;
            }
            else {
                result.append(latinMap.getOrDefault(thisValue.substring(counter,counter + 1), "_"));
                counter++;
            }
        }
        return result.toString();
    }
}
