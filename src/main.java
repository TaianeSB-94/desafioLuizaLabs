import java.util.*;

public class main {

    public static void main(String[] args) {

        String[] input = {"900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"};

        List<String> resultado = visitas(input);
        for (String linha: resultado) {
            System.out.printf("%s%n", linha);
        }
    }

    public static List<String> visitas(String[] input) {

        Map<String, Integer> counts = new HashMap<>();
        // iterando os dominios do input
        for (String domain: input) {
            // quebrando o input pela virgula (,)
            String[] inputParts = domain.split(",");
            // quebrando o dominio pelo ponto (.)
            String[] domainParts = inputParts[1].split("\\.");
            // transformando a quantidade de visitas em inteiro
            int count = Integer.valueOf(inputParts[0]);
            String cur = "";
            // calculo
            for (int i = domainParts.length - 1; i >= 0; --i) {
                cur = domainParts[i] + (i < domainParts.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> resposta = new ArrayList<>();
        // loop nas chaves
        for (String dom: counts.keySet()) {
            int count = counts.get(dom);
            String toAdd = (count + " " + dom);
            // inserindo os dominios e seus acessos numa lista
            resposta.add(toAdd);
        }
        // ordenando de forma decrescente de acessos
        Collections.sort(resposta, Collections.reverseOrder());
        return resposta;
    }
}
