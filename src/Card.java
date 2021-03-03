import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 03 03
 * Time:16:09
 */
public class Card {
    //牌的花色
    public String suit;
    //牌的数字
    public int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
//        return "Card{" +
//                "suit='" + suit + '\'' +
//                ", rank=" + rank +
//                '}';
        return suit + rank;
    }
}
class DeckCard {
    public static final String[] suits = {"♥","♠","♣","♦"};
    public List<Card> buyCard() {
        List<Card> cardList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cardList.add(new Card(suits[i],j));
            }
        }
        return cardList;
    }
    public void washCard(List<Card> cardList){
        for (int i = cardList.size() -1 ; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cardList,i,rand);
        }
    }
    public void swap(List<Card> cardList , int i ,int j){
        Card tmp = cardList.get(i);
        cardList.set(i,cardList.get(j));
        cardList.set(j,tmp);
    }
}