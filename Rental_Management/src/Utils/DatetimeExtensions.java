package Utils;
// Em resumo, essa classe é útil para converter entre strings de datas e objetos Date, além de formatar datas para exibição. Ela pode ser usada em cenários onde você precisa lidar com datas em diferentes formatos ou realizar operações de conversão.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeExtensions {
    public static Date toDate(String date) throws ParseException {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(date);
            return data;

        } catch (Exception e) {
            System.out.println("Data Inválida: Error:" + e.getMessage());
            throw e;
        }

    }

    public static String toString(Date date) throws ParseException {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            return formato.format(date);

        } catch (Exception e) {
            System.out.println("Data Inválida: Error:" + e.getMessage());
            throw e;
        }

    }
}
