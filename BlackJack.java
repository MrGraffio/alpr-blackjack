package devis;

/**
 *
 * @author Devis Belmonte
 * @version 2 Feb 2021
 */
public class BlackJack
{

    public static String[][] creazioneMazzo()
    {
        String[][] mazzoOrdinato = new String[4 * 13][2];
        int c = 0;
        for (int seme = 0; seme < 4; seme++)
        {
            for (int valore = 1; valore <= 13; valore++)
            {
                if (seme == 0)
                {
                    // Cuori
                    mazzoOrdinato[c][1] = "\u2661";
                }
                else if (seme == 1)
                {
                    // Quadri
                    mazzoOrdinato[c][1] = "\u2662";
                }
                else if (seme == 2)
                {
                    // Fiori
                    mazzoOrdinato[c][1] = "\u2663";
                }
                else
                {
                    // Picche
                    mazzoOrdinato[c][1] = "\u2660";
                }

                if (valore == 1)
                {
                    mazzoOrdinato[c][0] = "A";
                }
                else if (valore > 1 && valore < 11)
                {
                    mazzoOrdinato[c][0] = "" + valore;
                }
                else if (valore == 11)
                {
                    mazzoOrdinato[c][0] = "J";
                }
                else if (valore == 12)
                {
                    mazzoOrdinato[c][0] = "Q";
                }
                else
                {
                    mazzoOrdinato[c][0] = "K";
                }
                c++;
            }
        }
        return mazzoOrdinato;
    }

    public static String[][] mischiaMazzo(String[][] mazzoMischiato)
    {
        for (int i = 0; i < mazzoMischiato.length * 2; i++)
        {
            int rnd = (int) (Math.random() * mazzoMischiato.length);

            // Carta
            String tmp = mazzoMischiato[0][0];
            mazzoMischiato[0][0] = mazzoMischiato[rnd][0];
            mazzoMischiato[rnd][0] = tmp;

            // Seme
            tmp = mazzoMischiato[0][1];
            mazzoMischiato[0][1] = mazzoMischiato[rnd][1];
            mazzoMischiato[rnd][1] = tmp;
        }
        return mazzoMischiato;
    }

    public static String[][] daiCarta(String[][] mazzoInGioco)
    {
        String[][] tmp = new String[2][2];
        for (int i = 0; i < 2; i++)
        {
            tmp[i][0] = mazzoInGioco[i][0];
            tmp[i][1] = mazzoInGioco[i][1];
        }
        return tmp;
    }

    public static int calcolaPunteggio(String[][] mdc)
    {
        int punteggio = 0;
        for (int i = 0; i < mdc.length; i++)
        {
            if (mdc[i][0].equals("2"))
            {
                punteggio += 2;
            }
            else if (mdc[i][0].equals("3"))
            {
                punteggio += 3;
            }
            else if (mdc[i][0].equals("4"))
            {
                punteggio += 4;
            }
            else if (mdc[i][0].equals("5"))
            {
                punteggio += 5;
            }
            else if (mdc[i][0].equals("6"))
            {
                punteggio += 6;
            }
            else if (mdc[i][0].equals("7"))
            {
                punteggio += 7;
            }
            else if (mdc[i][0].equals("8"))
            {
                punteggio += 8;
            }
            else if (mdc[i][0].equals("9"))
            {
                punteggio += 9;
            }
            else if (mdc[i][0].equals("10"))
            {
                punteggio += 10;
            }
            else if (mdc[i][0].equals("J"))
            {
                punteggio += 10;
            }
            else if (mdc[i][0].equals("Q"))
            {
                punteggio += 10;
            }
            else if (mdc[i][0].equals("K"))
            {
                punteggio += 10;
            }
            else if (mdc[i][0].equals("A") && punteggio <= 21)
            {
                punteggio += 11;
            }
            else
            {
                punteggio += 1;
            }
        }
        return punteggio;
    }

    public static String[][] stampaMano(String[][] mdc)
    {
        for (int i = 0; i < mdc.length; i++)
        {
            if (i != 0 && i % 13 == 0)
            {
                System.out.println("");
            }
            System.out.print(mdc[i][0] + mdc[i][1] + " ");
        }
        System.out.println("");
        return mdc;
    }

    public static void main(String[] args)
    {
        String[][] mazzoInGioco = mischiaMazzo(creazioneMazzo());

        System.out.println("Banco: ");
        String[][] manoBanco = daiCarta(mazzoInGioco);
        stampaMano(manoBanco);
        System.out.println("Punteggio attuale: " + calcolaPunteggio(manoBanco));

//        System.out.println("Giocatore: ");
//        String[][] manoGiocatore = daiCarta(mazzoInGioco);
//        stampaMano(manoBanco);
    }
}
