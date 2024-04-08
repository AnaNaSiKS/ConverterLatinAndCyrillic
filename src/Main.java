import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println(converter.cyrillicToLatin("щука чешуя ЧЕЧНЯ цыплёнок съест чушь шишка юла ёлочка"));
        System.out.println(converter.latinToCyrillic("shhuka cheshuya chechnya czy'plyonok s``est chush` shishka yula yolochka"));
    }
}